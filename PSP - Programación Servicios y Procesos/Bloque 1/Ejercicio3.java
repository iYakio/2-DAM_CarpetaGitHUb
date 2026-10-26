import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            

            String rutaEdge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
            String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

            String url = "";
            String navegador = "";

            System.out.println("¿Qué navegador desea usar? (Edge o Chrome)");
            String respuestaNav = sc.nextLine();

            System.out.println("¿Qué web desea abrir? (Medac o Youtube)");
            String respuestaWeb = sc.nextLine();

            // Seleccionar navegador
            if (respuestaNav.equalsIgnoreCase("Edge")) {
                navegador = rutaEdge;
            } else if (respuestaNav.equalsIgnoreCase("Chrome")) {
                navegador = rutaChrome;
            } else {
                System.out.println("Navegador no válido");
                
            }

            // Seleccionar web
            if (respuestaWeb.equalsIgnoreCase("Medac")) {
                url = "https://medac.es";
            } else if (respuestaWeb.equalsIgnoreCase("Youtube")) {
                url = "https://www.youtube.com";
            } else {
                System.out.println("Web no válida");
                
            }

            // Abrir navegador con la URL elegida
            ProcessBuilder pb = new ProcessBuilder(navegador, url);
            pb.start();

            System.out.println("Abriendo " + url);

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
