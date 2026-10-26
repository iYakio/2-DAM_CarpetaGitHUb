/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio2;
import java.util.Date;
/**
 *
 * @author PC111
 */
public class Alumno {
    private String nombreApellidos;
    private String email;
    private String fechaNacimiento;
    private String genero;
    private String titulacionAcceso;
    private String observaciones;
    
    // Constructor
    public Alumno(String nombreApellidos, String email, String fechaNacimiento, String genero, String titulacionAcceso, String observaciones){
        this.nombreApellidos = nombreApellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.titulacionAcceso = titulacionAcceso;
        this.observaciones = observaciones;
    }
    
    // Getters y Setters
    public String getNombreApellidos(){
        return nombreApellidos;
    }
    
    public String getEmail(){
        return email;
        
    }
    
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public String getTitulacionAcceso(){
        return titulacionAcceso;
    }
    
    public String getObservaciones(){
        return observaciones;
    }
    
    
    public void setNombreApellidos(String nombreApellidos){
        this.nombreApellidos = nombreApellidos;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public void setTitulacionesAcceso(String titulacionesAcceso){
        this.titulacionAcceso = titulacionesAcceso;
    }
    
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    
    @Override
    public String toString(){
        return "--- Datos del Alumno --- \n" +
                "Nombre y apellidos: " + nombreApellidos + "\n" + 
                "Email: " + email + "\n" + 
                "Fecha de nacimiento: " + fechaNacimiento + "\n" + 
                "Género: " + genero + "\n" + 
                "Titulación de acceso: " + titulacionAcceso + "\n" + 
                "Observaciones: " + observaciones;
    }
}
