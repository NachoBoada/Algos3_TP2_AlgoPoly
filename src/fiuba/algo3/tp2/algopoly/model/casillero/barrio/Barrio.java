package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.Dinero;

public abstract class Barrio implements Encasillable {
	
    protected Jugador propietario;
    protected Dinero precio;
    protected int posicion;

	public void modificarPropietario(Jugador unJugador) {
		this.propietario = unJugador;
	}

	public Dinero getPrecioDelBarrio() {
		return this.precio;
	}

	public Jugador getPropietario() {
		return propietario;
	}

	@Override
	public abstract void actuarSobre(Jugador jugador);

	@Override
	public int getPosicion(){

    	return this.posicion;

	}
	
	public abstract void comprarCasa (Jugador jugador);
}
