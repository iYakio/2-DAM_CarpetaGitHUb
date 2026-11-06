/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluable2formystats;
import java.util.ArrayList;
/**
 *
 * @author iYaki
 */


/**
 * Almacena la colección de partidas y proporciona métodos de gestión y cálculo de victorias.
 */
public class Partidas {
    private ArrayList<Partida> lista = new ArrayList<>();

    /** Añade una nueva partida a la lista. */
    public void anadir(Partida partida) {
        lista.add(partida);
    }

    /** Devuelve la lista completa de partidas. */
    public ArrayList<Partida> getLista() {
        return lista;
    }

    /** Recorre la lista y suma el total de victorias. */
    public int getTotalVictorias() {
        int total = 0;
        for (Partida p : lista) {
            total += p.getVictorias();
        }
        return total;
    }

    /** Devuelve el número total de registros almacenados. */
    public int getCantidadRegistros() {
        return lista.size();
    }
}
