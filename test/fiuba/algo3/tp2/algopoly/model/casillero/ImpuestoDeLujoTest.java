package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class ImpuestoDeLujoTest {
	
    @Test
    public void testImpuestoAlLujoDe10PorcientoSobre100Quedan90() {
    	Dinero dinero = new Dinero(100);
    	Dinero dineroRestante = new Dinero(90);
        Jugador jugador = new Jugador(dinero);
        ImpuestoDeLujo impuesto = new ImpuestoDeLujo();
        
        jugador.caerEn(impuesto);

        Assert.assertTrue(jugador.getCapital().equals(dineroRestante));
    }

}
