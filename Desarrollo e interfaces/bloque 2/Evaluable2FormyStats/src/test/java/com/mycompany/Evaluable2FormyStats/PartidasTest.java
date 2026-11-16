package com.mycompany.evaluable2formystats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/**
 * Pruebas del método que hace la cuenta en la clase {@link Partidas}.
 *
 * @author iYaki
 */
public class PartidasTest {

    @Test
    void totalConTresPartidas() {
        Partidas partidas = new Partidas();
        partidas.anadir(new Partida(LocalDate.now(), "NFS Pro Street", 3));
        partidas.anadir(new Partida(LocalDate.now(), "Tekken 8", 5));
        partidas.anadir(new Partida(LocalDate.now(), "Fortnite", 7));

        assertEquals(15, partidas.getTotalVictorias());
    }

    @Test
    void totalSinDatos() {
        Partidas partidas = new Partidas();

        assertEquals(0, partidas.getTotalVictorias());
    }
}
