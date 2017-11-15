package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Quini6;
import fiuba.algos3.tp2.algopoly.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Casillero quini6 = new Quini6();

        jugador.caeEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Casillero quini6 = new Quini6();

        jugador.caeEn(quini6);
        jugador.caeEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test03JugadorCaeEnQuini6PorTerceraYCuartaVezSuCapitalNoSeIncrementa() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Casillero quini6 = new Quini6();

        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }
    
    @Test
    public void test04JugadorEsPropietarioDeUnBarrioLuegoDeCaerYcomprarlo() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Barrio barrio = new Barrio();
        
        jugador.caerEn(barrio);
        
        Assert.assertTrue(jugador.esPropietarioDe(barrio));
    }
    
    @Test
    public void test05JugadorNoPuedeDesplazarseLuegoDeCaerEnCarcel() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Carcel carcel = new Carcel();
        
        jugador.caerEn(carcel);
        
        Assert.assertTrue(jugador.esPropietarioDe(barrio));
    }
    
    @Test
    public void test06JugadorPuedeMoverseLuegoDePagarFianzDeCarcel() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Carcel carcel = new Carcel();
        
        jugador.caerEn(carcel);
        jugador.pagarFianza();
        
        Assert.assertTrue(jugador.esPropietarioDe(barrio));
    }

}
