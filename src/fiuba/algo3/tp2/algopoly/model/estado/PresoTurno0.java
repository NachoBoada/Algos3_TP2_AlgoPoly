package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class PresoTurno0 extends Preso {
	
	private Preso proximoEstadoPreso;
	
	void PresoTurno0 () {
		proximoEstadoPreso = new PresoTurno1 ();
	}
	
	void cambiarProximoEstadoPreso (Jugador jugador) {
		
		jugador.cambiarEstado (proximoEstadoPreso);
	}
	
	boolean pagarFianza (Jugador jugador) {
		
		return false;
	}
}
