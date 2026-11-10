/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluable2formystats;
import java.util.ArrayList;




public class Partidas {
    private ArrayList<Partida> lista = new ArrayList<>();

    
    public void anadir(Partida partida) {
        lista.add(partida);
    }

    
    public ArrayList<Partida> getLista() {
        return lista;
    }

    
    public int getTotalVictorias() {
        int total = 0;
        for (Partida p : lista) {
            total += p.getVictorias();
        }
        return total;
    }

    
    public int getCantidadRegistros() {
        return lista.size();
    }
}
