import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio5 {

    public static void main(String[] args) {

        // Rutas de los archivos (se cambian las rutas de las copias para que no coincidan)
        String origen = "C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\paisaje.png";
        String destino = "C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\paisaje_copia.png";
        String copiaBuffer = "C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\paisaje_copia_buffer.png";

        // COPIA Nº1: Sin buffer
        long sinBuffer = System.currentTimeMillis();

        try {
            FileInputStream entrada = new FileInputStream(origen);
            FileOutputStream salida = new FileOutputStream(destino);

            int data;
            while ((data = entrada.read()) != -1) {
                salida.write(data);
            }

            entrada.close();
            salida.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        long sinfinBuffer = System.currentTimeMillis();
        long tiempoSinBuffer = sinfinBuffer - sinBuffer;

        // COPIA Nº2: Con buffer
        long inicioBuffer = System.currentTimeMillis();

        try {
            BufferedInputStream entrada1 = new BufferedInputStream(new FileInputStream(origen));
            BufferedOutputStream salida1 = new BufferedOutputStream(new FileOutputStream(copiaBuffer));

            byte[] buffer = new byte[4096];
            int bytesleidos = 0;

            while ((bytesleidos = entrada1.read(buffer)) != -1) {
                salida1.write(buffer, 0, bytesleidos);
            }

            entrada1.close();
            salida1.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        long finalBuffer = System.currentTimeMillis();
        // Corrección del cálculo de tiempo (resta en lugar de suma)
        long tiempoBuffer = finalBuffer - inicioBuffer; 

        // Comprobar tamaños de cada archivo
        File original = new File(origen);
        File destino1 = new File(destino);
        File destino2 = new File(copiaBuffer);

        System.out.println("=== Resultados ===");
        System.out.println("Tamaño original del archivo: " + original.length() + " bytes");
        System.out.println("Tamaño de la copia sin Buffer: " + destino1.length() + " bytes");
        System.out.println("Tamaño de la copia con Buffer: " + destino2.length() + " bytes");

        System.out.println("tiempo sin buffer: " + tiempoSinBuffer + " ms");
        System.out.println("tiempo con buffer: " + tiempoBuffer + " ms");

    }
}
         