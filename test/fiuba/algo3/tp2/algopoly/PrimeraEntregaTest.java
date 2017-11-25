package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

import fiuba.algo3.tp2.algopoly.model.casillero.*;

import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Neuquen;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Tucuman;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

	private static final double DELTA = 1e-15;

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad(), DELTA);
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

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test04JugadorEsPropietarioDeUnBarrioLuegoDeCaerYcomprarlo() {

        Dinero capitalInicial = new Dinero(50000);
        Jugador jugador = new Jugador(capitalInicial);
        SantaFe barrio = new SantaFe();

        jugador.caerEn(barrio);
        jugador.comprarBarrio(barrio);


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

        Dados.getInstance().manipularSuma(4);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(casillero.getPosicion() + 2, jugador.posicionActual());
    }

    @Test
    public void test09CaerEnAvanceDinamicoCon7YUnCapitalDeMilEntoncesAvanzaSeis() {

        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);

        Dados.getInstance().manipularSuma(7);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 6);
    }

    @Test
    public void test10CaerEnAvanceDinamicoConOnceYSinPropiedadesEntoncesAvanzaOnce() {

        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);

        Dados.getInstance().manipularSuma(11);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        //AL AVANZAR 11 CASILLEROS CAIGO EN RETROCESO DINAMICO (18) Y ME HACE RETROCEDER 9
        Assert.assertEquals(9, jugador.posicionActual());
    }

  /*  @Test
    public void test11CaerEnAvanceDinamicoConDoceYConTresPropiedadesEntoncesAvanzaNueve() {

        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.comprarBarrio( new SantaFe());
        jugador.comprarBarrio( new Tucuman());
        jugador.comprarBarrio( new Neuquen());

        Dados.getInstance().manipularSuma(12);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 9);
    }*/

    @Test
    public void test12JugadorCaeEnRetrocesoDinamicoConCuatroYUnaPropiedadEntoncesRetrocedeTres() {

        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.comprarBarrio( new SantaFe() );

        Dados.getInstance().manipularSuma(4);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);
        
        //AL RETROCEDER 3 CAE EN POLICIA (15) Y DE AHI LO MANDA A CARCEL (5)
        Assert.assertEquals(5, jugador.posicionActual());

    }

    @Test
    public void test13JugadorCaeEnRetrocesoDinamicoConDosYTresPropiedadEntoncesNoRetrocede() {

        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);

        jugador.comprarBarrio( new SantaFe() );
        jugador.comprarBarrio( new Tucuman() );
        jugador.comprarBarrio( new Neuquen() );

        Dados.getInstance().manipularSuma(2);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion());

    }

  /*  @Test
    public void test14JugadorCaeEnRetrocesoDinamicoConSieteYCapitalDeMilEntoncesRetrocedeSeis() {

        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);

        Dados.getInstance().manipularSuma(7);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() - 6);


    }*/

    @Test
    public void test15JugadorCaeEnRetrocesoDinamicoConOnceEntoncesRetrocede9() {

        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial);

        Dados.getInstance().manipularSuma(11);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() - 9);

    }

    @Test
    public void test16UnJugadorCaeEnPoliciaNoPuedeMoverseYSuUbicacionEsLaCarcel() {

    	Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial);
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);

        jugador.caerEn(policia);

        Assert.assertFalse(jugador.mover(2));
        Assert.assertEquals(carcel, jugador.casilleroActual());
    }
}
