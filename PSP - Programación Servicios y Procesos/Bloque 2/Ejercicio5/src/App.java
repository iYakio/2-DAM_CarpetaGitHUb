public class App {
    public static void main(String[] args) throws Exception {
        Jugador j1 = new Jugador("Tobias");
        Jugador j2 = new Jugador("Jeremias");
        Jugador j3 = new Jugador("Pablo");

        j1.start();
        j2.start();
        j3.start();
    }
}
