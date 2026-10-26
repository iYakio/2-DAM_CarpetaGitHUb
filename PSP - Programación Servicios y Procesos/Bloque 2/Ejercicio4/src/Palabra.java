import java.util.Scanner;

/**
 * Palabra
 */
public class Palabra extends Thread {

   private String palabra;

   public Palabra(String palabra){
    this.palabra = palabra;
   }

   public void run(){
    for (int i = 0; i < 100; i++) {
        System.out.println(palabra);
    }
   }
}