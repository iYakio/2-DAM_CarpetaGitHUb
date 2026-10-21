import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio2parte1 {
    public static void main(String[] args) {
        String camino = "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\foto.png";
        String caminoCopia = "C:\\Users\\PC111\\Desktop\\2-DAM\\Acceso a Datos\\Bloque 1\\Tema 1\\foto_copia.png";
        
        
        try {
            FileInputStream leerImagen = new FileInputStream(camino);
            
            FileOutputStream copiarImagen = new FileOutputStream(caminoCopia);

            int data;

            while ((data = leerImagen.read()) != -1){
                copiarImagen.write(data);
                
            }

            System.out.println("Copia de imagen completada con éxito");


            leerImagen.close();
            copiarImagen.close();


        } catch (IOException e) {
            System.out.println("Ha habido un error de lectura o escritura");
            e.printStackTrace();
        }

    }
}
