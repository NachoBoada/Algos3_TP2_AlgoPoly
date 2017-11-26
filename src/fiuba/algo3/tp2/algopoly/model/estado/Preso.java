package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;

public abstract class Preso extends Estado {
	
	public boolean mover (Jugador jugador, int posicionActual, int cantidadCasillero, Tablero tablero) {
		return false;
	}
}
