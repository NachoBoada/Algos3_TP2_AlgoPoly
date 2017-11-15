package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public abstract class Estado {
	
	public abstract void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel);
	
	public abstract boolean pagarFianza (Jugador jugador);
	
	public abstract boolean mover (int cantidadCasilleros);
	
}
