package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.*;

public abstract class BarrioSimple extends Barrio {

	protected int casa;
	protected Dinero alquiler;
	protected Dinero alquilerConCasa;
	protected Dinero costoCasa;

	public void actuarSobre(Jugador jugador){}

	public void comprarCasa(Jugador jugador ) {
		try {
			jugador.decrementarCapitalEn( this.costoCasa);
		}catch (CapitalInsuficienteException e) {throw new CapitalInsuficienteException();}
		
		this.casa=1;
	}

}
