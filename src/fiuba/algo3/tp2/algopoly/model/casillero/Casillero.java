package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public  abstract class Casillero {
	
	protected int posicion;

    public abstract void actuarSobre(Jugador jugador);
    
    public int getPosicion () {
    	return this.posicion;
    }
}
