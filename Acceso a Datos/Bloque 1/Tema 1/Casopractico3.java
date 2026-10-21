import java.io.File;

public class Casopractico3 {
    public static void main(String[] args) {
         String nombreCarpeta = "NuevaCarpeta";
         //Aquí guardamos el nombre de la carpeta que queremos crear
         File carpeta = new File(".\\TEMA01\\Ejemplos", nombreCarpeta);
        // Estoy creando un objeto de File "carpeta" que representa la ruta, que creara todo el directorio de TEMA01 junto a la carpeta Ejemplos
        // y dentro el mismo haremos todo lo demás que viene ahora

        // File sirve para gestionar unicamente, es decir, ubicar rutas en el programa



        if (carpeta.exists())
            System.out.println("La carpeta " + carpeta.getName() + " ya existe");
        // Si dentro de la carpeta "Ejemplos" encuentra una carpeta llamada "NuevaCarpeta"
        // saldrá el mensaje anterior de sout
        else {
            carpeta.mkdirs();
        // si el if anterior lo revisa y no existe esa carpeta con ese nombre, este else creara en esa ruta especifica del "File carpeta" una carpeta con ese nombre y mostrará lo siguiente
            System.out.println("La carpeta " + carpeta.getName() + " se ha creado");
            // Mostrará el nombre
            System.out.println("Ruta absoluta " + carpeta.getAbsolutePath());
            // Muestra la ruta absoluta, es decir, la ruta entera desde el inicio en C:\
            System.out.println("Ruta relativa " + carpeta.getPath());
            // Muestra la ruta relativa, en este caso, .\TEMA01
            System.out.println("Carpeta padre " + carpeta.getParent());
            // Muestra la carpeta padre de la que estás creando
        }
    }
}
