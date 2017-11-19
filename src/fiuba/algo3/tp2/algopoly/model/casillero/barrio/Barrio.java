package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Barrio implements Encasillable {
	
    private Jugador propietario;
    private final Dinero precio;
    
    public Barrio (Dinero precio) {
    	this.precio = precio;
    }    

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
	public void actuarSobre(Jugador jugador) {}
}
