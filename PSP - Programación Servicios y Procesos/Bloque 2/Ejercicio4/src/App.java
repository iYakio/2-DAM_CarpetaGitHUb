public class App {
    public static void main(String[] args) throws Exception {
        Palabra palabra1 = new Palabra("hola");
        Palabra palabra2 = new Palabra("medac");
        Palabra palabra3 = new Palabra("davante");

        // el metodo join() obliga a utilizar excepciones

        try {
            palabra1.start();
            palabra1.join(); // Hasta que no acabe el hilo palabra1 no se ejecutan
            palabra2.start();
            palabra3.start();


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
