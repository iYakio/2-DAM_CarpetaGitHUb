public class Filosofo extends Thread {
    private String nombre;
    private int numFilosofo;
    private Mesa mesa;
    
    public Filosofo(String nombre, int numFilosofo, Mesa mesa) {
        this.nombre = nombre;
        this.numFilosofo = numFilosofo;
        this.mesa = mesa;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(nombre + " (" + numFilosofo + ") está pensando");
            try {
                sleep(500 + (int) (Math.random() * 1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mesa.cogerTenedores(numFilosofo);
            System.out.println(nombre + " (" + numFilosofo + ") está comiendo");
            try {
                sleep(500 + (int) (Math.random() * 1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mesa.soltarTenedores(numFilosofo);
        }
        System.out.println(nombre + " (" + numFilosofo + ") se levanta de la mesa");
    }

}
