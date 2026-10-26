public class Jugador extends Thread {
    private String nombre;
    private int tiempo;

    public Jugador(String nombre){
        this.nombre = nombre;

        
    }

    public void run(){
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("El jugador " + nombre + " va por el numero " + i );
                    tiempo = (int) (1000 + (Math.random() * 2001));
                    sleep(tiempo);

                    
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
    }
}
