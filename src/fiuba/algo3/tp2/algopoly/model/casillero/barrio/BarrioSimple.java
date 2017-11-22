package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.*;

public abstract class BarrioSimple extends Barrio {

	protected int casa;
	protected Dinero alquiler;
	protected Dinero alquilerConCasa;
	protected Dinero costoCasa;

	public void actuarSobre(Jugador jugador){}

	public void comprarCasa(Jugador jugador ){
		this.casa=1;
		jugador.decrementarCapitalEn( this.costoCasa);
	}

}
