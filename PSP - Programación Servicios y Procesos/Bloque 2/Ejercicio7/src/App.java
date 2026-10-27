public class App {
    public static void main(String[] args) throws Exception {
        Temperatura temp = new Temperatura(20);
        Humedad hum = new Humedad(40);
        Presion pre = new Presion(2);


        
        temp.start();
        pre.start();
        hum.start();
        
    }
}
