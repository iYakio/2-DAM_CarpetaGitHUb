package com.mycompany.evaluable2formystats;

import java.util.ArrayList;

/**
 * Almacena la colección de partidas jugadas y ofrece los métodos para
 * gestionarla y para calcular el total de victorias.
 * <p>
 * La ventana y el panel de dibujo usan el mismo objeto de esta clase, de modo
 * que los datos que se añaden en el formulario son los que se dibujan en el
 * gráfico.
 *
 * @author pc111
 */
public class Partidas {
    private ArrayList<Partida> lista = new ArrayList<>();

    /**
     * Añade una nueva partida a la lista.
     *
     * @param partida la partida que se quiere guardar
     */
    public void anadir(Partida partida) {
        lista.add(partida);
    }

    /**
     * Devuelve la lista completa de partidas.
     *
     * @return la lista con todas las partidas almacenadas
     */
    public ArrayList<Partida> getLista() {
        return lista;
    }

    /**
     * Calcula el total de partidas ganadas, sumando las victorias de todas las
     * partidas almacenadas.
     *
     * @return la suma de las victorias de todas las partidas, o 0 si no hay
     *         ninguna
     */
    public int getTotalVictorias() {
        int total = 0;
        for (Partida p : lista) {
            total += p.getVictorias();
        }
        return total;
    }

    /**
     * Devuelve el número total de registros almacenados.
     *
     * @return la cantidad de partidas que hay en la lista
     */
    public int getCantidadRegistros() {
        return lista.size();
    }
}
