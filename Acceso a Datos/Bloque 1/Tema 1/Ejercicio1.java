
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            FileReader leerFichero = new FileReader("C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\texto.txt");
            FileWriter escribirFichero = new FileWriter("C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\copia.txt");

            int caracter;

            while((caracter = leerFichero.read()) != -1){
                escribirFichero.write(caracter);

            }

            System.out.println("El archivo se ha copiado con éxito");
            leerFichero.close();
            escribirFichero.close();


        } catch (IOException e) {
            System.out.println("El archivo no se ha podido encontrar o no hay escritura en el ");
            e.printStackTrace();
        }
       
    }
}
