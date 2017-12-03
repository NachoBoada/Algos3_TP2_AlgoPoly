package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class PresoTurno3 extends Preso {
	
	private Carcel carcel;
	
	public PresoTurno3 (Carcel carcel) {
		
		this.carcel = carcel;
		nombre="Preso ( tercer turno)";
	}

	@Override
	public void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado ( new Libre() );
	}
	
	public void pagarFianza (Jugador jugador) {
		carcel.cobrarFianzaA(jugador);
		jugador.cambiarEstado( new Libre() );
	}

	@Override
	public String getNombre() {
		return nombre;
	}
}
