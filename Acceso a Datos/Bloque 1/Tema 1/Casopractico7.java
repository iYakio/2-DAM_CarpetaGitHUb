
import java.io.RandomAccessFile;


public class Casopractico7 {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("C:\\Users\\PC111\\Desktop\\TRABAJOS 2 DE DAM\\Acceso a datos\\Bloque 1 Acceso a datos\\tema1\\abecedario.txt", "r");
            file.seek(5); // saltamos directamente a la posición 5, sin leer lo antes

            System.out.println("Puntero antes de read: " + file.getFilePointer()); // El puntero se situa el 5 que es donde estaba el seek(5) anterior

            byte[] arrayBytes = new byte[3]; // Desde la posición 5 "file.seek(5)" leerá 3 posiciones para adelante
            file.read(arrayBytes, 0, 3); // leemos 5 bytes de golpe, desde ahí

            
            System.out.println("Bytes leidos: " + arrayBytes.length); // Lee los 3 primeros bytes del arrayByte
            System.out.println("Puntero después de read: " + file.getFilePointer()); // El puntero estará en 8 porque 

            for (int i = 0; i < arrayBytes.length; i++) {
                System.out.println("\n   arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
            }


            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
