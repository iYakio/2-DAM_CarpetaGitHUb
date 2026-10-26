/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC111
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        // El tema se instalaa antes de crear ninguna ventana
        FlatLightLaf.setup();
        
        // Las ventanas se crean en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() ->  new VentanaContactoEj2().setVisible(true));
        
        // crear, instanciar, un objeto persona con todos los datos que se recogen del formulario y después imprimirlo
        
        
    }
}
