/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author PC111
 */
public class VentanaContactoEj2 extends JFrame {
    // Esto es como una clase de toda la vida
    
    // Creamos todos los componentes
    
    
    private JLabel Label_nombre_apellidos = new JLabel("Nombre y apellidos");
    private final JTextField TextField_nombre_apellido = new JTextField(30);
    
    private JLabel Label_email = new JLabel("Email");
    private final JTextField TextField_email = new JTextField(30);
    
    private JLabel Label_fecha_nacimiento = new JLabel("Fecha de nacimiento");
    private JDateChooser dateChooserFecha = new JDateChooser();                     // de JCalendar
    
    private JLabel Label_genero = new JLabel("Género");
    private final JRadioButton Radio_masculino = new JRadioButton("Masculino");
    private final JRadioButton Radio_femenino = new JRadioButton("Femenino");
    private ButtonGroup buttonGroupGenero = new ButtonGroup();                      // no se ve: solo agrupa los circulos a elegir
    
    private JLabel Label_titulacion_acceso = new JLabel("Titulación de acceso");
    private final JComboBox<String> ComboBoxTitulacion = new JComboBox<>(
                    new String[]{"FP Grado Medio", "FP Grado Superior"});
    
    private JLabel Label_observaciones = new JLabel("Observaciones");
    private JTextArea TextArea_Observaciones = new JTextArea(5, 20);
    private JScrollPane scrollObservaciones = new JScrollPane(TextArea_Observaciones);
    
    private JButton Button_Imprimir = new JButton("Imprimir");
    private JButton Button_Guardar = new JButton("Guardar");
    
    
    
    
    
    // Constructor
    
    public VentanaContactoEj2() {
        super("Formulario de maticulacion de alumnado");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Creamos en panel con Miglayout
        // config panel, config columnas, config filas
        
        
        JPanel panel = new JPanel(new MigLayout("wrap 2, insets 20, gap 12 10", "[right][grow, fill]", ""));
        
        
        // Configuramos propiedades extra de los componentes que las necesites
        buttonGroupGenero.add(Radio_masculino);
        buttonGroupGenero.add(Radio_femenino);
        
        dateChooserFecha.setDateFormatString("dd/mm/yyyy");
        dateChooserFecha.setMaxSelectableDate(new Date());                      // Esto evita que puedas seleccionar una fecha futura  a la que estás

        TextArea_Observaciones.setLineWrap(true);                           // 
        TextArea_Observaciones.setWrapStyleWord(true);
        
        
        
        
        
        // Añadimos los componentes al panel, por orden y con sus propiedades, y el panel a la vez
            
            panel.add(Label_nombre_apellidos);
            panel.add(TextField_nombre_apellido);
            panel.add(Label_email);
            panel.add(TextField_email);
            panel.add(Label_fecha_nacimiento);
            panel.add(dateChooserFecha, "growx 0");
            panel.add(Label_genero);
            panel.add(Radio_masculino, "split 2, growx 0");
            panel.add(Radio_femenino, "growx, gapright push");
            panel.add(Label_titulacion_acceso);
            panel.add(ComboBoxTitulacion);
            panel.add(Label_observaciones, "top");
            panel.add(TextArea_Observaciones, "growy, pushy");
            
            
        
            panel.add(Button_Guardar, "skip, split 2, growx 0, gapleft push, gaptop 10");
            panel.add(Button_Imprimir, "gaptop 10, growx 0");
            
            add(panel);
            
            // Ajustamos la ventana a su contenido
            pack();
            setMinimumSize(getSize());
            setLocationRelativeTo(null);
            
            Button_Guardar.addActionListener(e -> Guardar());
            
    }
    
    private void Guardar(){
        String fecha = "";
        if (dateChooserFecha.getDate() != null){
            fecha = new SimpleDateFormat("dd/mm/yyyy").format(dateChooserFecha.getDate());
            
        }
        String genero = null;
        if (Radio_masculino.isSelected()) {
            genero = "Masculino";
        } else if (Radio_femenino.isSelected()) {
            genero = "Femenino";
        } else {
            System.out.println("Prefiere no decirlo");
        }
        
        
        Alumno alumno = new Alumno(TextField_nombre_apellido.getText(), TextField_email.getText(), fecha, genero, ComboBoxTitulacion.getSelectedItem().toString(), TextArea_Observaciones.getText());
        
        System.out.println(alumno);
    }
    
    

    
    
}
