public class Resta extends Thread {
    int num1;
    int num2;
    int resultado;
    public Resta(int n1, int n2 ) {
        this.num1 = n1;
        this.num2 = n2;
    }
       
    @Override 
    public void run(){
        resultado = num1 - num2;
        System.out.println("El resultado de la resta ha sido de: " + resultado);
        
    }
}
