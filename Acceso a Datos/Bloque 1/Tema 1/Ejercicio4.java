import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {

    public static void main(String[] args) {

        int contadorBloques = 0;
        // Este contador sirve para cada vez que se copie un bloque, el ++ en el bucle haga que ese contador vaya aumentando cada vez que se copia correctamente

        try (
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream("C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\foto.png"));
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\foto_copia.png"));
        ) {

            byte[] buffer = new byte[1024];
            int bytesLeidos;

            while ((bytesLeidos = bis.read(buffer)) != -1) {

                bos.write(buffer, 0, bytesLeidos);

                contadorBloques++;
                System.out.println("Fin copia bloque " + contadorBloques);
            }

            System.out.println("Copia finalizada correctamente.");

        } catch (IOException e) {
            System.out.println("Error durante la copia: " + e.getMessage());
        }
    }
}