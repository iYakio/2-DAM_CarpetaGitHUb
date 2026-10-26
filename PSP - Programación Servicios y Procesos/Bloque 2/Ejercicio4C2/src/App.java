public class App {
    public static void main(String[] args) throws Exception {
        Palabra p1 = new Palabra("Pimba");
        Palabra p2 = new Palabra("la");
        Palabra p3 = new Palabra("cuaca");

        p1.start();
        p1.join();
        p2.start();
        p3.start();
    }
}
