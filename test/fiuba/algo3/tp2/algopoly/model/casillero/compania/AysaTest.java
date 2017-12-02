package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AysaTest {
	
    @Test
    public void test01JugadorCaeEnAysaYPaga300VecesLoQueSaleEnLosDados() {

        Tablero tablero = new Tablero();
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga,tablero,"Jugador 1");
        Dinero dineroJugadorDuenioDeEdesur = new Dinero(100000);
        Jugador jugadorDuenioDeEdesur = new Jugador(dineroJugadorDuenioDeEdesur,tablero,"Jugador 2");

        Compania aysa = tablero.obtenerCompaniaPorNombre("Aysa");
        jugadorDuenioDeEdesur.comprarPropiedad(aysa);
        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(aysa);
        Dinero dineroRestante = new Dinero(100000 - 300 * 3);

        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }
    
    @Test
    public void test02JugadorCaeEnAysaDeUnDuenioDeEdesurYAysaYPaga500VecesLoQueSaleEnLosDados() {

        Tablero tablero = new Tablero();
    	Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga,tablero,"Jugador 1");
        Dinero dineroJugadorDuenioDeEdesurYAysa = new Dinero(100000);
        Jugador JugadorDuenioDeEdesurYAysa = new Jugador(dineroJugadorDuenioDeEdesurYAysa,tablero,"Jugador 2");

        Compania edesur = tablero.obtenerCompaniaPorNombre("Edesur");
        Compania aysa = tablero.obtenerCompaniaPorNombre("Aysa");
        JugadorDuenioDeEdesurYAysa.comprarPropiedad(edesur);
        JugadorDuenioDeEdesurYAysa.comprarPropiedad(aysa);

        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(aysa);
        Dinero dineroRestante = new Dinero(100000 - 500 * 3);
        
        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }
    
}
