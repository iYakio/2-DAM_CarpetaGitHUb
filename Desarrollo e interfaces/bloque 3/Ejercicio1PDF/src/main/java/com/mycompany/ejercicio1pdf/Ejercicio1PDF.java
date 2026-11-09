/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1pdf;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC111
 */
public class Ejercicio1PDF {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Generador de PDF");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.add(new GeneradorPDF());
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
