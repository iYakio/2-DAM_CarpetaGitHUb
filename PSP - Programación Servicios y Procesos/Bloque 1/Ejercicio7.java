import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        try {
            System.out.println("--------------------");
            System.out.println("MENÚ DE INICIO");
            System.out.println("---------------------");
            System.out.println("¿Qué programa desea iniciar de esta lista?");
            System.out.println("1.- Unity");
            System.out.println("2.- Netbeans");

            String opcion = sc.nextLine();

            while (true) {
                switch (opcion) {
                    case "1":
                        ProcessBuilder unity = new ProcessBuilder("C:\\Program Files\\Unity\\Hub\\Editor\\2021.3.45f1\\Editor\\Unity.exe");
                        Process unityAbrir = unity.start();     
                        
                        Thread.sleep(5000);
                        System.out.println("¿Desea cerrar Unity? Si/No");
                        String respuesta = sc.nextLine();

                        if (respuesta.equalsIgnoreCase("Si")) {
                            

                            System.out.println("Cerrando programa en tres segundos...");

                            Thread.sleep(3000);

                            unityAbrir.destroy();
                        } else if (respuesta.equalsIgnoreCase("No")) {
                            System.out.println("El programa se mantendrá activado");
                        }

                        break;

                    case "2":
                        ProcessBuilder Netbeans = new ProcessBuilder("C:\\Program Files\\NetBeans-23\\netbeans\\bin\\netbeans64.exe");
                        Process netbeansAbrir = Netbeans.start();

                        Thread.sleep(5000);
                        System.out.println("¿Desea cerrar Netbeans? Si/No");
                        String respuesta2 = sc.nextLine();

                        if (respuesta2.equalsIgnoreCase("Si")) {
                            System.out.println("Cerrando programa en tres segundos");

                            Thread.sleep(3000);

                            netbeansAbrir.destroy();

                        } else if (respuesta2.equalsIgnoreCase("No")) {
                            System.out.println("El programa se mantendrá activado");
                        }
                    
                        break;

                    case "3":
                        ProcessBuilder Vericode = new ProcessBuilder("taskkill", "/F", "/IM", "Vericode.exe");
                        Process VericodeAbrir = Vericode.start();

                        int cerrar = VericodeAbrir.waitFor();
                        System.out.println("El programa se cerró correctamente " + cerrar);
                }
                sc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
