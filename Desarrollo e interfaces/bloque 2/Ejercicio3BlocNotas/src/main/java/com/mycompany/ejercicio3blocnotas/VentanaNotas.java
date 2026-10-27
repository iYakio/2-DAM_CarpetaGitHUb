/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3blocnotas;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PC111
 */
public class VentanaNotas extends JFrame{
   
    
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
        
        JPanel panelEstado = new JPanel(new MigLayout("insets 4 12 "))
        
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
        
                
         // 3. Añadir propiedades a los componentes que sean necesarios y añadirlos       
}
    
}


