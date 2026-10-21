import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Casopractico4 {
    public static void main(String[] args) {

       // try {
         //   FileReader lector = new FileReader("./tema1/prueba.txt");

           // int data;

           // data = lector.read();

           // System.out.println((char) data);
            // Sin el (char) no leerá el caracter

           // lector.close();


       // } catch (FileNotFoundException IOe) {
         //   System.out.println("No se encontró el archivo");

        //} catch (IOException e) {
          //  System.out.println("Error de lectura");
        //}



        // El de arriba sirve para leer un unico caracter




       /*  try {
            FileReader lector = new FileReader("./tema1/prueba.txt");

            int data;

            while((data = lector.read()) != -1){
                System.out.println((char)data);
            // este while hará que lea todo el archivo hasta que vea un -1
            }
            lector.close();
            System.out.println("Lectura correcta");


        } catch (FileNotFoundException IOe) {
            System.out.println("No se encontró el archivo");

        } catch (IOException e) {
            System.out.println("Error de lectura");
        }

        try {
            FileWriter fw = new FileWriter("./tema1/escritura.txt");
            fw.write("Esto es un ejemplo de escritura");
            fw.close();
            System.out.println("Fichero escrito correctamente");

        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo " + e.getMessage());
        } */


        // -------------------------------------------------------------------------------------------------
        
        
       /*  try {
            FileReader lector = new FileReader("./tema1/prueba.txt");
            // Lee el archivo en esa ruta para después utilizar
            FileWriter escritor = new FileWriter("./tema1/escritura.txt");
            // Crea un archivo de texto en esa ruta

            int data; // generamos la variable donde guardaremos el contenido

            while((data = lector.read()) != -1) { // este bucle empezará a leer el .txt de "lector" y lo transportará a "data"
                escritor.write(data);
                // el "escritor" escribirá todo el texto leido hasta que acabe en el archivo
                System.out.println((char)data);
            }

            System.out.println("Lectura correcta");
            lector.close();
            escritor.close();
        } catch (Exception e) {
            
        }
        */

        String camino = "./tema1/imagen1.jpg";
        String caminoEscrito = "./tema1/imagenCopiada.jpg";

        try {
           FileInputStream entrada = new FileInputStream(camino);
           // FileInput sirve para leer binario
           FileOutputStream salida = new FileOutputStream(caminoEscrito);
           // FileOutput sirve para COPIAR o ESCRIBIR en binario
           int data;

           while ((data = entrada.read()) != -1) {
            salida.write(data);
            

           }

           entrada.close();
           salida.close();

        } catch (Exception e) {
            
        }

    }
}
