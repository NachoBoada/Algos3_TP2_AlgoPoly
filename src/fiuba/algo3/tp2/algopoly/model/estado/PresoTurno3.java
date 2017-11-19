package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficiente;
import fiuba.algo3.tp2.algopoly.model.ElJugadorNoTieneCapitalSuficienteParaPagarFianza;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class PresoTurno3 extends Preso {
	
	private Carcel carcel;
	
	public PresoTurno3 (Carcel carcel) {
		
		this.carcel = carcel;
	}
	
	public void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado ( new Libre() );
	}
	
	public void pagarFianza (Jugador jugador) {

		 try {
	            jugador.decrementarCapitalEn(carcel.getCostoFianza());
	        } catch (CapitalInsuficiente e) {throw new ElJugadorNoTieneCapitalSuficienteParaPagarFianza();}
		 
		jugador.cambiarEstado( new Libre() );
	}
	
}
