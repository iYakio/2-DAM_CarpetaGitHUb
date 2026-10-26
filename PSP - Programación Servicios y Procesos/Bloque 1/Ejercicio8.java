import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileWriter;

public class Ejercicio8 {
    public static void main(String[] args) {
        try {
            // Ejecutamos Powershell
            String comando = "ipconfig /all";
            ProcessBuilder powershell = new ProcessBuilder("powershell", "/c", comando);
            Process proceso = powershell.start();

            // Utilizaré esto para escribir en la localización del texto
            BufferedWriter texto = new BufferedWriter( new FileWriter("C:\\Users\\PC111\\Desktop\\TRABAJOS 2 DE DAM\\PSP - Programación Servicios y Procesos\\Bloque 1\\Ej8.txt"));

            // Capturar la salida del proceso por powershell, es decir, todo lo que lee el proceso lo guaradará en la variable reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;

            while ((linea = reader.readLine()) != null) {
                texto.write(linea);
                // Escribe el texto que ha leido del reader anterior
                texto.newLine();
                // Pasa cada linea para ir a la siguiente
            }

            reader.close();
            texto.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
