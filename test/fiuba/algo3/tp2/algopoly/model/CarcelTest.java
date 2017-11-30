package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class CarcelTest {
	
	private static final double DELTA = 1e-15;
	
	int CAPITALINICIAL = 100000;
	
	
	@Test
	public void testJugadorCaeEnCarcelEntoncesNoPuedeMoverseHastaTurno4() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero,"Jugador 1");
		Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");
		
		//caigo en carcel
		jugador.caerEn(carcel);
		//primer turno
		jugador.caerEn(carcel);
		//segundo turno
		jugador.caerEn(carcel);
		//tercer turno
		jugador.caerEn(carcel);
		//cuarto turno
		jugador.caerEn(carcel);	
		jugador.mover(1);

		Assert.assertEquals(6,jugador.posicionActual());
	}
	
	@Test
	public void testJugadorCaeEnCarcelNoPuedePagarFianzaHastaTurno2() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero,"Jugador 1");
		Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		jugador.pagarFianza();
		Assert.assertEquals(CAPITALINICIAL, jugador.getCapital().getCantidad(), DELTA);
		//primer turno
		jugador.caerEn(carcel);	
		jugador.pagarFianza();
		Assert.assertEquals(CAPITALINICIAL, jugador.getCapital().getCantidad(), DELTA);
		//segundo turno
		jugador.caerEn(carcel);	
		jugador.pagarFianza();
		Assert.assertNotEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());
	}
	
	@Test
	public void testJugadorEnCarcelPuedePagarFianzaEnTurno3() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero,"Jugador 1");
		Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");
		
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

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero,"Jugador 1");
		Encasillable carcel = tablero.obtenerCasilleroPorNombre("Carcel");
		
		//caigo en carcel
		jugador.caerEn(carcel);	
		//primer turno
		jugador.caerEn(carcel);	
		//segundo turno
		jugador.caerEn(carcel);	jugador.caerEn(carcel);
		jugador.pagarFianza();
		
		jugador.mover(1);

		Assert.assertEquals(6,jugador.posicionActual());
	}
	
}
