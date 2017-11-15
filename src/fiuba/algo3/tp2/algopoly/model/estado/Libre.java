package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Libre extends Estado {
	
	private Preso proximoEstadoPreso;
	
	void Libre () {
		proximoEstadoPreso = new PresoTurno0 ();
	}
	
	void cambiarProximoEstadoPreso (Jugador jugador) {
		
		jugador.cambiarEstado (proximoEstadoPreso);
	}
	
	boolean pagarFianza (Jugador jugador) {
		
		return false;
	}

}
