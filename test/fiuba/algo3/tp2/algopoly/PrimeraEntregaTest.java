package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.*;

import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

    private static final double DELTA = 1e-15;

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable quini6 = tablero.obtenerCasilleroPorNombre("Quini 6");

        jugador.caerEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable quini6 = tablero.obtenerCasilleroPorNombre("Quini 6");

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test03JugadorCaeEnQuini6PorTerceraYCuartaVezSuCapitalNoSeIncrementa() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable quini6 = tablero.obtenerCasilleroPorNombre("Quini 6");

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);
        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test04JugadorEsPropietarioDeUnBarrioLuegoDeCaerYcomprarlo() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(50000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Barrio barrio = tablero.obtenerBarrioPorNombre("Santa Fe");

        jugador.caerEn(barrio);
        jugador.comprarPropiedad(barrio);

        Assert.assertTrue(jugador.esPropietarioDe(barrio));
    }

    @Test(expected = JugadorPresoNoSePuedeMoverException.class)
    public void test05JugadorNoPuedeDesplazarseLuegoDeCaerEnCarcel() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");

        jugador.caerEn(carcel);

        jugador.mover(1);
    }

    @Test
    public void test06JugadorPuedeMoverseLuegoDePagarFianzaDeCarcel() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");

        jugador.caerEn(carcel);
        jugador.caerEn(carcel);
        jugador.caerEn(carcel);
        jugador.pagarFianza();

        jugador.mover(1);

        Assert.assertEquals(6, jugador.posicionActual());
    }

    @Test(expected = JugadorPresoNoSePuedeMoverException.class)
    public void test07JugadorNoPuedeMoverseAlNoPagarLaFianza() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");

        jugador.caerEn(carcel);

        jugador.mover(5);
    }

    @Test
    public void test08testCaerEnAvanceDinamicoConCuatroYSoloAvanzaDos() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.tirarDadosParaTests(2, 2);
        Encasillable avanceDinamico = tablero.obtenerCasilleroPorNombre("Avance Dinamico");
        jugador.caerEn(avanceDinamico);

        Assert.assertEquals(avanceDinamico.getPosicion() + 2, jugador.posicionActual());
    }

    @Test
    public void test09CaerEnAvanceDinamicoCon7YUnCapitalDeMilEntoncesAvanzaSeis() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.tirarDadosParaTests(3, 4);
        Encasillable avanceDinamico = tablero.obtenerCasilleroPorNombre("Avance Dinamico");
        jugador.caerEn(avanceDinamico);

        Assert.assertEquals(jugador.posicionActual(), avanceDinamico.getPosicion() + 6);
    }

    @Test
    public void test10CaerEnAvanceDinamicoConOnceYSinPropiedadesEntoncesAvanzaOnce() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.tirarDadosParaTests(5, 6);
        Encasillable avanceDinamico = tablero.obtenerCasilleroPorNombre("Avance Dinamico");
        jugador.caerEn(avanceDinamico);

        //AL AVANZAR 11 CASILLEROS CAIGO EN RETROCESO DINAMICO (18) Y ME HACE RETROCEDER 9
        Assert.assertEquals(9, jugador.posicionActual());
    }

    @Test
    public void test11CaerEnAvanceDinamicoConDoceYConTresPropiedadesEntoncesAvanzaNueve() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.comprarPropiedad(new SantaFe());
        jugador.comprarPropiedad(new Tucuman());
        jugador.comprarPropiedad(new Neuquen());

        jugador.tirarDadosParaTests(6, 6);
        Encasillable avanceDinamico = tablero.obtenerCasilleroPorNombre("Avance Dinamico");
        jugador.caerEn(avanceDinamico);

        Assert.assertEquals(jugador.posicionActual(), avanceDinamico.getPosicion() + 9);
    }

    @Test
    public void test12JugadorCaeEnRetrocesoDinamicoConCuatroYUnaPropiedadEntoncesRetrocedeTres() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.comprarPropiedad(new SantaFe());

        jugador.tirarDadosParaTests(3, 1);
        Encasillable retrocesoDinamico = tablero.obtenerCasilleroPorNombre("Retroceso Dinamico");
        jugador.caerEn(retrocesoDinamico);

        //AL RETROCEDER 3 CAE EN POLICIA (15) Y DE AHI LO MANDA A CARCEL (5)
        Assert.assertEquals(5, jugador.posicionActual());

    }

    @Test
    public void test12JugadorCaeEnRetrocesoDinamicoConCincoYDosPropiedadesConDosCasasEntoncesRetrocedeUno() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        BuenosAires bsas = new BuenosAires();
        BarrioDividido bsasSur = bsas.getBarrioSur();
        BarrioDividido bsasNorte = bsas.getBarrioNorte();
        jugador.comprarPropiedad(bsasNorte);
        jugador.comprarPropiedad(bsasSur);
        jugador.construirCasaEn(bsasSur);
        jugador.construirCasaEn(bsasSur);

        jugador.tirarDadosParaTests(3, 2);
        Encasillable retrocesoDinamico = tablero.obtenerCasilleroPorNombre("Retroceso Dinamico");
        jugador.caerEn(retrocesoDinamico);

        Assert.assertEquals(retrocesoDinamico.getPosicion() - 1, jugador.posicionActual());

    }

    @Test
    public void test13JugadorCaeEnRetrocesoDinamicoConDosYTresPropiedadEntoncesNoRetrocede() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.comprarPropiedad(new SantaFe());
        jugador.comprarPropiedad(new Tucuman());
        jugador.comprarPropiedad(new Neuquen());

        jugador.tirarDadosParaTests(1, 1);
        Encasillable retrocesoDinamico = tablero.obtenerCasilleroPorNombre("Retroceso Dinamico");
        jugador.caerEn(retrocesoDinamico);

        Assert.assertEquals(jugador.posicionActual(), retrocesoDinamico.getPosicion());

    }

    @Test
    public void test14JugadorCaeEnRetrocesoDinamicoConSieteYCapitalDeMilEntoncesRetrocedeSeis() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.tirarDadosParaTests(3, 4);
        Encasillable retrocesoDinamico = tablero.obtenerCasilleroPorNombre("Retroceso Dinamico");
        jugador.caerEn(retrocesoDinamico);

        Assert.assertEquals(jugador.posicionActual(), retrocesoDinamico.getPosicion() - 6);

    }

    @Test
    public void test15JugadorCaeEnRetrocesoDinamicoConOnceEntoncesRetrocede9() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");

        jugador.tirarDadosParaTests(6, 5);
        Encasillable retrocesoDinamico = tablero.obtenerCasilleroPorNombre("Retroceso Dinamico");
        jugador.caerEn(retrocesoDinamico);

        Assert.assertEquals(jugador.posicionActual(), retrocesoDinamico.getPosicion() - 9);

    }

    @Test(expected = JugadorPresoNoSePuedeMoverException.class)
    public void test16UnJugadorCaeEnPoliciaNoPuedeMoverseYSuUbicacionEsLaCarcel() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial, tablero,"Jugador 1");
        Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");
        Encasillable policia = tablero.obtenerCasilleroPorNombre("Policia");

        jugador.caerEn(policia);

        jugador.mover(2);
        Assert.assertEquals(carcel, jugador.casilleroActual());
    }
}
