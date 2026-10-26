import java.util.Random;

public class Presion extends Thread {
    private int presion;
    private Random rnd = new Random();

    public Presion(int presion){
        this.presion = presion;

    }

    public void run(){
        while (true){
            try {
                // -- PRESIÓN --
                sleep(18000);
                if (presion == 0 || presion == 5) {
                    System.out.println("Fuera de rango - Sensor de presion atmosferica");

                } else {
                    presion = rnd.nextInt(5);
                    System.out.println("Lectura de presión atmosférica: " + presion + " atmosferas");
                }






            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
