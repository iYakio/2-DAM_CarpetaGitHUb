import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo4 {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("./Tema 3/file.txt");
            int data;
            while ((data = file.read()) != -1){
                System.out.println((char) data);
            }


            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error no ha sido encontrado el archivo");
            e.printStackTrace();
        } catch (IOException ie){
            System.out.println("No se ha encontardo el fichero" + ie.getMessage());
            ie.printStackTrace();
            
        } finally {
            System.out.println("No se ha ejecutado correctamente");
        }
    }
}
