public class Ejemplo5 {
    public static void main(String[] args) {

        try {
            int[] numbers = { 1, 2, 3 };
            System.out.println(numbers[5]);
            System.out.println("Ocurrió una excepción ");
        } catch (ArrayIndexOutOfBoundsException AI) {
            System.out.println("Excepción controlada " + AI.getMessage());
        }
    }
}
