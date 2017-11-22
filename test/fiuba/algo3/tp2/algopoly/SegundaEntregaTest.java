package fiuba.algo3.tp2.algopoly;

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
    private static int capitalInicialJugador = 100000;
    
	@Test
	public void test01JugadorCaeEnSantaFeSinPropietarioLoCompraYSuCapitalSeDecrementaEn15mil() {
		
		SantaFe barrioSantaFe = new SantaFe();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador.caerEn(barrioSantaFe);
		jugador.comprarBarrio(barrioSantaFe);
		
		Assert.assertEquals(capitalInicialJugador - 15000, jugador.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test01JugadorCaeEnNeuquenSinPropietarioLoCompraYSuCapitalSeDecrementaEn17mil() {
		
		Neuquen barrioNeuquen = new Neuquen();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador.caerEn(barrioNeuquen);
		jugador.comprarBarrio(barrioNeuquen);
		
		Assert.assertEquals(capitalInicialJugador - 17000, jugador.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test01JugadorCaeEnBsAsSurSinPropietarioLoCompraYSuCapitalSeDecrementaEn20mil() {
		
		BuenosAires regionBsAs = new BuenosAires();
		BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador.caerEn(barrioBsAsSur);
		jugador.comprarBarrio(barrioBsAsSur);
		
		Assert.assertEquals(capitalInicialJugador - 20000, jugador.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test02UnJugadorDuenioDeBsAsSurYNorteCompraUnaCasaEnElSurYSuCapitalSeDecrementaEn5mil() {
		
		BuenosAires regionBsAs = new BuenosAires();
		BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
		BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		jugador.comprarBarrio(barrioBsAsSur);
		jugador.comprarBarrio(barrioBsAsNorte);
		
		jugador.construirCasaEn(barrioBsAsSur);
		
		Assert.assertEquals(capitalInicialJugador - 20000 - 25000 - 5000, jugador.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test02UnJugadorDuenioDeCordobaSurYNorteCompraUnaCasaEnElSurYSuCapitalSeDecrementaEn2mil() {
		
		Cordoba regionCordoba = new Cordoba();
		BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
		BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		jugador.comprarBarrio(barrioCordobaSur);
		jugador.comprarBarrio(barrioCordobaNorte);
		
		jugador.construirCasaEn(barrioCordobaSur);
		
		Assert.assertEquals(capitalInicialJugador - 20000 - 18000 - 2000, jugador.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test02UnJugadorDuenioDeSaltaSurYNorteCompraUnaCasaEnElSurYSuCapitalSeDecrementaEn5mil() {
		
		Salta regionSalta = new Salta();
		BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
		BarrioDividido barrioSaltaNorte = regionSalta.getBarrioNorte();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		jugador.comprarBarrio(barrioSaltaSur);
		jugador.comprarBarrio(barrioSaltaNorte);
		
		jugador.construirCasaEn(barrioSaltaSur);
		
		Assert.assertEquals(capitalInicialJugador - 23000 - 23000 - 4500, jugador.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test03UnJugadorCaeEnBsAsSurConUnaCasaEntoncesPaga3milDeAlquiler() {
		
		BuenosAires regionBsAs = new BuenosAires();
		BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
		BarrioDividido barrioBsAsNorte = regionBsAs.getBarrioNorte();
		Jugador jugador1 = new Jugador (new Dinero (capitalInicialJugador));
		jugador1.comprarBarrio(barrioBsAsSur);
		jugador1.comprarBarrio(barrioBsAsNorte);
		jugador1.construirCasaEn(barrioBsAsNorte);
		jugador1.construirCasaEn(barrioBsAsSur);
		Jugador jugador2 = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador2.caerEn(barrioBsAsSur);
		
		Assert.assertEquals(capitalInicialJugador - 3000, jugador2.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test03UnJugadorCaeEnCordobaNorteConUnaCasaEntoncesPaga1800DeAlquiler() {
		Cordoba regionCordoba = new Cordoba();
		BarrioDividido barrioCordobaSur = regionCordoba.getBarrioSur();
		BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
		Jugador jugador1 = new Jugador (new Dinero (capitalInicialJugador));
		jugador1.comprarBarrio(barrioCordobaSur);
		jugador1.comprarBarrio(barrioCordobaNorte);
		jugador1.construirCasaEn(barrioCordobaNorte);
		jugador1.construirCasaEn(barrioCordobaSur);
		Jugador jugador2 = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador2.caerEn(barrioCordobaNorte);
		
		Assert.assertEquals(capitalInicialJugador - 1800, jugador2.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test03UnJugadorCaeEnSaltaConUnaCasaEntoncesPaga3250DeAlquiler() {
		
		Salta regionSalta = new Salta();
		BarrioDividido barrioSaltaSur = regionSalta.getBarrioSur();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		jugador.comprarBarrio(barrioSaltaSur);		
		jugador.construirCasaEn(barrioSaltaSur);
		Jugador jugador2 = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador2.caerEn(barrioSaltaSur);
		
		Assert.assertEquals(capitalInicialJugador - 3250, jugador2.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test04UnJugadorCaeEnBuenosAiresSurConDosCasasEntonesPaga3500DeAlquiler() {
		BuenosAires regionBsAs = new BuenosAires();
		BarrioDividido barrioBsAsSur = regionBsAs.getBarrioSur();
		Jugador jugador1 = new Jugador (new Dinero (capitalInicialJugador));
		jugador1.comprarBarrio(barrioBsAsSur);
		jugador1.construirCasaEn(barrioBsAsSur);
		jugador1.construirCasaEn(barrioBsAsSur);
		Jugador jugador2 = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador2.caerEn(barrioBsAsSur);
		
		Assert.assertEquals(capitalInicialJugador - 3500, jugador2.getCapital().getCantidad(), DELTA);
	}
	
	@Test
	public void test04UnJugadorCaeEnCordobaNorteConDosCasasEntonesPaga2900DeAlquiler() {
		
		Cordoba regionCordoba = new Cordoba();
		BarrioDividido barrioCordobaNorte = regionCordoba.getBarrioNorte();
		Jugador jugador1 = new Jugador (new Dinero (capitalInicialJugador));
		jugador1.comprarBarrio(barrioCordobaNorte);
		jugador1.construirCasaEn(barrioCordobaNorte);
		jugador1.construirCasaEn(barrioCordobaNorte);
		Jugador jugador2 = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador2.caerEn(barrioCordobaNorte);
		
		Assert.assertEquals(capitalInicialJugador - 2900, jugador2.getCapital().getCantidad(), DELTA);
	}
	
	
	@Test
	public void test04UnJugadorCaeEnSaltaConDosCasasEntonesPaga3850DeAlquiler() {
		
		Salta regionSalta = new Salta();
		BarrioDividido barrioSaltaNorte = regionSalta.getBarrioSur();
		Jugador jugador = new Jugador (new Dinero (capitalInicialJugador));
		jugador.comprarBarrio(barrioSaltaNorte);		
		jugador.construirCasaEn(barrioSaltaNorte);
		jugador.construirCasaEn(barrioSaltaNorte);
		Jugador jugador2 = new Jugador (new Dinero (capitalInicialJugador));
		
		jugador2.caerEn(barrioSaltaNorte);
		
		Assert.assertEquals(capitalInicialJugador - 3850, jugador2.getCapital().getCantidad(), DELTA);
	}
	
/*	@Test
	public void test05UnJugadorConBsAsNorteYSurNoTieneCupoMaximoDeCasasEntoncesComprarHotelNoDecrementaElCapital() {
		
	}*/
	

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
