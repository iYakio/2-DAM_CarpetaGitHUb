import java.util.Random;

public class Humedad extends Thread {
    Random random = new Random();
    private int humedad;
    private int variacion;


    public Humedad(int humedad){
        this.humedad = humedad;

    }

    public void run(){
        while (true){
            try {
                sleep(22000);
                variacion = random.nextInt(4);
                if (random.nextBoolean()) {
                    humedad += variacion;
                } else {
                    humedad -= variacion;
                }
    
                if (humedad < 0 || humedad > 100) {
                    System.out.println("Fuera de rango - sensor de humedad");
                     System.out.println("-------------------------------------------------------------------------");
                } else {
                    System.out.println("Lectura de humedad relativa: " + humedad + "%");
                     System.out.println("-------------------------------------------------------------------------");
                }
    
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
