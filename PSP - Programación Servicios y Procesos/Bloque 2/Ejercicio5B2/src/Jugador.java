/**
 * Jugador
 */
public class Jugador extends Thread {
    private String nombre;


    public Jugador(String nombre){
        this.nombre = nombre;
    }
    

    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("El jugador " + nombre + " va por el numero " + i );
                int random = (int) (1000 + (Math.random() * 2001));
                sleep(random);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}