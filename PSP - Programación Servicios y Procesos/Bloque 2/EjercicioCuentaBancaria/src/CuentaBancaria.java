public class CuentaBancaria {
    private int dineroActual;
    private final int limiteIngreso;

    public CuentaBancaria(int dineroActual, int limiteIngreso) {
        this.dineroActual = dineroActual;
        this.limiteIngreso = limiteIngreso;
    }

    // GASTAR: espera hasta que haya fondos suficientes
    public synchronized void NuncaNegativo(int gasto) throws InterruptedException {
        String nombre = Thread.currentThread().getName();
        while (dineroActual < gasto) {
            System.out.println(nombre + " quiere gastar " + gasto
                    + " pero solo hay " + dineroActual + ". Espera...");
            wait();
        }
        
        dineroActual -= gasto;
        System.out.println(nombre + " gasta " + gasto + " -> saldo: " + dineroActual);
        notifyAll();
    }

    // INGRESAR: espera si el ingreso superaría el límite de seguridad
    public synchronized void LimiteSeguridad(int ingreso) throws InterruptedException {
        String nombre = Thread.currentThread().getName();
        while (dineroActual + ingreso > limiteIngreso) {
            System.out.println(nombre + " quiere ingresar " + ingreso
                    + " pero superaría el límite (" + limiteIngreso
                    + "), saldo " + dineroActual + ". Espera...");
            wait();
        }
        dineroActual += ingreso;
        System.out.println(nombre + " ingresa " + ingreso + " -> saldo: " + dineroActual);
        notifyAll();
    }
}
