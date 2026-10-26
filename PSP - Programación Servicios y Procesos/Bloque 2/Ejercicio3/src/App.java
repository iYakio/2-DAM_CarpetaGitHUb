import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Cronometro cro1 = new Cronometro(30);

        cro1.start();

        int Random = (int) (Math.random() * 100);
        while (true) {
            System.out.println("Escriba un numero del 0 al 100");
            int eleccion = Integer.parseInt(sc.nextLine());

            if (eleccion == Random) {
                System.out.println("Numero correcto" + Random);
                break;

            } else {
                System.out.println("Numero incorrecto " + eleccion);
            }
     
            
        }
        sc.close();
       
            






    }
}
