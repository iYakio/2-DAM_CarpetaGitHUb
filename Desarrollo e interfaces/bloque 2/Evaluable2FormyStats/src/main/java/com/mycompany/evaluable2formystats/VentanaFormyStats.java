/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluable2formystats;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import net.miginfocom.swing.MigLayout;

/**
 * Ventana principal que integra el menú, barra de herramientas,
 * formulario con JComboBox y JSpinner, lista de registros inferior y panel de dibujo independiente.
 * @author iYaki
 */
public class VentanaFormyStats extends JFrame {
    
    private boolean oscuro = false;
    
    // Objeto único que almacena todos los datos de partidas
    private Partidas gestorPartidas = new Partidas();
    
    // Acciones compartidas (Menú y Barra de herramientas)
    private Action actionNuevo = new AbstractAction("Nuevo") {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarFormulario();
        }
    };
    
    private Action actionAbrir = new AbstractAction("Abrir...") {
        @Override
        public void actionPerformed(ActionEvent e) {
            abrirArchivo();
        }
    };
    
    private Action actionGuardar = new AbstractAction("Guardar") {
        @Override
        public void actionPerformed(ActionEvent e) {
            guardarArchivo();
        }
    };
    
    private Action actionAnadir = new AbstractAction("Añadir") {
        @Override
        public void actionPerformed(ActionEvent e) {
            anadirDato();
        }
    };
    
    private Action actionGenerarInforme = new AbstractAction("Generar informe") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(VentanaFormyStats.this, "El informe en PDF todavía no está disponible.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    };
    
    private Action actionCambiarTema = new AbstractAction("Cambiar tema") {
        @Override
        public void actionPerformed(ActionEvent e) {
            cambiarTema();
        }
    };

    // Menú principal
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu menuArchivo = new JMenu("Archivo");
    private JMenuItem menuItemNuevo = new JMenuItem(actionNuevo);
    private JMenuItem menuItemAbrir = new JMenuItem(actionAbrir);
    private JMenuItem menuItemGuardar = new JMenuItem(actionGuardar);
    private JMenuItem menuItemGenerarInforme = new JMenuItem(actionGenerarInforme);
    private JMenuItem menuItemSalir = new JMenuItem("Salir");
    
    private JMenu menuDatos = new JMenu("Datos");
    private JMenuItem menuItemAnadir = new JMenuItem(actionAnadir);
    
    private JMenu menuVer = new JMenu("Ver");
    private JMenuItem menuItemCambiarTema = new JMenuItem(actionCambiarTema);
    
    // Barra de herramientas
    private JToolBar toolBar = new JToolBar();
    private JButton buttonNuevoBarra = new JButton(actionNuevo);
    private JButton buttonAbrirBarra = new JButton(actionAbrir);
    private JButton buttonGuardarBarra = new JButton(actionGuardar);
    private JButton buttonAnadirBarra = new JButton(actionAnadir);
    private JButton buttonInformeBarra = new JButton(actionGenerarInforme);
    
    // Barra de estado inferior
    private JLabel labelEstado = new JLabel();
    
    // Componentes del formulario y dibujo
    private JComboBox<String> comboVideojuego;
    private JSpinner spinnerVictorias;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaRegistrosUI;
    private PanelDibujo panelDibujo;

    public VentanaFormyStats() {
        super("Mis partidas de videojuegos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Cargar datos de ejemplo iniciales (mínimo 5 registros)
        cargarDatosEjemplo();
        
        // Layout principal
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel(new MigLayout("insets 15, fill", "[320!][grow,fill]", "[grow,fill]"));
        
        // --- Formulario (Izquierda) con MigLayout ---
        JPanel panelFormulario = new JPanel(new MigLayout("insets 5", "[][grow]", "[]10[]10[]10[grow]"));
        
        comboVideojuego = new JComboBox<>(new String[]{"NFS Pro Street", "Left 4 dead 2", "Tekken 8", "Fortnite", "Burnout 3"});
        spinnerVictorias = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        
        JButton buttonFormAnadir = new JButton(actionAnadir);
        
        modeloLista = new DefaultListModel<>();
        actualizarModeloListaUI();
        listaRegistrosUI = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaRegistrosUI);
        
        panelFormulario.add(new JLabel("Videojuego"), "align label");
        panelFormulario.add(comboVideojuego, "wrap, growx");
        
        panelFormulario.add(new JLabel("Partidas ganadas"), "align label");
        panelFormulario.add(spinnerVictorias, "wrap, growx");
        
        panelFormulario.add(buttonFormAnadir, "span 2, align right, wrap");
        panelFormulario.add(scrollLista, "span 2, grow, wrap");
        
        // --- Panel de Dibujo independiente (Derecha) ---
        panelDibujo = new PanelDibujo(gestorPartidas);
        
        panelCentral.add(panelFormulario, "cell 0 0");
        panelCentral.add(panelDibujo, "cell 1 0");
        
        // Barra de estado inferior
        JPanel panelEstado = new JPanel(new MigLayout("insets 6 12 6 8", "[grow]", ""));
        panelEstado.add(labelEstado, "align left");
        actualizarBarraEstado();
        
        // Atajos de teclado
        menuItemNuevo.setAccelerator(KeyStroke.getKeyStroke("control N"));
        menuItemAbrir.setAccelerator(KeyStroke.getKeyStroke("control O"));
        menuItemGuardar.setAccelerator(KeyStroke.getKeyStroke("control S"));
        menuItemGenerarInforme.setAccelerator(KeyStroke.getKeyStroke("control I"));
        menuItemCambiarTema.setAccelerator(KeyStroke.getKeyStroke("control T"));
        menuItemSalir.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        
        // Construcción de menús y barra de herramientas
        menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.add(menuItemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemGenerarInforme);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);
        
        menuDatos.add(menuItemAnadir);
        menuVer.add(menuItemCambiarTema);
        
        menuBar.add(menuArchivo);
        menuBar.add(menuDatos);
        menuBar.add(menuVer);
        
        setJMenuBar(menuBar);
        
        toolBar.setFloatable(false);
        toolBar.add(buttonNuevoBarra);
        toolBar.add(buttonAbrirBarra);
        toolBar.add(buttonGuardarBarra);
        toolBar.addSeparator();
        toolBar.add(buttonAnadirBarra);
        toolBar.add(buttonInformeBarra);
    
        add(toolBar, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelEstado, BorderLayout.SOUTH);
        
        // Eventos
        menuItemSalir.addActionListener(e -> dispose());
        
        // Dimensiones de la ventana
        setSize(920, 540);
        setLocationRelativeTo(null);
    }

    /** Carga datos iniciales de fábrica (5 registros predeterminados). */
    private void cargarDatosEjemplo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        gestorPartidas.anadir(new Partida(LocalDate.parse("02/11/2026", formatter), "NFS Pro Street", 3));
        gestorPartidas.anadir(new Partida(LocalDate.parse("02/11/2026", formatter), "Left 4 dead 2", 5));
        gestorPartidas.anadir(new Partida(LocalDate.parse("03/11/2026", formatter), "Tekken 8", 4));
        gestorPartidas.anadir(new Partida(LocalDate.parse("03/11/2026", formatter), "Fortnite", 6));
        gestorPartidas.anadir(new Partida(LocalDate.parse("04/11/2026", formatter), "Burnout 3", 2));
    }

    /** Restablece el formulario y borra las partidas añadidas volviendo al estado de fábrica de los 5 datos. */
    private void limpiarFormulario() {
        // 1. Limpiar los controles de entrada del formulario
        if (comboVideojuego.getItemCount() > 0) {
            comboVideojuego.setSelectedIndex(0);
        }
        spinnerVictorias.setValue(1);

        // 2. Vaciar todos los registros actuales y recargar exclusivamente los 5 iniciales de fábrica
        gestorPartidas.getLista().clear();
        cargarDatosEjemplo();

        // 3. Actualizar la interfaz visual (lista, barra de estado y gráfico de tarta)
        actualizarModeloListaUI();
        actualizarBarraEstado();
        panelDibujo.repaint();
    }

    /** Añade un nuevo dato desde el formulario y refresca la interfaz. */
    private void anadirDato() {
        String videojuego = (String) comboVideojuego.getSelectedItem();
        int victorias = (Integer) spinnerVictorias.getValue();
        LocalDate fecha = LocalDate.now();

        // Se crea el objeto Partida y se añade a la clase contenedora Partidas
        Partida nuevaPartida = new Partida(fecha, videojuego, victorias);
        gestorPartidas.anadir(nuevaPartida);

        // Actualizar vistas y redibujar el gráfico manteniendo los registros
        actualizarModeloListaUI();
        actualizarBarraEstado();
        panelDibujo.repaint();
        
        // Limpiar los campos del formulario tras añadir con éxito
        if (comboVideojuego.getItemCount() > 0) {
            comboVideojuego.setSelectedIndex(0);
        }
        spinnerVictorias.setValue(1);
    }

    private void actualizarModeloListaUI() {
        modeloLista.clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        for (Partida p : gestorPartidas.getLista()) {
            String texto = p.getFecha().format(formatter) + " · " + p.getVideojuego() + " · " + p.getVictorias() + " v.";
            modeloLista.addElement(texto);
        }
    }

    private void actualizarBarraEstado() {
        labelEstado.setText(gestorPartidas.getCantidadRegistros() + " registros · " + gestorPartidas.getTotalVictorias() + " partidas ganadas en total");
    }

    private void abrirArchivo() {
       JFileChooser selector = new JFileChooser();
    if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        File archivo = selector.getSelectedFile();

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(archivo))) {
            // Limpiamos la lista actual antes de cargar los datos del archivo de texto
            gestorPartidas.getLista().clear();
            
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separamos los datos por el punto y coma (;)
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    LocalDate fecha = LocalDate.parse(partes[0]); // Formato por defecto de LocalDate: yyyy-MM-dd
                    String videojuego = partes[1];
                    int victorias = Integer.parseInt(partes[2]);
                    
                    gestorPartidas.anadir(new Partida(fecha, videojuego, victorias));
                }
            }
            
            // Actualizamos la interfaz visual (lista, barra de estado y gráfico de tarta)
            actualizarModeloListaUI();
            actualizarBarraEstado();
            panelDibujo.repaint();
            
            JOptionPane.showMessageDialog(this, "Archivo TXT cargado correctamente: " + archivo.getName(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    private void guardarArchivo() {
       JFileChooser selector = new JFileChooser();
    if (selector.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File archivo = selector.getSelectedFile();
        
        // Asegurar que termine en .txt
        if (!archivo.getName().toLowerCase().endsWith(".txt")) {
            archivo = new File(archivo.getAbsolutePath() + ".txt");
        }

        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(archivo))) {
            // Recorremos cada partida y la guardamos como una línea de texto: fecha;videojuego;victorias
            for (Partida p : gestorPartidas.getLista()) {
                pw.println(p.getFecha() + ";" + p.getVideojuego() + ";" + p.getVictorias());
            }
            JOptionPane.showMessageDialog(this, "Datos guardados en TXT correctamente: " + archivo.getName(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    private void cambiarTema() {
    oscuro = !oscuro;
    if (oscuro) {
        FlatDarkLaf.setup();
    } else {
        FlatLightLaf.setup();
    }
    FlatDarkLaf.updateUI();
    
    // Forzar actualización de colores en el panel de dibujo
    panelDibujo.repaint(); 
}
}