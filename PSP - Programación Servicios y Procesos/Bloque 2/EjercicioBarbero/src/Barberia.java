public class Barberia {
    // Creamos el Barberia para que puedan utilizarlos todos en el main
    private boolean silla;

    public synchronized void esperarCliente(){
        while (silla) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        System.out.println("El barbero se ha dormido ");
        silla = false;
        
    }


    public synchronized void terminarCorte(){
        while (!silla) {
            try {
                System.out.println("El Barbero ha terminado el corte");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        notifyAll();
        
    }


    
}
