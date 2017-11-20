package fiuba.algo3.tp2.algopoly;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.ImpuestoAlLujo;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Aysa;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Edesur;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;

public class SegundaEntregaTest {

    @Test
    public void test15JugadorCaeEnImpuestoAlLujoCon80Pierde10PorcientoSaleCon72() {
    	Dinero dineroJugador = new Dinero(80);
        Jugador jugador = new Jugador(dineroJugador);
        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
        
        jugador.caerEn(impuesto);
        Dinero dineroRestante = new Dinero(72);
        
        Assert.assertTrue(jugador.getCapital().equals(dineroRestante));
    }
    
    @Test
    public void test16JugadorCaeEnEdesurYPaga500VecesLoQueSaleEnLosDados() {
    	Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga);
        Dinero dineroJugadorDuenioDeEdesur = new Dinero(100000);
        Jugador jugadorDuenioDeEdesur = new Jugador(dineroJugadorDuenioDeEdesur);
        Servicios servicios = new Servicios();
        
        Edesur edesur = servicios.getEdesur();
        jugadorDuenioDeEdesur.comprarCompania(edesur);
        jugadorQuePaga.tirarDados();
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 500 * jugadorQuePaga.getUltimaSumaDados());
        
        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }
    
    /* --El test funcionara cuando este implementado lo de que una persona sea duenia de AYSAyEDESUR.
    @Test
    public void test17JugadorCaeEnEdesurDeUnDuenioDeEdesurYAysaYPaga1000VecesLoQueSaleEnLosDados() {
    	Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga);
        Dinero dineroJugadorDuenioDeEdesurYAysa = new Dinero(100000);
        Jugador JugadorDuenioDeEdesurYAysa = new Jugador(dineroJugadorDuenioDeEdesurYAysa);
        Servicios servicios = new Servicios();
        
        Edesur edesur = servicios.getEdesur();
        Aysa aysa = servicios.getAysa();
        JugadorDuenioDeEdesurYAysa.comprarCompania(edesur);
        JugadorDuenioDeEdesurYAysa.comprarCompania(aysa);
        jugadorQuePaga.tirarDados();
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 1000 * jugadorQuePaga.getUltimaSumaDados());
        
        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    } */
	
}
