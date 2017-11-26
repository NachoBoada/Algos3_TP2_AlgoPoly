package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BuenosAires;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Neuquen;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Tucuman;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

	private static final double DELTA = 1e-15;

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test03JugadorCaeEnQuini6PorTerceraYCuartaVezSuCapitalNoSeIncrementa() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Quini6 quini6 = new Quini6();

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
        Jugador jugador = new Jugador(capitalInicial,tablero);
        SantaFe barrio = new SantaFe();

        jugador.caerEn(barrio);
        jugador.comprarBarrio(barrio);


        Assert.assertTrue(jugador.esPropietarioDe(barrio));
    }

    @Test (expected = JugadorPresoNoSePuedeMoverException.class)
    public void test05JugadorNoPuedeDesplazarseLuegoDeCaerEnCarcel() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Carcel carcel = new Carcel();

        jugador.caerEn(carcel);

        jugador.mover(1);
    }

    @Test
    public void test06JugadorPuedeMoverseLuegoDePagarFianzaDeCarcel() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Carcel carcel = new Carcel();

        jugador.caerEn(carcel);
        jugador.caerEn(carcel);
        jugador.caerEn(carcel);
        jugador.pagarFianza();

        jugador.mover(1);

        Assert.assertEquals(6,jugador.posicionActual());
    }

    @Test (expected = JugadorPresoNoSePuedeMoverException.class)
    public void test07JugadorNoPuedeMoverseAlNoPagarLaFianza() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Carcel carcel = new Carcel();

        jugador.caerEn(carcel);

        jugador.mover(5);
    }

    @Test
    public void test08testCaerEnAvanceDinamicoConCuatroYSoloAvanzaDos(){

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        Dados.getInstance().manipularSuma(4);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(casillero.getPosicion() + 2, jugador.posicionActual());
    }

    @Test
    public void test09CaerEnAvanceDinamicoCon7YUnCapitalDeMilEntoncesAvanzaSeis() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        Dados.getInstance().manipularSuma(7);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 6);
    }

    @Test
    public void test10CaerEnAvanceDinamicoConOnceYSinPropiedadesEntoncesAvanzaOnce() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        Dados.getInstance().manipularSuma(11);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        //AL AVANZAR 11 CASILLEROS CAIGO EN RETROCESO DINAMICO (18) Y ME HACE RETROCEDER 9
        Assert.assertEquals(9, jugador.posicionActual());
    }

    @Test
    public void test11CaerEnAvanceDinamicoConDoceYConTresPropiedadesEntoncesAvanzaNueve() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        jugador.comprarBarrio( new SantaFe());
        jugador.comprarBarrio( new Tucuman());
        jugador.comprarBarrio( new Neuquen());

        Dados.getInstance().manipularSuma(12);
        AvanceDinamico casillero = new AvanceDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() + 9);
    }

    @Test
    public void test12JugadorCaeEnRetrocesoDinamicoConCuatroYUnaPropiedadEntoncesRetrocedeTres() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        jugador.comprarBarrio( new SantaFe() );

        Dados.getInstance().manipularSuma(4);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);
        
        //AL RETROCEDER 3 CAE EN POLICIA (15) Y DE AHI LO MANDA A CARCEL (5)
        Assert.assertEquals(5, jugador.posicionActual());

    }
    
    @Test
    public void test12JugadorCaeEnRetrocesoDinamicoConCincoYDosPropiedadesConDosCasasEntoncesRetrocedeUno() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        
        BuenosAires bsas = new BuenosAires();
        BarrioDividido bsasSur = bsas.getBarrioSur();
        BarrioDividido bsasNorte = bsas.getBarrioNorte();
        jugador.comprarBarrio(bsasNorte);
        jugador.comprarBarrio(bsasSur);
        jugador.construirCasaEn(bsasSur);
        jugador.construirCasaEn(bsasSur);

        Dados.getInstance().manipularSuma(5);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);
        
        Assert.assertEquals(casillero.getPosicion() - 1, jugador.posicionActual());

    }

    @Test
    public void test13JugadorCaeEnRetrocesoDinamicoConDosYTresPropiedadEntoncesNoRetrocede() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        jugador.comprarBarrio( new SantaFe() );
        jugador.comprarBarrio( new Tucuman() );
        jugador.comprarBarrio( new Neuquen() );

        Dados.getInstance().manipularSuma(2);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion());

    }

    @Test
    public void test14JugadorCaeEnRetrocesoDinamicoConSieteYCapitalDeMilEntoncesRetrocedeSeis() {


        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        Dados.getInstance().manipularSuma(7);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() - 6);


    }

    @Test
    public void test15JugadorCaeEnRetrocesoDinamicoConOnceEntoncesRetrocede9() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(1000);
        Jugador jugador = new Jugador(capitalInicial,tablero);

        Dados.getInstance().manipularSuma(11);
        RetrocesoDinamico casillero = new RetrocesoDinamico();
        jugador.caerEn(casillero);

        Assert.assertEquals(jugador.posicionActual(), casillero.getPosicion() - 9);

    }

    @Test (expected = JugadorPresoNoSePuedeMoverException.class)
    public void test16UnJugadorCaeEnPoliciaNoPuedeMoverseYSuUbicacionEsLaCarcel() {

        Tablero tablero = new Tablero();
    	Dinero capitalInicial = new Dinero(100000);
        Jugador jugador = new Jugador(capitalInicial,tablero);
        Carcel carcel = new Carcel();
        Policia policia = new Policia(carcel);

        jugador.caerEn(policia);

        jugador.mover(2);
        Assert.assertEquals(carcel, jugador.casilleroActual());
    }
}
