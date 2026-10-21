/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.davante.ejercicio3;

/**
 *
 * @author PC111
 */
public class Alumno {
    // Atributos
        private String nombre;
        private String email;
        private String fecha_de_nacimiento;
        private String genero;
        private String titulacion_acceso;
        private String observacion;
    // Constructores
        
        public Alumno (String nom, String ema, String fecha, String gen, String tit, String ob) {
            this.nombre = nom;
            this.email = ema;
            this.fecha_de_nacimiento = fecha;
            this.genero = gen;
            this.titulacion_acceso = tit;
            this.observacion = ob;
            
        }
    
    // Getter y Setters
           public String getnombre(){
               return this.nombre;
           }
           
           public String getemail(){
               return this.email;
           }
           
           public String getfecha_de_nacimiento(){
               return this.fecha_de_nacimiento;
           }
           
           public String getgenero(){
               return this.genero;
           }
           
           public String gettitulacion_acceso(){
               return this.titulacion_acceso;
           }
           
           public String getobservacion(){
               return this.observacion;
           }
           
           public void setnombre(String nom){
               this.nombre = nom;
           }
           
           public void setemail(String ema){
               this.email = ema;
           }
           
           public void setfecha_de_nacimiento(String fecha){
               this.fecha_de_nacimiento = fecha;
           }
           
           public void setgenero(String gen){
               this.genero = gen;
           }
           
           public void settitulacion_acceso(String tit){
               this.titulacion_acceso = tit;
           }
           
           public void setobservacion(String ob){
               this.observacion = ob;
           }
    
    // toString
           public String toString(){
               return "\n | Nombre: " + this.nombre + " |" + "\n | Email: " + this.email + " |" + "\n | Fecha de Nacimiento: " + this.fecha_de_nacimiento + " |" + "\n | Género: " + this.genero + " |" + "\n | Titulación de acceso: " + this.titulacion_acceso + " |";
           }
    // Métodos Especiales
}
