import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio1 {

    public static void main(String[] args) {

        try {

            // Abrimos el archivo entrada.txt
            FileReader archivo = new FileReader("./entrada.txt");

            // LineNumberReader permite leer línea a línea
            // y además obtener el número de la línea actual
            LineNumberReader ln = new LineNumberReader(archivo);

            // Variable donde se almacenará cada línea leída
            String linea;

            // Recorremos todo el archivo hasta llegar al final (null)
            while ((linea = ln.readLine()) != null) {

                // StreamTokenizer analizará el contenido de cada línea
                // para diferenciar palabras y números
                StreamTokenizer st =
                        new StreamTokenizer(new StringReader(linea));

                // Contadores de palabras y números
                int palabras = 0;
                int numeros = 0;

                // Mostramos el número de línea
                System.out.println(
                        "--------- Linea nº "
                                + ln.getLineNumber()
                                + " ----------");

                // Mostramos el contenido de la línea
                System.out.println(linea);

                // Recorremos todos los tokens encontrados
                while (st.nextToken() != StreamTokenizer.TT_EOF) {

                    // Si el token es una palabra
                    if (st.ttype == StreamTokenizer.TT_WORD) {

                        // Incrementamos el contador de palabras
                        palabras++;

                    }
                    // Si el token es un número
                    else if (st.ttype == StreamTokenizer.TT_NUMBER) {

                        // Incrementamos el contador de números
                        numeros++;
                    }
                }

                // Mostramos el resultado obtenido para la línea actual
                System.out.println(
                        "Palabras: "
                                + palabras
                                + ", numeros: "
                                + numeros);
            }

            // Cerramos el lector para liberar memoria
            ln.close();

        } catch (Exception e) {

            // En caso de error mostramos el mensaje
            System.out.println("Error: " + e.getMessage());
        }
    }
}