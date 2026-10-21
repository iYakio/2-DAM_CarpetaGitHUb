public class Ejemplo6null {
    public static void main(String[] args) {
        try {
            String texto = null;
            int longitud = texto.length();
            System.out.println(longitud);
        } catch (NullPointerException ne) {
            System.out.println("Excepcion controlada " + ne.getMessage());
        }
    }
}
