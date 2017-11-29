package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.*;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.ImpuestoAlLujo;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Aysa;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Edesur;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Subte;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Transportes;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Tren;

public class SegundaEntregaTest {

    private static final double DELTA = 1e-15;
    private static final int CAPITAL_INICIAL_JUGADOR = 100000;

    @Test
    public void test01JugadorCaeEnSantaFeSinPropietarioLoCompraYSuCapitalSeDecrementaEn15mil() {

        Tablero tablero = new Tablero();
        SantaFe barrioSantaFe = new SantaFe();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador");

        jugador.caerEn(barrioSantaFe);
        jugador.comprarBarrio(barrioSantaFe);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 15000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test01JugadorCaeEnNeuquenSinPropietarioLoCompraYSuCapitalSeDecrementaEn17mil() {

        Tablero tablero = new Tablero();
        Neuquen barrioNeuquen = new Neuquen();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador");

        jugador.caerEn(barrioNeuquen);
        jugador.comprarBarrio(barrioNeuquen);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 17000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test01JugadorCaeEnBsAsSurSinPropietarioLoCompraYSuCapitalSeDecrementaEn20mil() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador");

        jugador.caerEn(barrioBsAsSur);
        jugador.comprarBarrio(barrioBsAsSur);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 20000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test02UnJugadorDuenioDeBsAsSurYNorteCompraUnaCasaEnElSurYSuCapitalSeDecrementaEn5mil() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador");
        jugador.comprarBarrio(barrioBsAsSur);
        jugador.comprarBarrio(barrioBsAsNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirCasaEn(barrioBsAsSur);

        Assert.assertEquals(capitalJugador - 5000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test02UnJugadorDuenioDeCordobaSurYNorteCompraUnaCasaEnElSurYSuCapitalSeDecrementaEn2mil() {

        Tablero tablero = new Tablero();
        Cordoba regionCordoba = new Cordoba();
        BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
        BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador");
        jugador.comprarBarrio(barrioCordobaSur);
        jugador.comprarBarrio(barrioCordobaNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirCasaEn(barrioCordobaSur);

        Assert.assertEquals(capitalJugador - 2000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test02UnJugadorDuenioDeSaltaSurYNorteCompraUnaCasaEnElSurYSuCapitalSeDecrementaEn4500() {

        Tablero tablero = new Tablero();
        Salta regionSalta = new Salta();
        BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
        BarrioDividido barrioSaltaNorte = regionSalta.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador");
        jugador.comprarBarrio(barrioSaltaSur);
        jugador.comprarBarrio(barrioSaltaNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirCasaEn(barrioSaltaSur);

        Assert.assertEquals(capitalJugador - 4500, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test03UnJugadorCaeEnBsAsSurConUnaCasaEntoncesPaga3milDeAlquiler() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioBsAsSur);
        jugador1.comprarBarrio(barrioBsAsNorte);
        jugador1.construirCasaEn(barrioBsAsNorte);
        jugador1.construirCasaEn(barrioBsAsSur);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioBsAsSur);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 3000, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test03UnJugadorCaeEnCordobaNorteConUnaCasaEntoncesPaga1800DeAlquiler() {

        Tablero tablero = new Tablero();
        Cordoba regionCordoba = new Cordoba();
        BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
        BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioCordobaSur);
        jugador1.comprarBarrio(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaSur);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioCordobaNorte);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 1800, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test03UnJugadorCaeEnSaltaConUnaCasaEntoncesPaga3250DeAlquiler() {

        Tablero tablero = new Tablero();
        Salta regionSalta = new Salta();
        BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioSaltaSur);
        jugador.construirCasaEn(barrioSaltaSur);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioSaltaSur);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 3250, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test04UnJugadorCaeEnBuenosAiresSurConDosCasasEntonesPaga3500DeAlquiler() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioBsAsSur);
        jugador1.construirCasaEn(barrioBsAsSur);
        jugador1.construirCasaEn(barrioBsAsSur);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioBsAsSur);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 3500, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test04UnJugadorCaeEnCordobaNorteConDosCasasEntonesPaga2900DeAlquiler() {

        Tablero tablero = new Tablero();
        Cordoba regionCordoba = new Cordoba();
        BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaNorte);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioCordobaNorte);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 2900, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test04UnJugadorCaeEnSaltaConDosCasasEntonesPaga3850DeAlquiler() {

        Tablero tablero = new Tablero();
        Salta regionSalta = new Salta();
        BarrioDividido barrioSaltaNorte = regionSalta.getBarrioSur();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioSaltaNorte);
        jugador.construirCasaEn(barrioSaltaNorte);
        jugador.construirCasaEn(barrioSaltaNorte);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioSaltaNorte);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 3850, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test05UnJugadorConBsAsNorteYSurNoTieneCupoMaximoDeCasasEntoncesComprarHotelNoDecrementaElCapital() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioBsAsSur);
        jugador.comprarBarrio(barrioBsAsNorte);
        jugador.construirCasaEn(barrioBsAsSur);
        jugador.construirCasaEn(barrioBsAsSur);
        jugador.construirCasaEn(barrioBsAsNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirHotelEn(barrioBsAsSur);
        jugador.construirHotelEn(barrioBsAsNorte);

        Assert.assertEquals(capitalJugador, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test05UnJugadorConCordobaNorteYSurNoTieneCupoMaximoDeCasasEntoncesComprarHotelNoDecrementaElCapital() {

        Tablero tablero = new Tablero();
        Cordoba regionCordoba = new Cordoba();
        BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
        BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioCordobaSur);
        jugador.comprarBarrio(barrioCordobaNorte);
        jugador.construirCasaEn(barrioCordobaNorte);
        jugador.construirCasaEn(barrioCordobaNorte);
        jugador.construirCasaEn(barrioCordobaSur);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirHotelEn(barrioCordobaNorte);
        jugador.construirHotelEn(barrioCordobaSur);

        Assert.assertEquals(capitalJugador, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test05UnJugadorConSaltaNorteYSurNoTieneCupoMaximoDeCasasEntoncesComprarHotelNoDecrementaElCapital() {

        Tablero tablero = new Tablero();
        Salta regionSalta = new Salta();
        BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
        BarrioDividido barrioSaltaNorte = regionSalta.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioSaltaSur);
        jugador.comprarBarrio(barrioSaltaNorte);
        jugador.construirCasaEn(barrioSaltaSur);
        jugador.construirCasaEn(barrioSaltaNorte);
        jugador.construirCasaEn(barrioSaltaNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirHotelEn(barrioSaltaNorte);
        jugador.construirHotelEn(barrioSaltaSur);

        Assert.assertEquals(capitalJugador, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test06UnJugadorConBsAsNorteYSurTieneCupoMaximoDeCasasEntoncesConstruirHotelEnNorteDecrementaElCapitalEn9mil() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioBsAsSur);
        jugador.comprarBarrio(barrioBsAsNorte);
        jugador.construirCasaEn(barrioBsAsSur);
        jugador.construirCasaEn(barrioBsAsSur);
        jugador.construirCasaEn(barrioBsAsNorte);
        jugador.construirCasaEn(barrioBsAsNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirHotelEn(barrioBsAsNorte);

        Assert.assertEquals(capitalJugador - 9000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test06UnJugadorConCordobaNorteYSurTieneCupoMaximoDeCasasEntoncesConstruirHotelEnSurDecrementaElCapitalEn3mil() {

        Tablero tablero = new Tablero();
        Cordoba regionCordoba = new Cordoba();
        BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
        BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioCordobaSur);
        jugador.comprarBarrio(barrioCordobaNorte);
        jugador.construirCasaEn(barrioCordobaNorte);
        jugador.construirCasaEn(barrioCordobaNorte);
        jugador.construirCasaEn(barrioCordobaSur);
        jugador.construirCasaEn(barrioCordobaSur);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirHotelEn(barrioCordobaSur);

        Assert.assertEquals(capitalJugador - 3000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test06UnJugadorConSaltaaNorteYSurTieneCupoMaximoDeCasasEntoncesConstruirHotelDecrementaElCapitalEn7500() {

        Tablero tablero = new Tablero();
        Salta regionSalta = new Salta();
        BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
        BarrioDividido barrioSaltaNorte = regionSalta.getBarrioNorte();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioSaltaSur);
        jugador.comprarBarrio(barrioSaltaNorte);
        jugador.construirCasaEn(barrioSaltaSur);
        jugador.construirCasaEn(barrioSaltaSur);
        jugador.construirCasaEn(barrioSaltaNorte);
        jugador.construirCasaEn(barrioSaltaNorte);
        double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirHotelEn(barrioSaltaSur);

        Assert.assertEquals(capitalJugador - 7500, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test07UnJugadorCaeEnBsAsSurConUnHotelEntoncesPagaUnAlquilerDe5mil() {

        Tablero tablero = new Tablero();
        BuenosAires regionBsAs = new BuenosAires();
        BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
        BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioBsAsSur);
        jugador1.comprarBarrio(barrioBsAsNorte);
        jugador1.construirCasaEn(barrioBsAsSur);
        jugador1.construirCasaEn(barrioBsAsSur);
        jugador1.construirCasaEn(barrioBsAsNorte);
        jugador1.construirCasaEn(barrioBsAsNorte);
        jugador1.construirHotelEn(barrioBsAsSur);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioBsAsSur);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 5000, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test07UnJugadorCaeEnCordobaNorteConUnHotelEntoncesPagaUnAlquilerDe3500() {

        Tablero tablero = new Tablero();
        Cordoba regionCordoba = new Cordoba();
        BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
        BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioCordobaSur);
        jugador1.comprarBarrio(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaNorte);
        jugador1.construirCasaEn(barrioCordobaSur);
        jugador1.construirCasaEn(barrioCordobaSur);
        jugador1.construirHotelEn(barrioCordobaNorte);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioCordobaNorte);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 3500, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test07UnJugadorCaeEnSaltaConUnHotelEntoncesPagaUnAlquilerDe5500() {

        Tablero tablero = new Tablero();
        Salta regionSalta = new Salta();
        BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
        BarrioDividido barrioSaltaNorte = regionSalta.getBarrioNorte();
        Jugador jugador1 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador1.comprarBarrio(barrioSaltaSur);
        jugador1.comprarBarrio(barrioSaltaNorte);
        jugador1.construirCasaEn(barrioSaltaSur);
        jugador1.construirCasaEn(barrioSaltaSur);
        jugador1.construirCasaEn(barrioSaltaNorte);
        jugador1.construirCasaEn(barrioSaltaNorte);
        jugador1.construirHotelEn(barrioSaltaSur);
        Jugador jugador2 = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador2");

        jugador2.caerEn(barrioSaltaSur);

        Assert.assertEquals(CAPITAL_INICIAL_JUGADOR - 5500, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test09UnJugadorPropietarioDeSantaFeConstruyeUnaCasaYSuCapitalSeDecrementaEn4mil() {

        Tablero tablero = new Tablero();
        SantaFe barrioSantaFe = new SantaFe();
        Jugador jugador = new Jugador(new Dinero(CAPITAL_INICIAL_JUGADOR), tablero, "Jugador1");
        jugador.comprarBarrio(barrioSantaFe);
        Double capitalJugador = jugador.getCapital().getCantidad();

        jugador.construirCasaEn(barrioSantaFe);

        Assert.assertEquals(capitalJugador - 4000, jugador.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test11JugadorCaeEnTrenSiendoPropiedadDeOtroJugadorEntoncesSuCapitalSeReduceEn450VecesSuTiroDeDados() {

        Tablero tablero = new Tablero();
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador, tablero, "Jugador1");

        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador, tablero, "Jugador2");

        Tren tren = new Transportes().getTren();
        jugadorCobrador.comprarCompania(tren);

        jugadorPagador.tirarDadosParaTests(3, 2);
        jugadorPagador.caerEn(tren);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 450));

        Assert.assertTrue(jugadorPagador.getCapital().equals(capitalFinalJugadorPagador));
    }

    @Test
    public void test12JugadorCaeEnTrenSiendoPropiedadDelPropietarioDelSubteEntoncesSuCapitalSeReduceEn800VecesSuTiroDeDados() {

        Tablero tablero = new Tablero();
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador, tablero, "Jugador1");

        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador, tablero, "Jugador2");

        Transportes transportes = new Transportes();
        Tren tren = transportes.getTren();
        Subte subte = transportes.getSubte();

        jugadorCobrador.comprarCompania(tren);
        jugadorCobrador.comprarCompania(subte);

        jugadorPagador.tirarDadosParaTests(3, 2);
        jugadorPagador.caerEn(tren);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 800));

        Assert.assertTrue(jugadorPagador.getCapital().equals(capitalFinalJugadorPagador));
    }

    @Test
    public void test13JugadorIntercambiaPropiedadConOtroYTercerJugadorAlCaerLePagaAlNuevoPropietarioDeUnaDeLasPropiedadaes() {

        Tablero tablero = new Tablero();
        SantaFe santaFe = new SantaFe();
        Neuquen neuquen = new Neuquen();
        Dinero dinero1 = new Dinero(100000);
        Dinero dinero2 = new Dinero(100000);
        Dinero dinero3 = new Dinero(100000);
        Jugador jugador1 = new Jugador(dinero1, tablero, "Jugador1");
        Jugador jugador2 = new Jugador(dinero2, tablero, "Jugador2");
        Jugador jugador3 = new Jugador(dinero3, tablero, "Jugador3");
        jugador1.comprarBarrio(santaFe);
        jugador2.comprarBarrio(neuquen);

        jugador1.intercambiarPropiedadPor(santaFe, neuquen);
        jugador3.caerEn(neuquen);

        Assert.assertEquals(100000 - 1500, jugador3.getCapital().getCantidad(), DELTA);
        Assert.assertEquals(100000 - 15000 + 1500, jugador1.getCapital().getCantidad(), DELTA);
        Assert.assertEquals(100000 - 17000, jugador2.getCapital().getCantidad(), DELTA);

    }

    @Test
    public void test14JugadorIntercambiaPropiedadConCasaConOtroYTercerJugadorAlCaerLePagaAlNuevoPropietarioDeUnaDeLasPropiedadaesAlquilerSinCasa() {

        Tablero tablero = new Tablero();
        SantaFe santaFe = new SantaFe();
        Neuquen neuquen = new Neuquen();
        Dinero dinero1 = new Dinero(100000);
        Dinero dinero2 = new Dinero(100000);
        Dinero dinero3 = new Dinero(100000);
        Jugador jugador1 = new Jugador(dinero1, tablero, "Jugador1");
        Jugador jugador2 = new Jugador(dinero2, tablero, "Jugador2");
        Jugador jugador3 = new Jugador(dinero3, tablero, "Jugador3");
        jugador1.comprarBarrio(neuquen);
        jugador1.construirCasaEn(neuquen);
        jugador2.comprarBarrio(santaFe);

        jugador1.intercambiarPropiedadPor(neuquen, santaFe);
        jugador3.caerEn(neuquen);

        Assert.assertEquals(100000 - 1500, jugador3.getCapital().getCantidad(), DELTA);
        Assert.assertEquals(100000 - 17000 - 4800, jugador1.getCapital().getCantidad(), DELTA);
        Assert.assertEquals(100000 - 15000 + 1500, jugador2.getCapital().getCantidad(), DELTA);

    }

    @Test
    public void test15JugadorCaeEnImpuestoAlLujoCon80Pierde10PorcientoSaleCon72() {

        Tablero tablero = new Tablero();
        Dinero dineroJugador = new Dinero(80);
        Jugador jugador = new Jugador(dineroJugador, tablero, "Jugador1");
        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();

        jugador.caerEn(impuesto);
        Dinero dineroRestante = new Dinero(72);

        Assert.assertTrue(jugador.getCapital().equals(dineroRestante));
    }

    @Test
    public void test16JugadorCaeEnEdesurYPaga500VecesLoQueSaleEnLosDados() {

        Tablero tablero = new Tablero();
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga, tablero, "Jugador1");
        Dinero dineroJugadorDuenioDeEdesur = new Dinero(100000);
        Jugador jugadorDuenioDeEdesur = new Jugador(dineroJugadorDuenioDeEdesur, tablero, "Jugador2");
        Servicios servicios = new Servicios();

        Edesur edesur = servicios.getEdesur();
        jugadorDuenioDeEdesur.comprarCompania(edesur);
        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 500 * 3);

        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }

    @Test
    public void test17JugadorCaeEnEdesurDeUnDuenioDeEdesurYAysaYPaga1000VecesLoQueSaleEnLosDados() {

        Tablero tablero = new Tablero();
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga, tablero, "Jugador1");
        Dinero dineroJugadorDuenioDeEdesurYAysa = new Dinero(100000);
        Jugador JugadorDuenioDeEdesurYAysa = new Jugador(dineroJugadorDuenioDeEdesurYAysa, tablero, "Jugador2");
        Servicios servicios = new Servicios();

        Edesur edesur = servicios.getEdesur();
        Aysa aysa = servicios.getAysa();
        JugadorDuenioDeEdesurYAysa.comprarCompania(edesur);
        JugadorDuenioDeEdesurYAysa.comprarCompania(aysa);
        jugadorQuePaga.tirarDadosParaTests(2, 1);
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 1000 * 3);

        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }

}
