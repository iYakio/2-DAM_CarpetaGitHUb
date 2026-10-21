import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            BufferedReader entrada1 = new BufferedReader(new FileReader("./entrada1.txt"));
            LineNumberReader ln = new LineNumberReader(entrada1);

            System.out.println("Escriba un numpero de linea para leer");
            int numUsuario = Integer.parseInt(sc.nextLine());

            String linea;
            
            while((linea = ln.readLine()) != null){
                if (ln.getLineNumber() == numUsuario) {
                    System.out.println("Contenido de la linea numero: " + numUsuario + ":");
                    System.out.println(linea);

                }
            }

            ln.close();
            sc.close();
        } catch (Exception e){

        }
    }
}
