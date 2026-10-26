import java.util.Random;

public class Temperatura extends Thread {
    private int temperatura;
    private Random rnd = new Random();

    public Temperatura(int temperatura){
        this.temperatura = temperatura;
        
    }
    
    @Override 
    public void run(){
        while (true){
            // -- TEMPERATURA --
            try {
                sleep(15000);
                if (temperatura == 0 || temperatura == 40 ) {
                    System.out.println("---------------------------------------");
                    System.out.println("Fuera de rango - Sensor de temperatura");
                    
                    
                } else {
                    temperatura = rnd.nextInt(40);
                    System.out.println("---------------------------------------");
                    System.out.println("Lectura de temperatura: " + temperatura + " grados centigrados");
                    
                    
                }    
                
    
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    
    }
}
