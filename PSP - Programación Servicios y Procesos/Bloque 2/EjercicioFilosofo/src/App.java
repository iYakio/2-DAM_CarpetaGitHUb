

import java.io.*;

public class App {

    public static void main(String[] args) {
        Mesa mesa = new Mesa(5);
        new Filosofo("Sócrates", 0, mesa).start();
        new Filosofo("Descartes", 1, mesa).start();
        new Filosofo("Nietzsche", 2, mesa).start();
        new Filosofo("Platón", 3, mesa).start();
        new Filosofo("Kant", 4, mesa).start();
    }
}

