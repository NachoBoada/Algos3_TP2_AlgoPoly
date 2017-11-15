package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Casillero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Carcel extends Casillero {
	
	 public void actuarSobre(Jugador jugador) {
		 
		 jugador.irPreso ();
		 
	 }

}