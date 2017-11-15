package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.AvanceDinamico;
import fiuba.algo3.tp2.algopoly.model.casillero.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Casillero;
import fiuba.algo3.tp2.algopoly.model.casillero.Quini6;
import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test03JugadorCaeEnQuini6PorTerceraYCuartaVezSuCapitalNoSeIncrementa() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);
        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test04JugadorEsPropietarioDeUnBarrioLuegoDeCaerYcomprarlo() {
        Dinero capitalInicial = new Dinero(0);
        Dinero precioBarrio = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);
        Barrio barrio = new Barrio("test", precioBarrio);

        jugador.caerEn(barrio);

        Assert.assertTrue(jugador.esPropietarioDe(barrio));
    }

    @Test
    public void test05JugadorNoPuedeDesplazarseLuegoDeCaerEnCarcel() {
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);
        Carcel carcel = new Carcel();

        jugador.caerEn(carcel);

        Assert.assertFalse(jugador.mover(1));
    }

    @Test
    public void test06JugadorPuedeMoverseLuegoDePagarFianzaDeCarcel() {
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);
        Carcel carcel = new Carcel();

        jugador.caerEn(carcel);
        jugador.caerEn(carcel);
        jugador.caerEn(carcel);
        jugador.pagarFianza();

        Assert.assertTrue(jugador.mover(2));
    }

    @Test
    public void test07JugadorNoPuedeMoverseAlNoPagarLaFianza() {
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);
        Carcel carcel = new Carcel();

        jugador.caerEn(carcel);

        Assert.assertFalse(jugador.mover(5));
    }
    
    @Test
    public void test08testCaerEnAvanceDinamicoConCuatroYSoloAvanzaDos(){
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.mover(4);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 2);
    }
    
    @Test
    public void test09CaerEnAvanceDinamicoCon7YUnCapitalDeMilEntoncesAvanzaSeis() {

        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.mover(7);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 6);
    }
    
    @Test
    public void test101CaerEnAvanceDinamicoConOnceYSinPropiedadesEntoncesAvanzaOnce() {

        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.mover(11);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 11);
    }
    
    @Test
    public void test102CaerEnAvanceDinamicoConDoceYConTresPropiedadesEntoncesAvanzaNueve() {

        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.comprarBarrio( new Barrio ("SantaFe", new Dinero (10000) ) );
        jugador.comprarBarrio( new Barrio ("Mendoza", new Dinero (20000) ) );
        jugador.comprarBarrio( new Barrio ("Salta", new Dinero (9000) ) );
               
        jugador.mover(12);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 9);
    }
}
