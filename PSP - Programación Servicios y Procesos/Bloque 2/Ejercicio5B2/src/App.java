public class App {
    public static void main(String[] args) throws Exception {
        Jugador j1 = new Jugador("Pimpom");
        Jugador j2 = new Jugador("Ortega");
        Jugador j3 = new Jugador("Rodriguez");

        j1.start();
        j2.start();
        j3.start();
    }
}
