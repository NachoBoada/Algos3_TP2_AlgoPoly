package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

public class AysaTest {
	
    @Test
    public void test01JugadorCaeEnAysaYPaga300VecesLoQueSaleEnLosDados() {
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga);
        Dinero dineroJugadorDuenioDeEdesur = new Dinero(100000);
        Jugador jugadorDuenioDeEdesur = new Jugador(dineroJugadorDuenioDeEdesur);
        Servicios servicios = new Servicios();

        Aysa aysa = servicios.getAysa();
        jugadorDuenioDeEdesur.comprarCompania(aysa);
        jugadorQuePaga.mover(3);
        jugadorQuePaga.caerEn(aysa);
        Dinero dineroRestante = new Dinero(100000 - 300 * 3);

        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }
    
    @Test
    public void test02JugadorCaeEnAysaDeUnDuenioDeEdesurYAysaYPaga500VecesLoQueSaleEnLosDados() {
    	Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga);
        Dinero dineroJugadorDuenioDeEdesurYAysa = new Dinero(100000);
        Jugador JugadorDuenioDeEdesurYAysa = new Jugador(dineroJugadorDuenioDeEdesurYAysa);
        Servicios servicios = new Servicios();
        
        Edesur edesur = servicios.getEdesur();
        Aysa aysa = servicios.getAysa();
        JugadorDuenioDeEdesurYAysa.comprarCompania(edesur);
        JugadorDuenioDeEdesurYAysa.comprarCompania(aysa);

        Dados.getInstance().manipularSuma(3);
        jugadorQuePaga.caerEn(aysa);
        Dinero dineroRestante = new Dinero(100000 - 500 * 3);
        
        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }
    
}
