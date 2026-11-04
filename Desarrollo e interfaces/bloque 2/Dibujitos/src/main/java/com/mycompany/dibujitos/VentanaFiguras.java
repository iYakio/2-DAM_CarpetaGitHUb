/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dibujitos;

import javax.swing.JFrame;

/**
 *
 * @author PC111
 */
public class VentanaFiguras extends JFrame {

    // 1.- Creamos TODOS los componentes: aquí solo hay uno, el panel de dibujo
    private PanelFiguras panelFiguras = new PanelFiguras();
    
    public VentanaFiguras(){
        super("Figuras básicas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // 2.- No hay Layout que configurar
        
        // 3.- No hay propiedades extra: el panel ya sabe dibujarse
        
        // 4.- Añadimos el panel a la ventana: con BorderLayout ocupa todo el centro
        add(panelFiguras);
        
        // 5.- No hay eventos: el panel solo dibuja
        
        // 6.- Tamaño fijo, porque un dibujo no tiene tamaño propio que calcule el layout 
        setSize(300, 320);
        setLocationRelativeTo(null);
        
        
        
        
        
        
        
        
    }
    
}
