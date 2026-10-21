import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Creamos el random para acceder de forma libre a la posición que queremos opacar
            RandomAccessFile asientos = new RandomAccessFile("C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\entradas.txt", "rw");

            System.out.println("¿Qué número de asiento desea usted? ");
            // Leemos como String y lo transformamos a int y así poder utilizar la excepción de NumberFormatException si fallan las letras
            int asiento = Integer.parseInt(sc.next());

            if (asiento < 0 || asiento > 19) {
                System.out.println("Ese asiento no corresponde a ningún sitio");
            } else {
                asientos.seek(asiento);
                
                char estado = (char) asientos.read();

                if (estado == 'C') {
                    System.out.println("Ese asiento está ocupado");
                } else if (estado == 'L') {
                    asientos.seek(asiento);
                    asientos.write('C');
                    System.out.println("Ese asiento se ha comprado correctamente");
                }
            }

            asientos.close();
            sc.close();
        } catch (NumberFormatException ne) {
            System.out.println("Error: Debes introducir un número entero válido.");
            ne.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura en el archivo.");
            e.printStackTrace();
        }
    }
}