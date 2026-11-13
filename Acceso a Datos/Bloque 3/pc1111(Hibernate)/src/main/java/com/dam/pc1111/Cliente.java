package com.dam.pc1111;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table  (name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column 
    private String nombre;

      public Cliente() {
    }

    public Cliente (String nombre){
        this.nombre = nombre;
    }

    

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public Set<Producto> getProductos() {
        return productos;
    }



    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }



    @ManyToMany // Relación de muchos a muchos N:M
    @JoinTable (name = "compra", // tabla intermedia // Crea una clave foránea
                joinColumns = @JoinColumn(name = "id_cliente"), // FK hacía cliente
                inverseJoinColumns = @JoinColumn (name = "id_producto") // FK hacía producto
    )
    private Set<Producto> productos = new HashSet<>();

}
