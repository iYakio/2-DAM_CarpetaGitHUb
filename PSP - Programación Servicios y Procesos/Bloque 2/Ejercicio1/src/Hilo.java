public class Hilo extends Thread {



    int numHilo;

    public Hilo(int n){
        this.numHilo = n;
    }
    @Override 
    public void run(){
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Hilo: " + this.numHilo + ": " + i);
        }
    }
}
