public class Ejemplo7 {
    public static void main(String[] args) {
         try {
             int a = 10;
             int b = 0;
             int resultado = a/b;
             System.out.println(resultado);
            
        } catch (ArithmeticException AR) {
            System.out.println("Error aritmético " + AR.getMessage());
            AR.printStackTrace();
        } finally {
            System.out.println("Esto sí se imprime por el Finally");
        }


       
    }
}
