public class Cronometro extends Thread {
    int num = 30;

    public Cronometro(int n) {
        this.num = n;
    }

    
    @Override
    public void run() {
        
        // Cuenta atrás: desde 'num' hasta 0
        for (int i = num; i >= 0; i--) {
            System.out.println("Quedan " + i + " segundos...");
            try {
                Thread.sleep(1000); // Pausa de 1 segundo (1000 milisegundos) entre cada número
            } catch (InterruptedException e) {
                System.out.println("El cronómetro ha sido interrumpido.");
            }
        }
    }
}
