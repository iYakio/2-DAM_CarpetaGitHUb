public class App {
    public static void main(String[] args) throws Exception {
        Temperatura temp = new Temperatura(20);
        Humedad hum = new Humedad(90);
        Presion pre = new Presion(3);



        temp.start();
        
        pre.start();
        
        hum.start();

        temp.join();
        pre.join();
        hum.join();
    }
}
