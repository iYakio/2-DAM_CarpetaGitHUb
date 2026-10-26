import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            String url = "https://medac.es/";
            String rutaChrome = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            String rutaEdge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";

            // En los navegadores necesitas poner la variable y una url en especifico porque así hara respectivamente, abrir el navegador y meterse en la url seleccionada
            ProcessBuilder chrome = new ProcessBuilder(rutaChrome, url);
           // chrome.start();
            Process ControlChrome = chrome.start();

            ProcessBuilder edge = new ProcessBuilder(rutaEdge, url);
           // edge.start();
            Process ControlEdge = edge.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
