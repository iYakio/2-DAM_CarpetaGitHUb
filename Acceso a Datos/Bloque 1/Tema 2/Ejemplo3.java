import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejemplo3 {
    public static void main(String[] args) {
        try {
            DataOutputStream dps = new DataOutputStream(new FileOutputStream("./salida.txt"));
            dps.writeInt(123);
            dps.writeInt(987);
            dps.writeDouble(123.45F);
            dps.writeLong(953325447);
            dps.writeDouble(9.3);
            dps.close();

            DataInputStream dis = new DataInputStream(new FileInputStream("./salida.txt"));
            int entero1 = dis.readInt();
            int entero2 = dis.readInt();
            float numerofloat = dis.readFloat();
            long numeroLong = dis.readLong();
            double numeroDouble = dis.readDouble();

            dis.close();

            System.out.println("El numero entero es " + entero1 + " y " + entero2);
            System.out.println("El decimal es " + numerofloat);
            System.out.println("El numero entero largo es: " + numeroLong);
            System.out.println("El numero decimal grande: " + numeroDouble);
            
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
