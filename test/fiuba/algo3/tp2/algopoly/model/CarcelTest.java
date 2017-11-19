package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class CarcelTest {
	
	int CAPITALINICIAL = 100000;

	
	@Test
	public void testJugadorCaeEnCarcelEntoncesNoPuedeMoverseHastaTurno4() {
		
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador);
		Carcel carcel = new Carcel();
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		Assert.assertFalse( jugador.mover(1) );
		//primer turno
		jugador.caerEn(carcel);	
		Assert.assertFalse( jugador.mover(1) );
		//segundo turno
		jugador.caerEn(carcel);	
		Assert.assertFalse( jugador.mover(1) );
		//tercer turno
		jugador.caerEn(carcel);	
		Assert.assertFalse( jugador.mover(1) );
		//cuarto turno
		jugador.caerEn(carcel);	
		Assert.assertTrue( jugador.mover(1) );
	}
	
	@Test
	public void testJugadorCaeEnCarcelNoPuedePagarFianzaHastaTurno2() {

		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador);
		Carcel carcel = new Carcel();
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		jugador.pagarFianza();
		Assert.assertEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());
		//primer turno
		jugador.caerEn(carcel);	
		jugador.pagarFianza();
		Assert.assertEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());
		//segundo turno
		jugador.caerEn(carcel);	
		jugador.pagarFianza();
		Assert.assertNotEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());
	}
	
	@Test
	public void testJugadorEnCarcelPuedePagarFianzaEnTurno3() {
		
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador);
		Carcel carcel = new Carcel();
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		//primer turno
		jugador.caerEn(carcel);	
		//segundo turno
		jugador.caerEn(carcel);	
		//tercer turno
		jugador.caerEn(carcel);
		jugador.pagarFianza();
		
		Assert.assertNotEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());
	}
	
	@Test
	public void testJugadorEnCarcelPagaFianzaEntoncesPuedeMoverse() {
		
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador);
		Carcel carcel = new Carcel();
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		//primer turno
		jugador.caerEn(carcel);	
		//segundo turno
		jugador.caerEn(carcel);	jugador.caerEn(carcel);
		jugador.pagarFianza();
		
		Assert.assertTrue( jugador.mover(2) );
	}
	
}
