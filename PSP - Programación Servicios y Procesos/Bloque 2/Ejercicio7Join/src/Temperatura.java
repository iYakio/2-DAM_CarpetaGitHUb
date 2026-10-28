import java.util.Random;



public class Temperatura extends Thread {
    private int temperatura;
    private int variacion;

    Random random = new Random();

    public Temperatura(int temperatura){
        this.temperatura = temperatura;

    }

    
    public void run(){

        while(true){
            try {
                sleep(15000);
                variacion = random.nextInt(4);
        
                if (random.nextBoolean()) {
                    temperatura += variacion;
                    
                } else {
                    temperatura -= variacion;
                    
                }
        
                if (temperatura < 0 || temperatura > 40) {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Fuera de rango - sensor de temperatura");
                } else {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Lectura de temperatura de: " + temperatura + " grados centigrados");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
        
            
        
    }

}
