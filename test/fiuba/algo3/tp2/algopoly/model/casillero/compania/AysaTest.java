package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AysaTest {
	
    @Test
    public void test01JugadorCaeEnAysaYPaga300VecesLoQueSaleEnLosDados() {

        Tablero tablero = new Tablero();
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga,tablero);
        Dinero dineroJugadorDuenioDeEdesur = new Dinero(100000);
        Jugador jugadorDuenioDeEdesur = new Jugador(dineroJugadorDuenioDeEdesur,tablero);

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
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga,tablero);
        Dinero dineroJugadorDuenioDeEdesurYAysa = new Dinero(100000);
        Jugador JugadorDuenioDeEdesurYAysa = new Jugador(dineroJugadorDuenioDeEdesurYAysa,tablero);

        Compania edesur = tablero.obtenerCompaniaPorNombre("Edesur");
        JugadorDuenioDeEdesurYAysa.comprarPropiedad(edesur);
        JugadorDuenioDeEdesurYAysa.comprarPropiedad(edesur);

        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 500 * 3);
        
        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }
    
}
