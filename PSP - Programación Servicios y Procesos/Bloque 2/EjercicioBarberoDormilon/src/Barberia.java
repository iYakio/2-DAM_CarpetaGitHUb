public class Barberia {
    private boolean[] sillasDisponibles;   // true = libre, false = ocupada
    private int numSillas;
    private boolean sillaTrabajo;          // true = libre, false = ocupada

    public Barberia(int numSillas) {
        this.numSillas = numSillas;
        sillasDisponibles = new boolean[numSillas];
        for (int i = 0; i < numSillas; i++) {
            sillasDisponibles[i] = true;
        }
        sillaTrabajo = true;
    }

    // Devuelve true si todas las sillas de espera están libres
    private boolean salaVacia() {
        for (int i = 0; i < numSillas; i++) {
            if (!sillasDisponibles[i]) {
                return false;
            }
        }
        return true;
    }

    // LADO DEL BARBERO
    public synchronized void observarSillas() {
        // Si la silla de trabajo está libre y la sala vacía, se duerme
        while (sillaTrabajo && salaVacia()) {
            System.out.println("El barbero se echa a dormir");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("El barbero se despierta: hay clientes");
    }
}
