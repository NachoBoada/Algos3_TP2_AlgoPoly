package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class PresoTurno1 extends Preso {

	private Preso proximoEstadoPreso;
	
	void PresoTurno0 () {
		proximoEstadoPreso = new PresoTurno2 ();
	}
	
	void cambiarProximoEstadoPreso (Jugador jugador) {
		
		jugador.cambiarEstado (proximoEstadoPreso);
	}
	
	boolean pagarFianza (Jugador jugador) {
		
		return false;
	}
}
