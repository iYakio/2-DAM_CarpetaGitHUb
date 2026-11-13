package com.dam.pc1111;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Se pone entitiy cada vez que se cree una nueva tabla
@Table(name = "CATEGORIA")
public class Categoria {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Pone este atributo como auto-incremental
    private int id;
    
    @Column (nullable = false)
    private String nombre;

    public Categoria(){

    }

    public Categoria (String nombre){
        this.nombre = nombre;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}

