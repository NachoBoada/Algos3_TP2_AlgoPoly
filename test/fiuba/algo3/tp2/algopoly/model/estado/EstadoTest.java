package fiuba.algo3.tp2.algopoly.model.estado;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class EstadoTest {

	//LIBRE 
	
	@Test
	public void testJugadorLibrePuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		Assert.assertTrue( jugador.mover(5) );
	}
	
	//PRESO TURNO 0
	
	@Test
	public void testJugadorQueCaePresoNoPuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno0 () );
				
		Assert.assertFalse( jugador.mover(5) );
	}
	
	@Test
	public void testJugadorQueCaePresoNoPuedePagarFianza() {
		
		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno0 () );
				
		Assert.assertFalse( jugador.pagarFianza() );
	}
	
	//PRESO TURNO 1
	
	@Test
	public void testJugadorPresoEnPrimerTurnoNoPuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno1 () );
				
		Assert.assertFalse( jugador.mover(5) );
	}
	
	@Test
	public void testJugadorPresoEnPrimerTurnoNoPuedePagarFianza() {
		
		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno1 () );
				
		Assert.assertFalse( jugador.pagarFianza() );
	}
	
	//PRESO TURNO 2
	
	@Test
	public void testJugadorPresoEnSegundoTurnoNoPuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
				
		Assert.assertFalse( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnSegundoTurnoPuedePagarFianza() {
		
		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
				
		Assert.assertTrue( jugador.pagarFianza() );
	}
	
	@Test
	public void testJugadorPresoEnSegundoTurnoPagaFianzaYPuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertTrue( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnTurno2NoTieneFondosParaPagarFianzaEntoncesNoPuedeMoverse() {
		
		Dinero capitalJugador = new Dinero (0);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno2 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertFalse( jugador.mover(5) );
	}
	
	//PRESO TURNO 3
	
	@Test
	public void testJugadorPresoEnTercerTurnoNoPuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
				
		Assert.assertFalse( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnTercerTurnoPuedePagarFianza() {
		
		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
				
		Assert.assertTrue( jugador.pagarFianza() );
	}
	
	@Test
	public void testJugadorPresoEnTercerTurnoPagaFianzaYPuedeMoverse() {

		Dinero capitalJugador = new Dinero (100000);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertTrue( jugador.mover(5) );
	}

	@Test
	public void testJugadorPresoEnTurno3NoTieneFondosParaPagarFianzaEntoncesNoPuedeMoverse() {
		
		Dinero capitalJugador = new Dinero (0);
		Jugador jugador = new Jugador(capitalJugador);
		
		jugador.cambiarEstado( new PresoTurno3 ( new Carcel() ) );
		jugador.pagarFianza();
		
		Assert.assertFalse( jugador.mover(5) );
	}
	
	//PRESO TURNO 4
	
	@Test
	public void testJugadorPresoEnCuartoTurnoPasaASerLibreYPuedeMoverse() {
		
		Dinero capitalJugador = new Dinero (0);
		Jugador jugador = new Jugador(capitalJugador);
		Carcel carcel = new Carcel();
		
		jugador.cambiarEstado( new PresoTurno3 (carcel) );
		//jugador pasa al siguiente turno
		jugador.caerEn(carcel);
		
		Assert.assertTrue( jugador.mover(5) );
	}
	
	
	
}
