/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio3blocnotas;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;

/**
 *
 * EJERCICIO 3: MENÚ, BARRA DE HERRAMIENTAS Y ACCIONES COMPARTIDAS
 */
public class Ejercicio3BlocNotas {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new VentanaNotas().setVisible(true));
    }
}
