package fiuba.algo3.tp2.algopoly;

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
    public void test11_1JugadorCaeEnSubteSiendoPropiedadDeOtroJugadorEntoncesSuCapitalSeReduceEn600VecesSuTiroDeDados() {
        Dinero capitalInicialCobrador = new Dinero(100000);
        Jugador jugadorCobrador = new Jugador(capitalInicialCobrador);
        
        Dinero capitalInicialPagador = new Dinero(100000);
        Jugador jugadorPagador = new Jugador(capitalInicialPagador);
        
        Transportes transportes = new Transportes();
        Subte subte = transportes.getSubte();
        jugadorCobrador.comprarCompania(subte);

        jugadorPagador.mover(5);
        jugadorPagador.caerEn(subte);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 600));
        
        System.out.println(capitalFinalJugadorPagador.getCantidad());
        System.out.println(jugadorPagador.getCapital().getCantidad());
        
        Assert.assertTrue(jugadorPagador.getCapital().equals(capitalFinalJugadorPagador));
    }
    
    /*Un jugador cae en TRENES adquirida previamente por otro jugador que además es el dueño de SUBTES. 
    Verificar que su dinero se reduzca por 800 veces lo que dice los dados arrojados previamente*/
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
    public void test12_1JugadorCaeEnSubteSiendoPropiedadDelPropietarioDelTrenEntoncesSuCapitalSeReduceEn1100VecesSuTiroDeDados() {
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
        jugadorPagador.caerEn(subte);

        Dinero capitalFinalJugadorPagador = new Dinero(100000 - (5 * 1100));
        
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
}
