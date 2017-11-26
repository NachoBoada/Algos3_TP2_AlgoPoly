package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public abstract class Preso extends Estado {
	
	public void mover (Jugador jugador, int posicionActual, int cantidadCasillero, Tablero tablero) {
		throw new JugadorPresoNoSePuedeMoverException();
	}

	public abstract void cambiarProximoEstadoPreso(Jugador jugador, Carcel carcel);
}
