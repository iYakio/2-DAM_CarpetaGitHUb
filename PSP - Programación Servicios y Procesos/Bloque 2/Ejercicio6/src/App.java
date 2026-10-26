public class App {
    public static void main(String[] args) throws Exception {

        int[] millon = new int[200_000_000];

        long antesArray = System.currentTimeMillis();
        long suma = 0;

        for (int i = 0; i < millon.length; i++) {
            millon[i] = (int) (Math.random() * 100);
            suma += millon[i];


        }

        long despuesArray = System.currentTimeMillis();
        System.out.println("Tiempo total de la app: " + (antesArray + despuesArray) + " ms");
        System.out.println("Total de suma: " + suma);
        

        
    }

    
    


}
