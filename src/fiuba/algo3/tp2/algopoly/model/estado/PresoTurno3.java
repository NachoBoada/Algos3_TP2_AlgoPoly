package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.ElJugadorNoTieneCapitalSuficienteParaPagarFianza;

public class PresoTurno3 extends Preso {
	
	private Carcel carcel;
	
	public PresoTurno3 (Carcel carcel) {
		
		this.carcel = carcel;
	}
	
	public void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado ( new Libre() );
	}
	
	public boolean pagarFianza (Jugador jugador) {
		try {
			carcel.pagarFianza (jugador);
		}catch ( ElJugadorNoTieneCapitalSuficienteParaPagarFianza e ) { return false; }
		
		jugador.cambiarEstado ( new Libre() );
		return true;
	}
	
	public boolean mover (int cantidadCasillero) {
		
		return false;
	}
}
