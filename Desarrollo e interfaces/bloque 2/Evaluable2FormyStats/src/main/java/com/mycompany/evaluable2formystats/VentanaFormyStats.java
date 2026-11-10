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


public class VentanaFormyStats extends JFrame {
    
    private boolean oscuro = false;
    
    
    private Partidas gestorPartidas = new Partidas();
    
    
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
    
    
    private JToolBar toolBar = new JToolBar();
    private JButton buttonNuevoBarra = new JButton(actionNuevo);
    private JButton buttonAbrirBarra = new JButton(actionAbrir);
    private JButton buttonGuardarBarra = new JButton(actionGuardar);
    private JButton buttonAnadirBarra = new JButton(actionAnadir);
    private JButton buttonInformeBarra = new JButton(actionGenerarInforme);
    
    
    private JLabel labelEstado = new JLabel();
    
    
    private JComboBox<String> comboVideojuego;
    private JSpinner spinnerVictorias;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaRegistrosUI;
    private PanelDibujo panelDibujo;

    public VentanaFormyStats() {
        super("Mis partidas de videojuegos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        cargarDatosEjemplo();
        
        
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel(new MigLayout("insets 15, fill", "[320!][grow,fill]", "[grow,fill]"));
        
        
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
        
        
        panelDibujo = new PanelDibujo(gestorPartidas);
        
        panelCentral.add(panelFormulario, "cell 0 0");
        panelCentral.add(panelDibujo, "cell 1 0");
        
        
        JPanel panelEstado = new JPanel(new MigLayout("insets 6 12 6 8", "[grow]", ""));
        panelEstado.add(labelEstado, "align left");
        actualizarBarraEstado();
        
        
        menuItemNuevo.setAccelerator(KeyStroke.getKeyStroke("control N"));
        menuItemAbrir.setAccelerator(KeyStroke.getKeyStroke("control O"));
        menuItemGuardar.setAccelerator(KeyStroke.getKeyStroke("control S"));
        menuItemGenerarInforme.setAccelerator(KeyStroke.getKeyStroke("control I"));
        menuItemCambiarTema.setAccelerator(KeyStroke.getKeyStroke("control T"));
        menuItemSalir.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        
       
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
        
        
        menuItemSalir.addActionListener(e -> dispose());
        
        
        setSize(920, 540);
        setLocationRelativeTo(null);
    }

    
    private void cargarDatosEjemplo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        gestorPartidas.anadir(new Partida(LocalDate.parse("02/11/2026", formatter), "NFS Pro Street", 3));
        gestorPartidas.anadir(new Partida(LocalDate.parse("02/11/2026", formatter), "Left 4 dead 2", 5));
        gestorPartidas.anadir(new Partida(LocalDate.parse("03/11/2026", formatter), "Tekken 8", 4));
        gestorPartidas.anadir(new Partida(LocalDate.parse("03/11/2026", formatter), "Fortnite", 6));
        gestorPartidas.anadir(new Partida(LocalDate.parse("04/11/2026", formatter), "Burnout 3", 2));
    }

    
    private void limpiarFormulario() {
       
        if (comboVideojuego.getItemCount() > 0) {
            comboVideojuego.setSelectedIndex(0);
        }
        spinnerVictorias.setValue(1);

        
        gestorPartidas.getLista().clear();
        cargarDatosEjemplo();

        
        actualizarModeloListaUI();
        actualizarBarraEstado();
        panelDibujo.repaint();
    }

    
    private void anadirDato() {
        String videojuego = (String) comboVideojuego.getSelectedItem();
        int victorias = (Integer) spinnerVictorias.getValue();
        LocalDate fecha = LocalDate.now();

        
        Partida nuevaPartida = new Partida(fecha, videojuego, victorias);
        gestorPartidas.anadir(nuevaPartida);

        
        actualizarModeloListaUI();
        actualizarBarraEstado();
        panelDibujo.repaint();
        
        
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
            
            gestorPartidas.getLista().clear();
            
            String linea;
            while ((linea = br.readLine()) != null) {
                
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    LocalDate fecha = LocalDate.parse(partes[0]); 
                    String videojuego = partes[1];
                    int victorias = Integer.parseInt(partes[2]);
                    
                    gestorPartidas.anadir(new Partida(fecha, videojuego, victorias));
                }
            }
            
            
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
        
        
        if (!archivo.getName().toLowerCase().endsWith(".txt")) {
            archivo = new File(archivo.getAbsolutePath() + ".txt");
        }

        try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(archivo))) {
            
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
    
    
    panelDibujo.repaint(); 
}
}