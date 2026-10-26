package Ejercicio2Repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Generando ficha del equipo...");
       String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
       String cp = System.getProperty("java.class.path");

        
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", cp, "Ejercicio2Repaso.FichaEquipo");
            Process hijo = pb.start();

            // Mostrar lo que escribe FichaEquipo
            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null){
                System.out.println("FichaEquipo generada: " + linea);
            }

            // Esperar a que termine systeminfo tarda unos segundos
            hijo.waitFor();
            System.out.println("Ficha terminada");
            
            


        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }
}
