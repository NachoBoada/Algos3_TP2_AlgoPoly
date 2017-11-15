package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class CarcelTest {

	
	@Test
	public void testJugadorCaeEnCarcelEntoncesNoPuedeMoverseHastaTurno4() {
		
		Dinero capitalJugador = new Dinero (100000);
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
		
		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		Carcel carcel = new Carcel();
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		Assert.assertFalse( jugador.pagarFianza() );
		//primer turno
		jugador.caerEn(carcel);	
		Assert.assertFalse( jugador.pagarFianza() );
		//segundo turno
		jugador.caerEn(carcel);	
		Assert.assertTrue( jugador.pagarFianza() );
	}
	
	@Test
	public void testJugadorEnCarcelPuedePagarFianzaEnTurno3() {
		
		Dinero capitalJugador = new Dinero (100000);
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
			
		Assert.assertTrue( jugador.pagarFianza() );
	}
	
	@Test
	public void testJugadorEnCarcelPagaFianzaEntoncesPuedeMoverse() {
		
		Dinero capitalJugador = new Dinero (100000);
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
