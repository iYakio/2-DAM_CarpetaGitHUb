import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean cerrar = true;
        try {

            while (cerrar == true) {
                System.out.println("\n");
                System.out.println("-------- Menu ---------- ");
                System.out.println("1. Guardar ");
                System.out.println("2. Imprimir ");
                System.out.println("3. Salir ");
                System.out.println("elige una opcion ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:

                        System.out.println("----- Formulario de Matriculación -----");
                        System.out.println("\n");
                        System.out.println("Nombres y apellidos: ");
                        String nombre = sc.nextLine();

                        System.out.println("Email: ");
                        String email = sc.nextLine();

                        System.out.println("Fecha de Nacimiento ( por ejemplo 13 / 02 / 2001): ");
                        String fecha = sc.nextLine();

                        System.out.println("Genero: ");
                        String genero = sc.nextLine();

                        System.out.println("titulacion de acceso: ");
                        String titulacion = sc.nextLine();

                        System.out.println("observaciones ");
                        String observaciones = sc.nextLine();

                        String formulario = "=== Formulario de Matriculacion ===\n" +
                                "Nombre y Apellidos: " + nombre + "\n" +
                                "Email: " + email + "\n" +
                                "Fecha de Nacimiento: " + fecha + "\n" +
                                "Genero: " + genero + "\n" +
                                "Titulación de Acceso: " + titulacion + "\n" +
                                "Observaciones: " + observaciones;

                        FileWriter escritor = new FileWriter(
                                "C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\matricula.txt");
                        escritor.write(formulario);
                        escritor.close();

                        System.out.println("Formulario finalizado ");

                        break;

                    case 2:

                        FileReader lector = new FileReader("C:\\Users\\iYaki\\OneDrive\\Escritorio\\trabajos temporales 2ºDAM\\matricula.txt");
                        int caracter;

                        // Se utiliza print en lugar de println para que salga recto
                        while ((caracter = lector.read()) != -1) {
                            System.out.print((char) caracter);
                        }

                        lector.close();
                        break;

                    case 3:

                        System.out.println("Programa finalizado... ");
                        cerrar = false;
                        break;
                }

            }

        } catch (IOException e) {
            System.out.println("Fallo de escritura");
            e.printStackTrace();
        } catch (NumberFormatException ne) {
            System.out.println("Debe de escribir un número asociado");
            ne.printStackTrace();
        }
        sc.close();
    }
}
