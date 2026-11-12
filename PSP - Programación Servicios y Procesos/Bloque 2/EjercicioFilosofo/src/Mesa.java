public class Mesa {
    private boolean[] tenedoresDisponibles;
    
    public Mesa(int numTenedores) {
        tenedoresDisponibles = new boolean[numTenedores];
        for (int i = 0; i < numTenedores; i++) {
            tenedoresDisponibles[i] = true;
        }
    }
    
    public synchronized void cogerTenedores(int numFilosofo) {
        int tenedorIzq = numFilosofo;
        int tenedorDrc;
        if (numFilosofo == 0) {
            tenedorDrc = 4;
        } else {
            tenedorDrc = numFilosofo - 1;
        }
        while (tenedoresDisponibles[tenedorIzq] == false || tenedoresDisponibles[tenedorDrc] == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tenedoresDisponibles[tenedorIzq] = false;
        tenedoresDisponibles[tenedorDrc] = false;
    }
    
    public synchronized void soltarTenedores(int numFilosofo) {
        int tenedorIzq = numFilosofo;
        int tenedorDrc;
        if (numFilosofo == 0) {
            tenedorDrc = 4;
        } else {
            tenedorDrc = numFilosofo - 1;
        }
        tenedoresDisponibles[tenedorIzq] = true;
        tenedoresDisponibles[tenedorDrc] = true;
        notifyAll();
    }

}

