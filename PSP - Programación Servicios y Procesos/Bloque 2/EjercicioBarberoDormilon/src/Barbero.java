public class Barbero extends Thread {
    private Barberia barberia;
    String barbero;



    public Barbero (Barberia barberia){
        this.barberia = barberia;


    }




    public void run() {
    while (true) {
        System.out.println("El barbero observa la zona...");
        barberia.observarSillas();   // aquí 'barberia', no 'barbero'
        
        
    }
  }

}
