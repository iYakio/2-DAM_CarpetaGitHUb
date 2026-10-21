import java.io.RandomAccessFile;


public class Casopractico6 {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("C:\\Users\\PC111\\Desktop\\TRABAJOS 2 DE DAM\\Acceso a datos\\Bloque 1 Acceso a datos\\tema1\\abecedario.txt", "rw");
            file.seek(5);
            
            System.out.println("Puntero ANTES de leer: " + file.getFilePointer()); // Este sout escribirá 5
            int unbyte = file.read(); // cada vez que se utiliza el programa sumará uno el puntero por lo cual pasará a la derecha
            System.out.println("Puntero despues de leer: " + file.getFilePointer()); // Este sout escribirá 6
            System.out.println((char)unbyte);

            file.write('B');
            System.out.println("Puntero DESPUES de escribir: " + file.getFilePointer());

            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
