import java.util.Scanner;


public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe numeros");

        System.out.println("Numero 1");
        int num1 = Integer.parseInt(sc.nextLine());

        System.out.println("Numero 2");
        int num2 = Integer.parseInt(sc.nextLine());
        
        Suma hilo1 = new Suma(num1, num2);
        Resta hilo2 = new Resta(num1, num2);
        Multiplicacion hilo3 = new Multiplicacion(num1, num2);
        Dividir hilo4 = new Dividir(num1, num2);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        sc.close();
    }
}
