/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dibujitos;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author PC111
 */
public class VentanaAnillos {
    // 1.- Creamos TODOS los componentes: aquí solo hay uno, el panel de dibujo
    private PanelAnillos panelAnillos = new PanelAnillos();
    
    public VentanaAnillos(){
        super("Juegos Olimpicos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // 2.- No hay Layout que configurar
        
        // 3.- No hay propiedades extra: el panel ya sabe dibujarse
        
        // 4.- Añadimos el panel a la ventana: con BorderLayout ocupa todo el centro
        add(panelAnillos);
        
        // 5.- No hay eventos: el panel solo dibuja
        
        // 6.- Tamaño fijo, porque un dibujo no tiene tamaño propio que calcule el layout 
        setSize(300, 320);
        setLocationRelativeTo(null);
        
        
        
        
        
        
        
        
    }
}
