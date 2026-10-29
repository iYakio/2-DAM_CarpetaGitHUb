import java.util.Random;

public class Presion extends Thread {
    Random random = new Random();
    private int presion;
    private int variacion;




    public Presion(int presion){
        this.presion = presion;


    }



    public void run(){
        while (true){
            try {
                sleep(18000);
                variacion = random.nextInt(4);
    
                if (random.nextBoolean()) {
                    presion += variacion;
                } else{
                    presion -= variacion;
                }
    
                if (presion < 0 || presion > 5) {
                    System.out.println("Fuera de rango - sensor de presion atmosferica");
    
                } else {
                    System.out.println("Lectura de presion atmosferica: " + presion + " atmosferas");
                }
    
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
