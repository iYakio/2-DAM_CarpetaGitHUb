/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3blocnotas;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PC111
 */
public class VentanaNotas extends JFrame{
   
    private boolean oscuro = false;
    
    // 1.- Creamos todos los componentes
    
    // las acciones van primero porque el menú y las barras se crean a partir de ellas.
    // Lo que hacen al pulsarlas va dentro, en actionPerforrmed()
    
    private Action actionNuevo = new AbstractAction("Nuevo") {
        @Override
        public void actionPerformed(ActionEvent e){
            TextAreaTexto.setText("");
            actualizarEstado();
        }
    };
    
    private Action actionCambiarTema = new AbstractAction("Cambiar tema"){
        @Override
        public void actionPerformed(ActionEvent e){
            cambiarTema();
        }
    };
    // Menú  
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu menuArchivo = new JMenu("Archivo");
    private JMenuItem menuItemNuevo = new JMenuItem(actionNuevo);
    private JMenuItem menuItemAbrir = new JMenuItem("Abrir");
    private JMenuItem menuItemSalir = new JMenuItem("Salir");
    
    private JMenu menuVer = new JMenu("Ver");
    private JMenuItem menuItemCambiarTema = new JMenuItem(actionCambiarTema);
    
    // Barra de herramientas
    private JToolBar toolBar = new JToolBar();
    private JButton buttonNuevoBarra = new JButton(actionNuevo);
    private JButton buttonCambiarTema = new JButton(actionCambiarTema);
    
    // Área de texto, en el centro con un scroll
    private JTextArea TextAreaTexto = new JTextArea();
    private JScrollPane scrollTexto = new JScrollPane(TextAreaTexto );
    
    // Barra de estado, abajo
    private JLabel labelEstado = new JLabel("0 caracteres");
    private JButton buttonNuevoEstado = new JButton(actionNuevo);
    
    public VentanaNotas(){
        super("Bloc de notas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // 2. Loos layouts: la ventana usa BorderLayout, que es el que trae JFrame
        // y la barra de estado es un panel con MigLayout
        //
        
        JPanel panelEstado = new JPanel(new MigLayout("insets 4 12 4 8", "[]push[]", ""));
        
        
                
         // 3. Configuramos las propiedades extra de lso componentes que las necesiten
         
         // Atajos de teclado: se ponene en las opciones del menú y salen escritos a su derecha
         
         menuItemNuevo.setAccelerator(KeyStroke.getKeyStroke("control N"));
         menuItemAbrir.setAccelerator(KeyStroke.getKeyStroke("control O"));
         menuItemSalir.setAccelerator(KeyStroke.getKeyStroke("control Q"));
         menuItemCambiarTema.setAccelerator(KeyStroke.getKeyStroke("control T"));
         
         // Si se escribe en una linea muy larga seguirá escribiendo debajo no ira a lo largo de la linea
         TextAreaTexto.setLineWrap(true);
         // Hace que no se corte las palabras cuando llegue al final del area de texto
         TextAreaTexto.setWrapStyleWord(true);
         
         
         // 4.- Añadimos los componentes al JFrame
         
         menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);
        
        menuVer.add(menuItemCambiarTema);
        menuBar.add(menuArchivo);
        menuBar.add(menuVer);
        
        
        
        toolBar.add(buttonNuevoBarra);
        toolBar.add(buttonCambiarTema);
        
        panelEstado.add(labelEstado);
        panelEstado.add(buttonNuevoEstado);
        
        setJMenuBar(menuBar);
        add(toolBar, BorderLayout.NORTH);
        add(scrollTexto, BorderLayout.CENTER);
        add(panelEstado, BorderLayout.SOUTH);
        
        // 5. Eventos (los de Nuevo y Cambiar tema están en sus acciones)
        
        menuItemAbrir.addActionListener(e -> abrir()); // Abrir llama al metodo abrir()
        menuItemSalir.addActionListener(e -> dispose()); // Salir lama a dispose()
                                                         // dispose() cierra ventana y libera recursos
                                                         
        // Cada vez que se suelta una tecla, se recuentan los caracteres (KeyListener, del bloque)
        TextAreaTexto.addKeyListener(new KeyAdapter(){
        @Override
        public void keyReleased(KeyEvent e){
            actualizarEstado();
        }
    }); 
        
        actualizarEstado();  // cuando inicia este metodo ya leerá los caracteres que hay escritos
        
        
        // 6. Tamaño fijo: un bloc de notas vacío no tiene un tamaño natural que calcular
        setSize(640, 440);
        setLocationRelativeTo(null); //que aparezca en el centro
        
        
        
}
    /** Alterna entre el tema claro y el oscuro con la ventana abierta. */
        private void cambiarTema(){
            oscuro = !oscuro;
            if (oscuro){
                FlatDarkLaf.setup();
                
            } else {
                FlatLightLaf.setup();
            }
            FlatDarkLaf.updateUI();
        }
        
        /** Elige un fichero de texto con JFileChooser y lo carga en el área de texto. */
        private void abrir(){
            JFileChooser selector = new JFileChooser();
            selector.setFileFilter(new FileNameExtensionFilter("Ficheros de texto (txt)", "txt")); //
            if (selector.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    TextAreaTexto.setText(Files.readString(selector.getSelectedFile().toPath()));
                    actualizarEstado();
                } catch (IOException ex){
                    JOptionPane.showMessageDialog(this, "No se ha podido abrir el fichero. ", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        /** Cuenta los caracteres y desactiva  << Nuevo >> si no hay nada que borrar. */
        private void actualizarEstado(){
            int caracteres = TextAreaTexto.getText().length();
            labelEstado.setText(caracteres + " caracteres");
            
            actionNuevo.setEnabled(caracteres > 0);
        }
    
}


