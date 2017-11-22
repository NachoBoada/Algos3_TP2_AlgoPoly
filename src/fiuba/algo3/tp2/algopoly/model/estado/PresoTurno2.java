package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class PresoTurno2 extends Preso {

	private Carcel carcel;
	
	public PresoTurno2 (Carcel carcel) {
		this.carcel = carcel;
	}
	
	public void cambiarProximoEstadoPreso(Jugador jugador, Carcel carcel) {
		jugador.cambiarEstado ( new PresoTurno3 (carcel) );
	}
	
	public void pagarFianza(Jugador jugador) {
	    jugador.decrementarCapitalEn(carcel.getCostoFianza());
		jugador.cambiarEstado( new Libre() );
	}
}
