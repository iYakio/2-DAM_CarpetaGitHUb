import java.util.Random;

public class Camarero extends Thread {
    private final int platos;
    private final Bandeja bandeja;
    private final Random random = new Random();

    public Camarero(int platos, Bandeja bandeja) {
        super("Camarero");
        this.platos = platos;
        this.bandeja = bandeja;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < platos; i++) {
                bandeja.quitarPlato();                      // espera si está vacía
                Thread.sleep(500 + random.nextInt(1000));   // tiempo de servir
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}