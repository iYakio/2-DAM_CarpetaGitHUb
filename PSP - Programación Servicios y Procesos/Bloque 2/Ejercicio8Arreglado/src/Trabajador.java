public class Trabajador extends Thread {
    Almacen a;



    public Trabajador(Almacen al){
        this.a = al; // Guardo el almacen comun que se creo en el main


    }


    public void run(){
        while (true) {
            try {
                sleep(((int) (Math.random()*40001)) + 1000);

            } catch (InterruptedException e) {
                
            }

            this.a.eliminarProducto();
        }
    }



}
