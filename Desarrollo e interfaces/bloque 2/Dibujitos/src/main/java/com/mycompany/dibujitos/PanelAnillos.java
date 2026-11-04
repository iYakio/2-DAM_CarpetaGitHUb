/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dibujitos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author PC111
 */
public class PanelAnillos extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);           // limpia el fondo: siempre lo primero
        Graphics2D g3 = (Graphics2D) g;      // la versión moderna, con más opciones
        
        // Grosor de los anillos
        g3.setStroke(new BasicStroke(4));

        // 1. ANILLO AZUL (Arriba a la izquierda)
        g3.setColor(Color.BLUE);
        g3.drawOval(40, 120, 120, 120);

        // 2. ANILLO AMARILLO (Abajo, desplazado a la derecha del azul y más abajo)
        g3.setColor(Color.YELLOW);
        g3.drawOval(105, 185, 120, 120);

        // 3. ANILLO NEGRO (Arriba, al lado del azul con separación)
        g3.setColor(Color.BLACK);
        g3.drawOval(170, 120, 120, 120);

        // 4. ANILLO VERDE (Abajo, al lado del amarillo)
        g3.setColor(Color.GREEN);
        g3.drawOval(235, 185, 120, 120);

        // 5. ANILLO ROJO (Arriba, al lado del negro)
        g3.setColor(Color.RED);
        g3.drawOval(300, 120, 120, 120);
        
    }
    
}
