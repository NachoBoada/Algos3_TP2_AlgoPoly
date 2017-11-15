package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Salida extends Casillero {
	
	private int posicion;
	
	public Salida () {
		
		this.posicion = 0;
	}
	
	 public void actuarSobre(Jugador jugador) {
		 
		 jugador.actualizarCasillero (this, this.posicion);
	 }
	
}
