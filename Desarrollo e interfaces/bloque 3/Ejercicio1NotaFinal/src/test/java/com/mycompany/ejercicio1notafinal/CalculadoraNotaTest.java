/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1notafinal;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PC111
 */
public class CalculadoraNotaTest {
    // Margen para comparar double: 0,001 de diferencia se da por igual
    private static final double MARGEN = 0.001;
    
    // Casos normales 
    @Test
    public void notaFinalPondera30_60_10(){
        // 
        assertEquals(6.8, CalculadoraNota.notaFinal(6, 7, 8), MARGEN);
    }
    
    @Test 
    public void notaFinalPesaMasLasPracticas(){
        // Mismas notas cambiadas de sitio: con un 10 en prácticas sale más que
        double conPracticas = CalculadoraNota.notaFinal(0, 10, 0);
        double conExamen = CalculadoraNota.notaFinal(10, 0, 0);
        assertTrue(conPracticas > conExamen);
        
    }
}
