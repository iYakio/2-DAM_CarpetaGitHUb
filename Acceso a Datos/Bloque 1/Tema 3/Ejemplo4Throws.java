import java.io.FileReader;
import java.io.IOException;

public class Ejemplo4Throws {          
    public static void main(String[] args) throws IOException {
                                        // El throw de la excepción se activa arriba en el main
        FileReader file = new FileReader("./Tema 3/file.txt");

        int data;
        while((data = file.read()) != -1){
            System.out.println((char) data);
        }
        file.close();
    }
}
