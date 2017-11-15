package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class PresoTurno1 extends Preso {

		
	public void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado ( new PresoTurno2 (carcel) );
	}
	
	public boolean pagarFianza (Jugador jugador) {
		
		return false;
	}
	
	public boolean mover (int cantidadCasillero) {
		
		return false;
	}
}
