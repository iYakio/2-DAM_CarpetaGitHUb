import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio2parte2 {

    public static void main(String[] args) {

        String camino = "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\foto.png";
        String caminoCopia = "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\foto_copia.png";

        try {
            FileInputStream leerImagen = new FileInputStream(camino);
            FileOutputStream copiarImagen = new FileOutputStream(caminoCopia);

            int data;
            int contador = 0; // En este contador se meterán los bytes de la imagen

            System.out.println("Bytes de la imagen:");

            while ((data = leerImagen.read()) != -1) {
                copiarImagen.write(data);
               
                contador++; // Este ++ hará que el contador vaya pasando uno por uno
            }

            leerImagen.close();
            copiarImagen.close();

            System.out.println("\nCopia de bytes completada con éxito");
            System.out.println("Total de bytes leídos: " + contador);

        } catch (IOException e) {
            System.out.println("Ha habido un error de lectura o escritura");
            e.printStackTrace();
        }
    }
}