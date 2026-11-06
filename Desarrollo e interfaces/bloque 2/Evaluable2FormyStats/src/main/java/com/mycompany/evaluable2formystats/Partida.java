/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluable2formystats;
import java.time.LocalDate;

public class Partida {
    private LocalDate fecha;
    private String videojuego;
    private int victorias;

    public Partida(LocalDate fecha, String videojuego, int victorias) {
        this.fecha = fecha;
        this.videojuego = videojuego;
        this.victorias = victorias;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getVideojuego() { // <-- Este es el método que busca
        return videojuego;
    }

    public int getVictorias() {
        return victorias;
    }
}