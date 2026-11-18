public class App {
    public static void main(String[] args) throws Exception {
        CuentaBancaria cuenta = new CuentaBancaria(500, 800);

        
        Padre padre = new Padre(cuenta);
        Madre madre = new Madre(cuenta);
        Hijo hijo = new Hijo(cuenta);

        padre.start();
        madre.start();
        hijo.start();

        padre.join();
        madre.join();
        hijo.join();
        System.out.println("Fin. Todos han terminado.");
    }
}
