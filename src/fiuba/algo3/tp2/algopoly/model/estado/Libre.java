package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class Libre extends Estado {
	
	
	public void cambiarProximoEstadoPreso(Jugador jugador, Carcel carcel) {
		jugador.cambiarEstado( new PresoTurno0 () );
	}
	
	public void pagarFianza(Jugador jugador) {}
	
	public boolean mover(Jugador jugador, int posicionActual, int cantidadCasillero) {
		//jugador.sumarAPosicion(cantidadCasillero);
		Tablero.getInstance().moverJugador(jugador, posicionActual, cantidadCasillero);
		return true;
	}

}
