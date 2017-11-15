package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.CapitalDelJugadorInsuficiente;
import fiuba.algo3.tp2.algopoly.model.Casillero;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Carcel extends Casillero {
	
	private Dinero fianza;
	
	public Carcel (Dinero costoFianza) {
		
		fianza = costoFianza;
	}
	
	 public void actuarSobre(Jugador jugador) {
		 
		 jugador.irPreso (this);
		 
	 }
	 
	 public void pagarFianza (Jugador jugador) {
		 
		try {
			jugador.derementarCapitalEn(fianza);
		}catch ( CapitalDelJugadorInsuficiente e) { throw new ElJugadorNoTieneCapitalSuficienteParaPagarFianza(); }
		
	 }

}