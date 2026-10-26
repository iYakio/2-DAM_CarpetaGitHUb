package Ejercicio2Repaso;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FichaEquipo {
    public static void main(String[] args) {
        
        try {
            // Ejecutar comando CMD
            String comando = "systeminfo";
            
            // Creamos el proceso para poder ejecutar el cmd 
            ProcessBuilder procesoCMD = new ProcessBuilder("CMD", "/c", comando);
            Process pCMD = procesoCMD.start();
            

            // Aplicamos buffered reader para leer los archivos
            BufferedReader reader = new BufferedReader(new InputStreamReader(pCMD.getInputStream()));
            String linea;
            int contador = 0;
            
            FileWriter escribirLinea = new FileWriter("./equipo.txt"); 
  
            System.out.println("Iniciando el bucle con la condicional...");

            // Leer en un bucle cada linea
            while ((linea = reader.readLine()) != null){
                 // devolver las 70 lineas leidas
                    System.out.println(linea + "\n");
                    contador++;

                 // filtrado con la condicional if   
                if (linea.contains("Nombre de host") || (linea.contains("Nombre del sistema operativo") || (linea.contains("Modelo del sistema")))) {
                    escribirLinea.write(linea + "\n");
                    
                }
            }
            reader.close();
            escribirLinea.close();
            pCMD.waitFor();
            System.out.println("El contador de lineas ha sido de: " + contador);
            
            
            
            




        } catch (Exception e) {
            System.out.println("Hay errores de comprension lectora o de texto" + e.getMessage());
        }
        
    }
}
