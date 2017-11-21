package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class BarrioSimple extends Barrio {

	protected int casa;

	public void actuarSobre(Jugador jugador){}

	public void sumarCasa(){ this.casa=1; }

}
