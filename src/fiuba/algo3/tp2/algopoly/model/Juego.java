package fiuba.algo3.tp2.algopoly.model;

import java.util.LinkedList;
import java.util.ListIterator;

public class Juego {
	
	private LinkedList<Jugador> jugadores;
	//private ListIterator<Jugador> iterador;
	private Tablero tablero;
	private Jugador jugadorActual;
	private static Juego INSTANCE = new Juego();
	
	private Juego () {}

	public static Juego getINSTANCE() {
		return INSTANCE;
	}

	public void comenzarJuego() {

		this.tablero = new Tablero();

		this.crearJugadores();

		this.jugadorActual = this.jugadores.getFirst();

	}

	private void crearJugadores(){

		jugadores = new LinkedList<Jugador>();

		jugadores.add(new Jugador( new Dinero(100000), this.tablero ) ) ;
		jugadores.add(new Jugador( new Dinero(100000), this.tablero ) );
		jugadores.add(new Jugador( new Dinero(100000), this.tablero  ) );

		//iterador = jugadores.listIterator();

	}
	
	public void turnoProximojugador () {
		
		try {
		
			this.jugadorActual = this.jugadores.listIterator().next();
		
		}catch (IndexOutOfBoundsException e) { 
		
			//iterador = jugadores.listIterator();
		
			this.turnoProximojugador();
		}
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public void jugadorPierdeElJuego (Jugador jugador) {
		
		jugadores.remove(jugador);
		
		if ( jugadores.size() == 1) {

			//this.finalizarJuego();
		}
	}
}
