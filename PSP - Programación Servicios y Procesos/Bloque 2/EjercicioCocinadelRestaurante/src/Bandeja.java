public class Bandeja {
    private final int capacidad;
    private int platosEnBandeja = 0;


    public Bandeja(int capacidad){
        
        this.capacidad = capacidad;

    }
    
    // COCINERO: si está llena espera
    public synchronized void ponerPlato(int numPlato){
        String nombre = Thread.currentThread().getName();
        while (platosEnBandeja == capacidad) {
            System.out.println(nombre + " tiene un plato preparado: " + numPlato + " pero la bandeja está llena.");
            try {
                wait();  
                
            } catch (Exception e) {
                // TODO: handle exception
            }


        }

        platosEnBandeja++;
        System.out.println(nombre + " pone el plato " + numPlato
        + " -> bandeja: " + platosEnBandeja + "/" + capacidad);
        notifyAll();


    }

    // CAMARERO: si está vacía espera
    public synchronized void quitarPlato(){
        String nombre = Thread.currentThread().getName();
        while (platosEnBandeja == 0) {
            System.out.println(nombre + " ve la bandeja vacía, por lo cual espera...");

            try {
                wait();
                
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

        platosEnBandeja--;
        System.out.println(nombre + " se ha llevado un plato -> bandeja " + platosEnBandeja + "/" + capacidad);
        notifyAll();
    }
    



}
