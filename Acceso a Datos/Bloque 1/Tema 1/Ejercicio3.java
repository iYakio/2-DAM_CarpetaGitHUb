import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            FileReader leerDatos = new FileReader(
                    "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\datos.txt");

            FileWriter escribirDatos = new FileWriter(
                    "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\datos.txt",
                    true);

            System.out.println("Escriba la posición la cual usted quiere modificar 0 a 9");
            int posicion = sc.nextInt();

            // Limpiar el salto de línea que deja nextInt()
            sc.nextLine();

            System.out.println("Escriba el caracter que quiere escribir en esa posición");
            char caracter = sc.nextLine().charAt(0);

            RandomAccessFile escribir = new RandomAccessFile(
                    "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\datos.txt",
                    "rw");

            escribir.seek(posicion);

            // Escribir el carácter en la posición indicada
            escribir.write((char) caracter);

            escribir.close();
            leerDatos.close();
            escribirDatos.close();
            sc.close();

            System.out.println("Carácter modificado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
