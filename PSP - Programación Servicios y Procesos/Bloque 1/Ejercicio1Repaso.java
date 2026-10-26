import java.io.IOException;
import java.util.Scanner;



public class Ejercicio1Repaso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cerrar = true;

        while (cerrar == true) {
            try {
                System.out.println("----------------------------------------------");
                System.out.println("============= PANEL DE ESTUDIO ===============");
                System.out.println("\n");
                System.out.println("1.- Abrir el campus virtual");
                System.out.println("2.- Tomar apuntes");
                System.out.println("3.- Ver mis descargas");
                System.out.println("4.- Terminar de tomar apuntes");
                System.out.println("5.- Salir");
                System.out.println("----------------------------------------------");

                System.out.println("\n");
                System.out.println("Elija la opción que quiere realizar mediante un número");
                int decision = Integer.parseInt(sc.nextLine());

                switch (decision) {
                    case 1:
                        String navegador = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
                        String urlDavante = "https://www.davante.es/";

                        ProcessBuilder NavDavante = new ProcessBuilder(navegador, urlDavante);
                        // 1 navegador que utilizas
                        // 2 la pagina que utilizarás con ese navegador
                        System.out.println("Abriendo navegador de davante");
                        Thread.sleep(4000);
                        NavDavante.start();

                        break;

                    case 2:
                        String apuntes = "./apuntes.txt";
                        ProcessBuilder abrirNotepad = new ProcessBuilder("notepad", apuntes);

                        System.out.println("Abiendo NOTEPAD");
                        Thread.sleep(4000);
                        abrirNotepad.start();

                        break;
                    case 3:
                        String rutaDescargas = "C:\\Users\\PC111\\Downloads";

                        ProcessBuilder procesoDescargas = new ProcessBuilder("explorer", rutaDescargas);
                        System.out.println("Abriendo Explorador de archivos - Descargas");
                        Thread.sleep(4000);
                        procesoDescargas.start();
                        
                        break;


                    case 4:
                        System.out.println("Cerrando Bloc de notas");
                        Thread.sleep(4000);

                        ProcessBuilder cerrarBloc = new ProcessBuilder("cmd", "/c", "taskkill /IM notepad.exe /F");
                                                                                        // /c hace que active el comando y lo cierre
                                                                                        // /k hace que active el comando pero lo deja abierto
                        cerrarBloc.start();

                        System.out.println("Bloc de notas cerrado correctamente");

                        break;
                }

            } catch (InterruptedException e) {
                System.out.println("Error de lectura o comprension");
                
            } catch (IOException e){
                System.out.println("No se pudo leer " + e.getMessage());
            }
        }

        sc.close();

    }
}
