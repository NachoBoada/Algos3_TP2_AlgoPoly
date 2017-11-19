package fiuba.algo3.tp2.algopoly;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.ImpuestoAlLujo;

public class SegundaEntregaTest {

    @Test
    public void test15JugadorCaeEnImpuestoAlLujoCon80Pierde10PorcientoSaleCon72() {
    	Dinero dinero = new Dinero(80);
    	Dinero dineroRestante = new Dinero(72);
        Jugador jugador = new Jugador(dinero);
        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();
        
        jugador.caerEn(impuesto);

        Assert.assertTrue(jugador.getCapital().equals(dineroRestante));
    }
	
}
