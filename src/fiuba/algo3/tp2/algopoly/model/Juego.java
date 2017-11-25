package fiuba.algo3.tp2.algopoly.model;

import java.util.LinkedList;
import java.util.ListIterator;

public class Juego {
	
	private LinkedList<Jugador> jugadores;
	private ListIterator<Jugador> iterador;
	
	public Juego () {
		
		jugadores = new LinkedList<Jugador>();
		
		jugadores.add(new Jugador( new Dinero(100000) ) );
		jugadores.add(new Jugador( new Dinero(100000) ) );
		jugadores.add(new Jugador( new Dinero(100000) ) );
		
		iterador = jugadores.listIterator();

	}
	
	
//	public void comenzarJuego() {}
	
	public void turnoProximojugador () {
		
		try {
		
			iterador.next().jugar();
		
		}catch (IndexOutOfBoundsException e) { 
		
			iterador = jugadores.listIterator(); 
		
			this.turnoProximojugador();
		}
	}
	
	public void jugadorPierdeElJuego (Jugador jugador) {
		
		jugadores.remove(jugador);
		
		if ( jugadores.size() == 1) {
//			jugadores.getFirst().gano();
		}
	}
}
