public class App {
    public static void main(String[] args) throws Exception {
        Bandeja bandeja = new Bandeja(3);
        int totalPlatos = 8;

        Cocinero cocinero = new Cocinero(totalPlatos, bandeja);
        Camarero camarero1 = new Camarero(totalPlatos, bandeja);
        Camarero camarero2 = new Camarero(totalPlatos, bandeja);

        cocinero.start();
        camarero1.start();
        camarero2.start();

        cocinero.join();
        camarero1.join();
        camarero2.join();
        
    }
}
