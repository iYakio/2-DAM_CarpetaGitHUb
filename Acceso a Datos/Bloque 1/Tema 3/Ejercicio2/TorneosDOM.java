import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;

public class TorneosDOM {

    public static void main(String[] args) {

        try {

            File fichero = new File("./Tema 3/Ejercicio2/ficheroEj2.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(fichero);

            documento.getDocumentElement().normalize();

            NodeList torneos = documento.getElementsByTagName("torneo");

            for (int i = 0; i < torneos.getLength(); i++) {

                Element torneo = (Element) torneos.item(i);

                String nombre = torneo.getElementsByTagName("nombre").item(0).getTextContent();

                String pais = torneo.getAttribute("pais");

                System.out.println("Torneo: " + nombre + " (" + pais + ")");

                NodeList jugadores = torneo.getElementsByTagName("jugador");

                for (int j = 0; j < jugadores.getLength(); j++) {

                    Element jugador = (Element) jugadores.item(j);

                    String nombreJugador = jugador.getElementsByTagName("nombreJugador").item(0).getTextContent();

                    String ranking = jugador.getElementsByTagName("ranking").item(0).getTextContent();

                    String nacionalidad = jugador.getElementsByTagName("nacionalidad").item(0).getTextContent();

                    String edad = jugador.getElementsByTagName("edad").item(0).getTextContent();

                    System.out.println("- " + nombreJugador + " (Ranking: " + ranking + ", " + nacionalidad + ", " + edad + " años)");
                }

                System.out.println("Total de jugadores: " + jugadores.getLength());
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Hice un xml en relación al tennis y sus jugadores en torneos, se empieza con un elemeto raiz que en este caso es (torneo+)
// con la " + " quiere decir que puede haber uno o más torneos
// Definimos "torneo" en ELMENT con las variables de ( nombre, jugadores ) puede tener un nombre y varios jugadores
// ATTLIST muestar los atributos, el nombre del pais y la cdata = es un tipo de texto y el #REQUIRED que quiere decir que es obligatorio

// Este .java nos buscará el ficheroEj2.xml que relaciona con nuestro .java
// Creamos la fábrica DOM "DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); " esto es capaz de crear una fábrica que construye los lectores XML, es basicamente una "máquina de crear lectores"
// Creamos el lector que leerá los XML "DocumentBuilder builder = factory.newDocumentBuilder();"
// Obtenemos todos los torneos con "NodeList torneos = documento.getElementsByTagName("torneo"); y lo guarda en una variable
// Con un fori recorremos los torneos que acabamos de extraer "torneos" con un torneos.getLength()
// Posteriormente cogemos cada variable con su elemento recogido "elementbytagname" y se guarda en una variable extra
// item(0) obtiene el primer elemento encontrado, como normalmente solo habrá una nacionalidad, se usa la posición 0
// getTextContent() extrae todo el texto que hay dentro de la etiqueta
// Cuando lo hemos recogido todo, fuera del fori creamos un sout que diga el total de jugadores en un resumen global con jugadores.getLength()
