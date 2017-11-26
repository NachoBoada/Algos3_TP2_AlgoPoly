package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

public class JugadoresTest {

    @Test
    public void testProximoVuelveAlPrimerJugadorAlAvanzarTresVeces() {
        Jugadores jugadores = new Jugadores(new Tablero());

        Jugador primerJugador = jugadores.primero();

        jugadores.proximo();
        jugadores.proximo();
        Jugador ultimoJugador = jugadores.proximo();

        Assert.assertEquals(primerJugador, ultimoJugador);
    }

    @Test
    public void testProximoDevuelveSiempreElPrimeroLuegoDeEliminarLosOtrosJugadores() {
        Jugadores jugadores = new Jugadores(new Tablero());

        Jugador jugadorAeliminar = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar);
        Jugador jugadorAeliminar2 = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar2);
        jugadores.proximo();

        Assert.assertTrue(jugadores.quedaUno());

        Jugador primerJugador = jugadores.primero();

        Jugador segundoJugador = jugadores.proximo();
        Assert.assertEquals(primerJugador, segundoJugador);

        Jugador tercerJugador = jugadores.proximo();
        Assert.assertEquals(primerJugador, tercerJugador);
    }

    @Test
    public void testEliminarDevuelveFalseCuandoNoHayMasJugadores() {
        Jugadores jugadores = new Jugadores(new Tablero());

        Jugador jugadorAeliminar = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar);
        Jugador jugadorAeliminar2 = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar2);
        Jugador jugadorAeliminar3 = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar3);

        Assert.assertFalse(jugadores.eliminar(jugadorAeliminar3));
    }

    @Test
    public void testQuedaUnoDevuelveFalseAlCrearJugadores() {
        Jugadores jugadores = new Jugadores(new Tablero());
        
        Assert.assertFalse(jugadores.quedaUno());
    }
    
    @Test
    public void testQuedaUnoDevuelveTrueAlEliminarDosJugadores() {
        Jugadores jugadores = new Jugadores(new Tablero());

        Jugador jugadorAeliminar = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar);
        Jugador jugadorAeliminar2 = jugadores.proximo();
        jugadores.eliminar(jugadorAeliminar2);
        
        Assert.assertTrue(jugadores.quedaUno());
    }

}
