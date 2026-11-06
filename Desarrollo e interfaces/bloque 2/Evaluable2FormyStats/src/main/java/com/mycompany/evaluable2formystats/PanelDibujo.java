/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluable2formystats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Panel de dibujo personalizado que renderiza un gráfico de tarta (circular) leyendo de Partidas.
 * @author iYaki
 */
public class PanelDibujo extends JPanel {
    private Partidas fuenteDatos;

    public PanelDibujo(Partidas fuenteDatos) {
        this.fuenteDatos = fuenteDatos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        

        // Videojuegos configurados
        String[] juegos = {"NFS Pro Street", "Left 4 dead 2", "Tekken 8", "Fortnite", "Burnout 3"};
        Color[] colores = {
            new Color(90, 150, 210),   // Azul
            new Color(70, 180, 120),   // Verde
            new Color(240, 90, 90),    // Rojo
            new Color(245, 200, 60),   // Amarillo
            new Color(175, 100, 210)   // Morado
        };

        int[] victoriasTotales = new int[juegos.length];
        int sumaTotal = 0;

        for (Partida pItem : fuenteDatos.getLista()) {
            for (int i = 0; i < juegos.length; i++) {
                if (pItem.getVideojuego().equalsIgnoreCase(juegos[i])) {
                    victoriasTotales[i] += pItem.getVictorias();
                }
            }
        }

        for (int v : victoriasTotales) {
            sumaTotal += v;
        }

        // Dimensiones y posición de la tarta
        int diametro = Math.min(width, height) - 140;
        int xTarta = 30;
        int yTarta = 50;

        if (sumaTotal == 0) {
            g2d.drawString("No hay datos suficientes para mostrar el gráfico", xTarta, yTarta + 50);
            return;
        }

        int anguloAcumulado = 0;

        // Dibujar porciones de la tarta
        for (int i = 0; i < juegos.length; i++) {
            int anguloArc = (int) Math.round((double) victoriasTotales[i] / sumaTotal * 360);
            
            // Asegurar que el último sector cierre exactamente en los 360 grados
            if (i == juegos.length - 1) {
                anguloArc = 360 - anguloAcumulado;
            }

            g2d.setColor(colores[i]);
            g2d.fillArc(xTarta, yTarta, diametro, diametro, anguloAcumulado, anguloArc);

            // Bordes blancos/claros para separar los sectores
            g2d.setColor(getBackground());
            g2d.setStroke(new java.awt.BasicStroke(2.5f));
            g2d.drawArc(xTarta, yTarta, diametro, diametro, anguloAcumulado, anguloArc);

            anguloAcumulado += anguloArc;
        }

        // Dibujar leyenda lateral
        int xLeyenda = xTarta + diametro + 20;
        int yLeyenda = yTarta + 20;

        g2d.drawString("Leyenda:", xLeyenda, yLeyenda - 15);

        for (int i = 0; i < juegos.length; i++) {
            g2d.setColor(colores[i]);
            g2d.fillRect(xLeyenda, yLeyenda + (i * 25), 15, 15);
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawRect(xLeyenda, yLeyenda + (i * 25), 15, 15);

            g2d.drawString(juegos[i] + " (" + victoriasTotales[i] + " v.)", xLeyenda + 25, yLeyenda + (i * 25) + 12);
        }
    }
}
