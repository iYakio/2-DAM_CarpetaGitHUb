

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Lanzador {
    public static void main(String[] args) {
        try {
            System.out.println("Soy la clase principal.");

            String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            String cp = System.getProperty("java.class.path");

            // Lanzar la clase Saludo en una máquina virtual nueva
            ProcessBuilder pb = new ProcessBuilder(java, "-cp", cp, "Saludo");
            Process hijo = pb.start();

            // Leer lo que el hijo escribe con System.out´
            BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            String linea;

            while ((linea = reader.readLine()) != null){
                System.out.println("La otra clase dice: " + linea);
            }

            // waitFor(); cuando termine el proceso saldrá la respuesta de "El hijo ha terminado"
            hijo.waitFor();
            System.out.println("El hijo ha terminado");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
