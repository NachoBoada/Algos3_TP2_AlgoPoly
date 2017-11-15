package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class Estado {
	
	abstract void cambiarProximoEstadoPreso (Jugador jugador);
	
	abstract boolean pagarFianza (Jugador jugador);
	
}
