package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
	
    @Test
    public void testCreacionDelJugadorNoEsNullYElCapitalInicialEs0() {
    	Dinero dinero0 = new Dinero(0);
        Jugador jugador = new Jugador(dinero0);

        Assert.assertEquals(dinero0, jugador.getCapital());
    }

    @Test
    public void testincrementarCapitalEn100000() {
    	Dinero dinero0 = new Dinero(0);
    	Jugador jugador = new Jugador(dinero0);
    	Dinero dinero1000000 = new Dinero(1000000);
        
        jugador.incrementarCapitalEn(dinero1000000);

        Assert.assertTrue(dinero1000000.equals(jugador.getCapital()));
    }
    
    @Test
    public void testJugadorDerementarCapitalEn100Quedan200() {
    	Dinero dinero300 = new Dinero(300);
        Dinero dinero200 = new Dinero(200);
        Dinero dinero100 = new Dinero(100);
        Jugador jugador = new Jugador(dinero300);
        
        
        jugador.derementarCapitalEn(dinero100);

        Assert.assertTrue(dinero200.equals(jugador.getCapital()));
    }
    
    @Test
    public void testJugadorDerementarCapitalLanzarCapitalDelJugadorInsuficienteYAtraparlo() {
        Dinero dinero100 = new Dinero(100);
        Jugador jugador = new Jugador(dinero100);
        Dinero dinero200 = new Dinero(200);
        
        try{
        	jugador.derementarCapitalEn(dinero200);
        	Assert.fail();
        }
        catch (CapitalInsuficiente e){
        	Assert.assertTrue(true);
        }
    }
    


}
