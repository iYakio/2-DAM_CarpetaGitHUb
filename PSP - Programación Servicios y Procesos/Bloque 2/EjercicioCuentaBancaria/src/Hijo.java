import java.util.Random;

public class Hijo extends Thread {
    private final CuentaBancaria cuenta;
    private final Random rnd = new Random();

    public Hijo(CuentaBancaria cuenta) {
        super("Hijo");
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                int cantidad = 1 + rnd.nextInt(100);

                if (rnd.nextBoolean()) {
                    cuenta.NuncaNegativo(cantidad);     // gasta
                } else {
                    cuenta.LimiteSeguridad(cantidad);   // ingresa
                }

                sleep(500 + rnd.nextInt(1501));
            }
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }
}