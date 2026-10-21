/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PC111
 */
public class VentanaContacto extends JFrame {
    // Esto es como una clase de toda la vida
    
    // Creamos todos los componentes
    private JLabel titulo = new JLabel("Escribe a secretaria");
    
    private JLabel Label_nombre = new JLabel("Nombre");
    private final JTextField TextField_nombre = new JTextField(20);
    
    private JLabel Label_correo = new JLabel("Correo");
    private final JTextField TextField_correo = new JTextField(20);
    
    private JLabel Label_asunto = new JLabel("Asunto");
    private final JComboBox<String> ComboBoxasunto = new JComboBox<>(
            new String[]{"Información sobre ciclos", "Matrícula", "Beca"});
    
    private JLabel Label_mensaje = new JLabel("Mensaje");
    private final JTextArea TextArea_mensaje = new JTextArea(5, 20);
    
    private final JCheckBox CheckBox_privacidad = new JCheckBox("He leído y acepto los términos de privacidad");
    
    private JButton Button_limpiar = new JButton("Limpiar");
    private JButton Button_enviar = new JButton("Enviar");
    
    
    // Constructor
    public VentanaContacto() {
        super("Contacto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Creamos panel con MigLayout
        // "config panel", "config columnas", "config filas"
        
        JPanel panel = new JPanel(new MigLayout("debug, wrap 2, insets 20, gap 10", "[right][grow, fill]", ""));
        
        // Configuramos propiedades extra de los componentes que las necesites
        
        titulo.putClientProperty(FlatClientProperties.STYLE_CLASS, "h2");
        TextField_correo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "nombre@correo.es");
        TextArea_mensaje.setLineWrap(true);
        TextArea_mensaje.setWrapStyleWord(true);
        panel.add(titulo, " span 2, align left, gapbottom 10"); // span 2 hace que ocupe las dos columnas
        panel.add(Label_nombre);
        panel.add(TextField_nombre);
        panel.add(Label_correo);
        panel.add(TextField_correo);
        panel.add(Label_asunto);
        panel.add(ComboBoxasunto);
        panel.add(Label_mensaje, "top"); // arriba no centrada
        panel.add(TextArea_mensaje, "growy, pushy"); // el área tambien crece a lo alto y = arriba y abajo
        panel.add(CheckBox_privacidad, "skip");
        panel.add(Button_limpiar, "skip, split 2");
        panel.add(Button_enviar);
        
        add(panel);
        
        
        Button_limpiar.addActionListener(e -> limpiar());
        Button_enviar.addActionListener(e -> enviar());
        
        
        pack();
        
        
        
        
    }
    
    // Eventos
    private void limpiar(){
        TextField_nombre.setText("");
        TextField_correo.setText("");
        ComboBoxasunto.setSelectedIndex(0);
        TextArea_mensaje.setText("");
        CheckBox_privacidad.setSelected(false);
    }

    private void enviar() {
        if (!CheckBox_privacidad.isSelected()){
            JOptionPane.showMessageDialog(this, "Hay que aceptar la politica de privacidad", "Falta un dato", JOptionPane.WARNING_MESSAGE);
            
            return;
        } 
        
            JOptionPane.showMessageDialog(this, "Mensaje enviado a secretaría: \n " + TextField_nombre.getText() + " <" + TextField_correo.getText());
            
            limpiar();
            
    }

}
