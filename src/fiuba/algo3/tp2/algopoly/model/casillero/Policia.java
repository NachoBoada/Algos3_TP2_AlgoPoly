package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Casillero;

public class Policia extends Casillero {
	
	private Casillero carcel;
	
	public Policia (Casillero carcel) {
		
		this.carcel = carcel;
	}
	
	public void actuarSobre(Jugador jugador) {
		 
		 jugador.caerEn(this.carcel);
	 }
}
