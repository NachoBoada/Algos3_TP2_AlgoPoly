package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algos3.tp2.algopoly.Jugador;

public class Policia {
	
	private Casillero carcel;
	
	public Policia (Casillero carcel) {
		
		this.carcel = carcel;
	}
	
	public void actuarSobre(Jugador jugador) {
		 
		 jugador.caerEn(this.carcel);
	 }
}
