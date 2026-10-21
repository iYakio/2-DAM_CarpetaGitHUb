import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            RandomAccessFile asientos = new RandomAccessFile("C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\entradas.txt", "rw");

            System.out.println("Posicion inicial de rango ( en numero ) del 0 al 19 ");
            int inicio = sc.nextInt();

            System.out.println("Desde esa posicion escriba el número de asientos hasta su rango deseado");
            int cantidad = sc.nextInt();

            asientos.seek(inicio);
            
            // Leerá desde el rango escrito por el usuario y lo guardará en un array de bytes
            byte[] array = new byte[cantidad];

            asientos.read(array, 0, cantidad);
    // el array en cuestión, empieza desde el inicio ( 0 ) y la cantidad máxima de bytes que va a leer
           

            System.out.println("Desde la posicion: " + inicio + " los asientos dentro del rango que has consultado son:");

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Rango " + (inicio + i) + " : " + (char) array[i]);
            }

            sc.close();
            asientos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
