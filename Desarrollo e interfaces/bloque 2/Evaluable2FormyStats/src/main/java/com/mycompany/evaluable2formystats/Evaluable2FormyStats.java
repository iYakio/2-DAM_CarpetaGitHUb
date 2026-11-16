/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 * Clase de arranque de la aplicación. Activa el aspecto de FlatLaf y abre la
 * ventana principal.
 *
 * @author pc111
 */
package com.mycompany.evaluable2formystats;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;


public class Evaluable2FormyStats {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new VentanaFormyStats().setVisible(true));
    }
}
