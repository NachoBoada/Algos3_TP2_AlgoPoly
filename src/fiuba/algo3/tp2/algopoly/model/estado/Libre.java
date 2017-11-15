package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class Libre extends Estado {
	
	
	public void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado ( new PresoTurno0 () );
	}
	
	public boolean pagarFianza (Jugador jugador) {
		
		return false;
	}
	
	public void mover () {}

}
