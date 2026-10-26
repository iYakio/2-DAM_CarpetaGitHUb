public class App {
    public static void main(String[] args) throws Exception {
        Palabra p1 = new Palabra("Jeremy");
        Palabra p2 = new Palabra("Robbert");
        Palabra p3 = new Palabra("Maggie");

        p1.start();
        p1.join();
        p2.start();
        p3.start();
    }
}
