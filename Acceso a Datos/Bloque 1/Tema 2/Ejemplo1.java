import java.io.FileReader;
import java.io.StreamTokenizer;


public class Ejemplo1 {
    public static void main(String[] args) {

        int contadorPalabras = 0;
        int contadorNuneros = 0;
        

        try {
            StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("./datos.txt"));
            // Configurar para que el carácter de nueva linea sea interpretado, es decir, el espacio en blanco también saldrá por el terminal
            streamTokenizer.eolIsSignificant(true);

            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Palabra " + streamTokenizer.sval);
                    contadorPalabras++; // token de tipo palabra
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Numero " + streamTokenizer.nval);
                    contadorNuneros++; // token de tipo número
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("Salto de linea"); // fin de línea
                }
            }
            System.out.println("El contador de palabras es de: " + contadorPalabras);
            System.out.println("El contador de numeros es de: " + contadorNuneros);
        } catch (Exception e) {
            
        }

    }
}
