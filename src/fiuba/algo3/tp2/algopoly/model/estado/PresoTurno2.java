package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class PresoTurno2 extends Preso {
	
	private Preso proximoEstadoPreso;
	
	void PresoTurno0 () {
		proximoEstadoPreso = new PresoTurno3 ();
	}
	
	void cambiarProximoEstadoPreso (Jugador jugador) {
		
		jugador.cambiarEstado (proximoEstadoPreso);
	}
	
	boolean pagarFianza (Jugador jugaror) {
		try {
			jugador.decrementarCapitalEn (carcel.getFianza);
		}catch (capitalInsuficienteError) { return false; }
		
		jugador.cambiarEstado ( new Libre() );
		return true;
	}
}
