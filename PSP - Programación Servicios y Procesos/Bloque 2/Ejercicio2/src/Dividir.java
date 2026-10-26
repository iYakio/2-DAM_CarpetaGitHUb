public class Dividir extends Thread {
    int num1;
    int num2;
    int resultado;
    public Dividir(int n1, int n2 ) {
        this.num1 = n1;
        this.num2 = n2;
        
    }
       
    @Override 
    public void run(){
        resultado = num1 / num2;
        System.out.println("El resultado de la suma ha sido de: " + resultado);
        
    }
}
