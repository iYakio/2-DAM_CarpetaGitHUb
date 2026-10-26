import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio6Contains {
    public static void main(String[] args) {
        try {
            // Ejemplo solo valido para CMD de Windows
            String comando = "ipconfig";

            // Lanzar CMD y crear proceso
            ProcessBuilder cmd = new ProcessBuilder("CMD", "/c", comando);
            Process proceso = cmd.start();

            // Capturar la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            // Leer y mostrar los resultados del comando linea a linea
            while ((linea = reader.readLine()) != null) {
                if (linea.contains("IPv4")) {
                    System.out.println(linea);
                }
            }

            // Esperar a que el proceso termine y mostrar código de proceso
            int exitCode = proceso.waitFor();
            System.out.println("Comando terminado con código de salida: " + exitCode);






            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
