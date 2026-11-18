import java.util.Random;

public class Cocinero extends Thread {
    private final int platos;
    private final Bandeja bandeja;
    private final Random random = new Random();

    public Cocinero(int platos, Bandeja bandeja) {
        super("Cocinero");
        this.platos = platos;
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= platos; i++) {
                sleep(100 + random.nextInt(400));   // tiempo de cocinar
                bandeja.ponerPlato(i);                     // espera si está llena
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
