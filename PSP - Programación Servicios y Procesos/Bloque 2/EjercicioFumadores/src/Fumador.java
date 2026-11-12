public class Fumador extends Thread {
    private int numFumador; // 0, 1 o 2 (ingrediente que ya tiene)
    private Mostrador mostrador;

    public Fumador(int numFumador, Mostrador mostrador) {
        this.numFumador = numFumador;
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        while (true) {
            mostrador.cogerIngredientes(numFumador);
            try {
                // Fuma entre 3 y 6 segundos
                sleep(3000 + (int) (Math.random() * 3001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("El fumador " + (numFumador + 1) + " ha terminado de fumar.");
        }
    }
}
