package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class SubteTest {

    @Test
    public void test01JugadorCaeEnSubteSiendoPropiedadDeOtroJugadorEntoncesSuCapitalSeReduceEn600VecesSuTiroDeDados() {

        Tablero tablero = new Tablero();
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador,tablero);
        
        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador,tablero);
        
        Transportes transportes = new Transportes();
        Subte subte = transportes.getSubte();
        jugadorCobrador.comprarPropiedad(subte);

        jugadorPagador.tirarDadosParaTests(2, 3);
        jugadorPagador.caerEn(subte);

        Dinero capitalFinalJugadorPagador = new Dinero (100000 - (5 * 600));
        
        Assert.assertTrue(capitalFinalJugadorPagador.equals(jugadorPagador.getCapital()));
    }
    
    @Test
    public void test02JugadorCaeEnSubteSiendoPropiedadDelPropietarioDelTrenEntoncesSuCapitalSeReduceEn1100VecesSuTiroDeDados() {

        Tablero tablero = new Tablero();
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador,tablero);
        
        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador,tablero);
        
        Transportes transportes = new Transportes();
        Tren tren = transportes.getTren();
        Subte subte = transportes.getSubte();
        
        jugadorCobrador.comprarPropiedad(tren);
        jugadorCobrador.comprarPropiedad(subte);

        jugadorPagador.tirarDadosParaTests(2, 3);
        jugadorPagador.caerEn(subte);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 1100));
        
        Assert.assertTrue(jugadorPagador.getCapital().equals(capitalFinalJugadorPagador));
    }    
    
    
}
