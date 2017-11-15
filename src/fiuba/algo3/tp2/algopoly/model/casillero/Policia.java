package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Policia extends Casillero {
	
	private int posicion;
	private Casillero carcel;
	
	public Policia (Casillero carcel) {
		
		this.posicion = 15;
		this.carcel = carcel;
	}
	
	public void actuarSobre(Jugador jugador) {
		
		jugador.actualizarCasillero(this, this.posicion);
		 
		jugador.caerEn(this.carcel);
	 }
}
