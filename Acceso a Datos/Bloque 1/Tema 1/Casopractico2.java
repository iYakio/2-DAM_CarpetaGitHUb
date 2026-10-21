import java.io.File;

public class Casopractico2 {
    public static void main(String[] args) {
        File fichero2 = new File("C:/Users/PC111/Desktop/TRABAJOS 2 DE DAM/Acceso a datos/Bloque 1 Acceso a datos/tema1/crearFichero.txt"); 
        // Busca el archivo que hemos creado anteriormente en el ejercicio anterior llamado "crearFichero.txt"

        File carpeta = new File("C:/Users/PC111/Desktop/TRABAJOS 2 DE DAM/Acceso a datos/Bloque 1 Acceso a datos/tema1","backup");
        carpeta.mkdirs();
        //crea una nueva carpeta dentro de una carpeta existente llamada "tema1"

        File destino = new File("./tema1/backup/fichero_movido.txt");
        //Dentro de esa carpeta que acabamos de crear metemos 
        if (fichero2.renameTo(destino)) {
            System.out.println("El fichero se movió con éxito");
        } else {
            System.out.println("El fichero no se ha podido mover correctamente");
        }
    }
}
