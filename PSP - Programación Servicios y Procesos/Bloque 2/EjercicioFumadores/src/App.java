public class App {

    public static void main(String[] args) {
        // Creamos el estanco para pasarselo a todos
        Mostrador mostrador = new Mostrador();

        
        // Creamos el estanquero y se lanzan los hilos
        new Estanquero(mostrador).start();

        
        new Fumador(0, mostrador).start(); // tiene cerillas
        new Fumador(1, mostrador).start(); // tiene tabaco
        new Fumador(2, mostrador).start(); // tiene papel
    }
}
