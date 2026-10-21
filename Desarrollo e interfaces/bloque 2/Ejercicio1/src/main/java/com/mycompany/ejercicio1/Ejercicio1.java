/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC111
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // El tema se instalaa antes de crear ninguna ventana
        FlatLightLaf.setup();
        
        // Las ventanas se crean en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() ->  new VentanaContacto().setVisible(true));
    }
}
