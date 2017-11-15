package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.CapitalDelJugadorInsuficiente;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Carcel extends Casillero {
	
	private Dinero costoFianza;
	
	public Carcel () {
		
		Dinero costoFianza = new Dinero(45000);
	}
	
	 public void actuarSobre(Jugador jugador) {
		 
		 jugador.irPreso (this);
		 
	 }
	 
	 public void pagarFianza (Jugador jugador) {
		 
		try {
			jugador.derementarCapitalEn(costoFianza);
		}catch ( CapitalDelJugadorInsuficiente e) { throw new ElJugadorNoTieneCapitalSuficienteParaPagarFianza(); }
		
	 }

}