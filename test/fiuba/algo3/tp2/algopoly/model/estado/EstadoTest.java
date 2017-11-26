package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class EstadoTest {
	
	private static final double DELTA = 1e-15;

	int CAPITALINICIAL = 100000;
	
	//LIBRE 
	
	@Test
	public void testJugadorLibrePuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		Assert.assertTrue( jugador.mover(5) );
	}
	
	//PRESO TURNO 0
	
	@Test
	public void testJugadorQueCaePresoNoPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno0 () );
				
		Assert.assertFalse( jugador.mover(5) );
	}
	
	@Test
	public void testJugadorQueCaePresoNoPuedePagarFianza() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno0 () );
		jugador.pagarFianza();
		
		Assert.assertEquals(CAPITALINICIAL, jugador.getCapital().getCantidad(), DELTA);
	}
	
	//PRESO TURNO 1
	
	@Test
	public void testJugadorPresoEnPrimerTurnoNoPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno1 () );
				
		Assert.assertFalse( jugador.mover(5) );
	}
	
	@Test
	public void testJugadorPresoEnPrimerTurnoNoPuedePagarFianza() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno1 () );
		jugador.pagarFianza();
		
		Assert.assertEquals(CAPITALINICIAL, jugador.getCapital().getCantidad(), DELTA);
	}
	
	//PRESO TURNO 2
	
	@Test
	public void testJugadorPresoEnSegundoTurnoNoPuedeMoverse() {


		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
				
		Assert.assertFalse( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnSegundoTurnoPuedePagarFianza() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertNotEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());
	}
	
	@Test
	public void testJugadorPresoEnSegundoTurnoPagaFianzaYPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertTrue( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnTurno2NoTieneFondosParaPagarFianzaEntoncesNoPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (0);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
		
		try{
			jugador.pagarFianza();
			Assert.fail();
		} catch (CapitalInsuficienteException e){
			Assert.assertTrue(true);
		}

		Assert.assertFalse( jugador.mover(5) );
	}
	
	//PRESO TURNO 3
	
	@Test
	public void testJugadorPresoEnTercerTurnoNoPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
				
		Assert.assertFalse( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnTercerTurnoPuedePagarFianza() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertNotEquals(CAPITALINICIAL, jugador.getCapital().getCantidad());

	}
	
	@Test
	public void testJugadorPresoEnTercerTurnoPagaFianzaYPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertTrue( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnTurno3NoTieneFondosParaPagarFianzaEntoncesNoPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (0);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
		
		try{
			jugador.pagarFianza();
			Assert.fail();
		} catch (CapitalInsuficienteException e){
			Assert.assertTrue(true);
		}
		
		Assert.assertFalse( jugador.mover(5) );
	}
	
	//PRESO TURNO 4
	
	@Test
	public void testJugadorPresoEnCuartoTurnoPasaASerLibreYPuedeMoverse() {

		Tablero tablero = new Tablero();
		Dinero capitalJugador = new Dinero (CAPITALINICIAL);
		Jugador jugador = new Jugador(capitalJugador,tablero);
		Carcel carcel = new Carcel();
		
		jugador.cambiarEstado( new PresoTurno3 (carcel) );
		//jugador pasa al siguiente turno
		jugador.caerEn(carcel);
		
		Assert.assertTrue( jugador.mover(5) );
	}
	
	
	
}
