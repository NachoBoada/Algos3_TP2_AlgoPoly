package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruirException;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.*;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Aysa;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.ServiciosPublicos;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

    private static final double DELTA = 1e-15;
	
    @Test
    public void testCreacionDelJugadorNoEsNullYElCapitalInicialEs0() {

        Tablero tablero = new Tablero();
    	Dinero dinero0 = new Dinero(0);
        Jugador jugador = new Jugador(dinero0,tablero,"Jugador 1");

        Assert.assertEquals(dinero0, jugador.getCapital());
    }

    @Test
    public void testincrementarCapitalEn100000() {

        Tablero tablero = new Tablero();
    	Dinero dinero0 = new Dinero(0);
    	Jugador jugador = new Jugador(dinero0,tablero,"Jugador 1");
    	Dinero dinero1000000 = new Dinero(1000000);
        
        jugador.incrementarCapitalEn(dinero1000000);

        Assert.assertTrue(dinero1000000.equals(jugador.getCapital()));
    }
    
    @Test
    public void testJugadorDerementarCapitalEn100Quedan200() {

        Tablero tablero = new Tablero();
    	Dinero dinero300 = new Dinero(300);
        Dinero dinero200 = new Dinero(200);
        Dinero dinero100 = new Dinero(100);
        Jugador jugador = new Jugador(dinero300,tablero,"Jugador 1");
        
        
        jugador.decrementarCapitalEn(dinero100);

        Assert.assertTrue(dinero200.equals(jugador.getCapital()));
    }
    
    @Test
    public void testJugadorDerementarCapitalLanzarCapitalDelJugadorInsuficienteYAtraparlo() {

        Tablero tablero = new Tablero();
        Dinero dinero100 = new Dinero(100);
        Jugador jugador = new Jugador(dinero100,tablero,"Jugador 1");
        Dinero dinero200 = new Dinero(200);
        
        try{
        	jugador.decrementarCapitalEn(dinero200);
        	Assert.fail();
        }
        catch (CapitalInsuficienteException e){
        	Assert.assertTrue(true);
        }
    }
    
    @Test
    public void testJugadorCompraBarrioYElJugadorTieneCapitalInsuficienteAtrapada() {

        Tablero tablero = new Tablero();
        Dinero dineroSeraInsuficiente = new Dinero(0);
        Jugador jugador = new Jugador(dineroSeraInsuficiente,tablero,"Jugador 1");
        SantaFe santafe = new SantaFe();

        try{
        	jugador.comprarPropiedad(santafe);
        	Assert.fail();
        }
        catch (CapitalInsuficienteException e){
        	Assert.assertTrue(true);
        }
    }

    @Test
    public void testJugadorVendeBarrioYCobraUnQuincePorCientoDeLoQueLeCosto(){

        Tablero tablero = new Tablero();
        Dinero dineroInicialJugador = new Dinero(100000);
        Jugador jugador = new Jugador(dineroInicialJugador,tablero,"Jugador 1");
        SantaFe santaFe = new SantaFe();
        jugador.comprarPropiedad(santaFe);

        jugador.venderPropiedad(santaFe);

        Assert.assertEquals(100000 - 15000 + (15000 * 0.85) , jugador.getCapital().getCantidad(),DELTA);

    }

    @Test
    public void testJugadorVendeCompaniaYCobraUnQuincePorCientoDeLoQueLeCosto(){

        Tablero tablero = new Tablero();
        Dinero dineroInicialJugador = new Dinero(100000);
        Jugador jugador = new Jugador(dineroInicialJugador,tablero,"Jugador 1");
        Compania aysa = new Aysa(new ServiciosPublicos());
        jugador.comprarPropiedad(aysa);

        jugador.venderPropiedad(aysa);

        Assert.assertEquals(100000 - 30000 + (30000 * 0.85) , jugador.getCapital().getCantidad(),DELTA);

    }

    @Test (expected = JugadorDebeComprarElBarrioParaPoderConstruirException.class)
    public void testJugadorQuiereConstruirUnaCasaEnUnBarrioSimpleQueNoComproEntoncesNoPuede(){

        Jugador jugador = new Jugador(new Dinero(100000),new Tablero(),"Jugador");
        Barrio santaFe = new SantaFe();

        jugador.construirCasaEn(santaFe);

    }

    @Test (expected = JugadorDebeComprarElBarrioParaPoderConstruirException.class)
    public void testJugadorQuiereConstruirUnaCasaEnUnBarrioDivididoQueNoComproEntoncesNoPuede(){

        Jugador jugador = new Jugador(new Dinero(100000),new Tablero(),"Jugador");
        Barrio buenosAiresSur = new BuenosAiresSur(new BuenosAires());

        jugador.construirCasaEn(buenosAiresSur);

    }

    @Test (expected = JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException.class)
    public void testJugadorQuiereConstruirUnaCasaEnUnBarrioDivididoPeroNoComproAmbasBarriosDeLaMismaRegion(){

        Jugador jugador = new Jugador(new Dinero(100000),new Tablero(),"Jugador");
        Barrio buenosAiresSur = new BuenosAiresSur(new BuenosAires());

        jugador.comprarPropiedad(buenosAiresSur);

        jugador.construirCasaEn(buenosAiresSur);

    }



}
