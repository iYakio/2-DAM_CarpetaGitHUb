public class Jugador extends Thread {
    private String nombre;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        
    }

    public void run(){
        try {

            for (int i = 0; i < 10; i++) {
                System.out.println("El jugador: " + nombre + " va por el numero " + i);
                int tiempo = (int) (1000 +  Math.random()* 2001);
                sleep(tiempo);
                
            }

            System.out.println("El jugador: " + nombre + " ha llegado a la meta");
            
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
