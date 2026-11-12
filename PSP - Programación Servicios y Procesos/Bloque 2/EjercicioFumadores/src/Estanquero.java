public class Estanquero extends Thread {
    private Mostrador mostrador;

    public Estanquero(Mostrador mostrador) {
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        while (true) {
            mostrador.colocarIngredientes();
        }
    }
}
