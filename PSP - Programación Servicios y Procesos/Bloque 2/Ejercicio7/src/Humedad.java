import java.util.Random;

public class Humedad extends Thread {
    private int humedad;
    private Random rnd = new Random();

    public Humedad(int humedad){
        this.humedad = humedad;

    }

    public void run(){
        while (true){
            try {
                // -- HUMEDAD -- 
                sleep(22000);
                if (humedad == 0 || humedad == 100) {
                    
                    System.out.println("Fuera de rango - Sensor de humedad");
                    System.out.println("---------------------------------------");
                } else {
                    humedad = rnd.nextInt(100);
                    
                    System.out.println("Lector de humedad relativa: " + humedad + "%");
                    System.out.println("---------------------------------------");
                }
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }





}
