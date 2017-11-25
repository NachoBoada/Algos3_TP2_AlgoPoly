package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class Preso extends Estado {
	
	public boolean mover (Jugador jugador, int posicionActual, int cantidadCasillero) {
		return false;
	}
}
