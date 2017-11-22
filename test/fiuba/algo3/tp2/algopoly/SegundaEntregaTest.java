package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Neuquen;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
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

    @Test
    public void test11JugadorCaeEnTrenSiendoPropiedadDeOtroJugadorEntoncesSuCapitalSeReduceEn450VecesSuTiroDeDados() {
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador);
        
        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador);
        
        Tren tren = new Transportes().getTren();
        jugadorCobrador.comprarCompania(tren);

        jugadorPagador.mover(5);
        jugadorPagador.caerEn(tren);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 450));
        
        Assert.assertTrue(jugadorPagador.getCapital().equals(capitalFinalJugadorPagador));
    }

    
    @Test
    public void test12JugadorCaeEnTrenSiendoPropiedadDelPropietarioDelSubteEntoncesSuCapitalSeReduceEn800VecesSuTiroDeDados() {
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador);
        
        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador);
        
        Transportes transportes = new Transportes();
        Tren tren = transportes.getTren();
        Subte subte = transportes.getSubte();
        
        jugadorCobrador.comprarCompania(tren);
        jugadorCobrador.comprarCompania(subte);

        jugadorPagador.mover(5);
        jugadorPagador.caerEn(tren);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 800));
        
        Assert.assertTrue(jugadorPagador.getCapital().equals(capitalFinalJugadorPagador));
    }    
    

    @Test
    public void test15JugadorCaeEnImpuestoAlLujoCon80Pierde10PorcientoSaleCon72() {
        Dinero dineroJugador = new Dinero(80);
        Jugador jugador = new Jugador(dineroJugador);
        ImpuestoAlLujo impuesto = new ImpuestoAlLujo();

        jugador.caerEn(impuesto);
        Dinero dineroRestante = new Dinero(72);

        Assert.assertTrue(jugador.getCapital().equals(dineroRestante));
    }
    

    @Test
    public void test16JugadorCaeEnEdesurYPaga500VecesLoQueSaleEnLosDados() {
        Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga);
        Dinero dineroJugadorDuenioDeEdesur = new Dinero(100000);
        Jugador jugadorDuenioDeEdesur = new Jugador(dineroJugadorDuenioDeEdesur);
        Servicios servicios = new Servicios();

        Edesur edesur = servicios.getEdesur();
        jugadorDuenioDeEdesur.comprarCompania(edesur);
        jugadorQuePaga.mover(3);
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 500 * 3);

        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }

    
    @Test
    public void test17JugadorCaeEnEdesurDeUnDuenioDeEdesurYAysaYPaga1000VecesLoQueSaleEnLosDados() {
    	Dinero dineroJugadorQuePaga = new Dinero(100000);
        Jugador jugadorQuePaga = new Jugador(dineroJugadorQuePaga);
        Dinero dineroJugadorDuenioDeEdesurYAysa = new Dinero(100000);
        Jugador JugadorDuenioDeEdesurYAysa = new Jugador(dineroJugadorDuenioDeEdesurYAysa);
        Servicios servicios = new Servicios();
        
        Edesur edesur = servicios.getEdesur();
        Aysa aysa = servicios.getAysa();
        JugadorDuenioDeEdesurYAysa.comprarCompania(edesur);
        JugadorDuenioDeEdesurYAysa.comprarCompania(aysa);
        jugadorQuePaga.mover(3);
        jugadorQuePaga.caerEn(edesur);
        Dinero dineroRestante = new Dinero(100000 - 1000 * 3);
        
        Assert.assertTrue(jugadorQuePaga.getCapital().equals(dineroRestante));
    }

    @Test
    public void test13JugadorIntercambiaPropiedadConOtroYTercerJugadorAlCaerLePagaAlNuevoPropietarioDeUnaDeLasPropiedadaes(){

        SantaFe santaFe = new SantaFe();
        Neuquen neuquen = new Neuquen();
        Dinero dinero1 = new Dinero(100000);
        Dinero dinero2 = new Dinero(100000);
        Dinero dinero3 = new Dinero(100000);
        Jugador jugador1 = new Jugador(dinero1);
        Jugador jugador2 = new Jugador(dinero2);
        Jugador jugador3 = new Jugador(dinero3);
        jugador1.comprarBarrio(santaFe);
        jugador2.comprarBarrio(neuquen);

        jugador1.intercambiarPropiedadPor(santaFe,neuquen);
        jugador3.caerEn(neuquen);

        Assert.assertEquals(100000 - 1500, jugador3.getCapital().getCantidad(),DELTA);
        Assert.assertEquals(100000 - 15000 + 1500, jugador1.getCapital().getCantidad(),DELTA);
        Assert.assertEquals(100000 - 17000, jugador2.getCapital().getCantidad(),DELTA);

    }

    @Test
    public void test13JugadorIntercambiaPropiedadConCasaConOtroYTercerJugadorAlCaerLePagaAlNuevoPropietarioDeUnaDeLasPropiedadaesAlquilerSinCasa(){

        SantaFe santaFe = new SantaFe();
        Neuquen neuquen = new Neuquen();
        Dinero dinero1 = new Dinero(100000);
        Dinero dinero2 = new Dinero(100000);
        Dinero dinero3 = new Dinero(100000);
        Jugador jugador1 = new Jugador(dinero1);
        Jugador jugador2 = new Jugador(dinero2);
        Jugador jugador3 = new Jugador(dinero3);
        jugador1.comprarBarrio(neuquen);
        jugador1.construirCasaEn(neuquen);
        jugador2.comprarBarrio(santaFe);

        jugador1.intercambiarPropiedadPor(neuquen,santaFe);
        jugador3.caerEn(neuquen);

        Assert.assertEquals(100000 - 1500, jugador3.getCapital().getCantidad(),DELTA);
        Assert.assertEquals(100000 - 17000 - 4800, jugador1.getCapital().getCantidad(),DELTA);
        Assert.assertEquals(100000 - 15000 + 1500, jugador2.getCapital().getCantidad(),DELTA);

    }
    

}
