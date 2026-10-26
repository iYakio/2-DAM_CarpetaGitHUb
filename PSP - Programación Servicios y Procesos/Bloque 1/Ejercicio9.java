import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileWriter;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            
            System.out.println("Escribe el comando que quieres utilizar");
            String comandoUsuario = sc.nextLine();

            ProcessBuilder powershell = new ProcessBuilder("powershell", "/c", comandoUsuario);
            Process proceso = powershell.start();

            boolean comprobar = true;

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));


            String linea;

            while ((linea = reader.readLine()) != null){
                System.out.println(linea + "\n");
                

            }

            if (comprobar == true) {
                System.out.println("El proceso sigue en ejecución");
            } else {
                System.out.println("El proceso ha finalizado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
