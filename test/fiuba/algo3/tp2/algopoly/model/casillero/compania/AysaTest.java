package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AysaTest {

    private static final double DELTA = 1e-15;
	
    @Test
    public void test01JugadorCaeEnAysaYPaga300VecesLoQueSaleEnLosDados() {

        Tablero tablero = new Tablero();
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga,tablero,"Jugador 1");
        Dinero dineroJugadorDuenioAysa = new Dinero(100000);
        Jugador jugadorDuenioDeAysa = new Jugador(dineroJugadorDuenioAysa,tablero,"Jugador 2");

        Compania aysa = tablero.obtenerCompaniaPorNombre("Aysa");
        jugadorDuenioDeAysa.comprarPropiedad(aysa);
        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(aysa);
        Dinero dineroRestante = new Dinero(100000 - 300 * 3);

        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }

    @Test
    public void test02JugadorCaeEnAysaYElDuenioCobraLoQuePagaElQueCayo() {

        Tablero tablero = new Tablero();
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga,tablero,"Jugador 1");
        Dinero dineroJugadorDuenioAysa = new Dinero(100000);
        Jugador jugadorDuenioDeAysa = new Jugador(dineroJugadorDuenioAysa,tablero,"Jugador 2");

        Compania aysa = tablero.obtenerCompaniaPorNombre("Aysa");
        jugadorDuenioDeAysa.comprarPropiedad(aysa);
        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(aysa);
        Dinero dineroConCobro = new Dinero(100000 - 30000 + 300 * 3);

        Assert.assertEquals(dineroConCobro.getCantidad(),jugadorDuenioDeAysa.getCapital().getCantidad(),DELTA);
    }
    
    @Test
    public void test03JugadorCaeEnAysaDeUnDuenioDeEdesurYAysaYPaga500VecesLoQueSaleEnLosDados() {

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
