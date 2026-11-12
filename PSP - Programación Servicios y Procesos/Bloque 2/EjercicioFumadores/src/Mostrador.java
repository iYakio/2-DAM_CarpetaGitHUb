public class Mostrador {
    // Ingredientes: 0 = cerillas, 1 = tabaco, 2 = papel
    private static final String[] NOMBRES = {"cerillas", "tabaco", "papel"};

    // Guarda el ingrediente que NO está en el mostrador.
    // -1 significa que el mostrador está vacío.
    // Si vale 1 (falta tabaco), hay cerillas y papel, y solo le sirve
    // al fumador que tiene tabaco (fumador 2).
    private int ingredienteQueFalta = -1;

    // El estanquero coloca 2 ingredientes al azar (equivale a elegir cuál NO colocar)
    public synchronized void colocarIngredientes() {
        // Espera a que el mostrador esté libre
        while (ingredienteQueFalta != -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ingredienteQueFalta = (int) (Math.random() * 3);

        // Los dos que sí se colocan son los otros dos
        String ing1 = NOMBRES[(ingredienteQueFalta + 1) % 3];
        String ing2 = NOMBRES[(ingredienteQueFalta + 2) % 3];
        System.out.println("El estanquero ha colocado " + ing1 + " y " + ing2 + " en el mostrador.");

        notifyAll(); // avisa a los fumadores
    }

    // numFumador es 0, 1 o 2 y coincide con el ingrediente que ese fumador ya tiene
    public synchronized void cogerIngredientes(int numFumador) {
        // Solo coge cuando lo que hay en el mostrador es justo lo que le falta
        while (ingredienteQueFalta != numFumador) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String ing1 = NOMBRES[(numFumador + 1) % 3];
        String ing2 = NOMBRES[(numFumador + 2) % 3];
        System.out.println("El fumador " + (numFumador + 1) + " ha cogido " + ing1 + " y " + ing2
                + " y se ha puesto a fumar.");

        ingredienteQueFalta = -1; // mostrador libre
        notifyAll();              // avisa al estanquero
    }
}
