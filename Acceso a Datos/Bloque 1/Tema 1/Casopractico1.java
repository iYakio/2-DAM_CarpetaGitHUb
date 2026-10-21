import java.io.File;
import java.io.IOException;


public class Casopractico1 {
    public static void main(String[] args) {
        File fichero1 = new File("C:/Users/PC111/Desktop/TRABAJOS 2 DE DAM/Acceso a datos/Bloque 1 Acceso a datos/tema1/crearFichero.txt");
        try {
            if (fichero1.createNewFile()) {
                System.out.println("Fichero creado: " + fichero1.getName());
            } else {
                System.out.println("El fichero ya está creado");
            }
        } catch (IOException e) {
            System.out.println("Error exception IO");
            e.printStackTrace();
        }
            
  
    
    }
};