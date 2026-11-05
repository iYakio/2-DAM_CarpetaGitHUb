public class Almacen {
    private String[] almacen = new String[10];
    private int contador;

    public Almacen() {
        this.almacen = new String[10];
        this.contador = 0;
    }

    // MÉTODO - SECCIÓN CRÍTICA
    // Synchronized para que Java no permita varios hilos
    // ejecutar este método al mismo tiempo
    // esto es una sección critica es decir creemos que va a dar fallo

    public synchronized void insertarProducto(String productoID) {
        while (contador >= 10) { // Si está completo el array...
            try {
                wait(); // ...espero a que alguien (trabajador me notifique)

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Cuando haya hueco en el array, saldrá del bucle y añadiré el producto
        almacen[contador] = productoID;
        System.out.println("Se ha ñadido el " + productoID + " en la posición " + contador);
        contador++;

        // Cuando termine avisa (quiero avisar a trabajadores)
        notifyAll();
    }

    // MÉTODO - SECCIÓN CRÍTICA
    // Sincronizamos para que no entren 2 a la vez
    public synchronized void eliminarProducto() {
        while (contador >= 10) { // Si no hay nada en el array...
            try {
                wait(); // ...te esperas a que alguien (cliente) notifique

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // El trabajador quitará un producto
        contador--;
        System.out.println("Se ha eliminado el producto " + almacen[contador] + " del hueco " + contador);
        almacen[contador] = null;


        // Avisamos al resto de hilos (realmente quiero avisar a clientes)
        notifyAll();

    }

}
