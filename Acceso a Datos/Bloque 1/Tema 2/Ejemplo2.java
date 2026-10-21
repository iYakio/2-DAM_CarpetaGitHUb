import java.io.FileReader;
import java.io.LineNumberReader;
public class Ejemplo2 {
    public static void main(String[] args) {
        try {
            LineNumberReader ln = new LineNumberReader(new FileReader("./datos.txt"));
            String linea;
            while ((linea = ln.readLine()) != null) {
                System.out.println("Contenido de la linea: " + ln.getLineNumber());
                System.out.println(linea);
            }

            ln.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
