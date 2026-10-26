public class App {
    public static void main(String[] args) throws Exception {


        // start() -> inicia el hilo del run ( main )
        // join() -> esperar hasta que el hilo termine (suele ir en el run ( main ))
        // sleep() -> pausa de unos cuantos milisegundos (suele ir ene el hilo)
        Hilo hilo1 = new Hilo(1);
        Hilo hilo2 = new Hilo(2);
        Hilo hilo3 = new Hilo(3);
        Hilo hilo4 = new Hilo(4);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
