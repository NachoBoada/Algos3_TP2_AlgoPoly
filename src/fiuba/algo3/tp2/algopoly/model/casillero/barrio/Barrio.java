package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerBarrioDividido;

public abstract class Barrio implements Encasillable {
	
    protected Jugador propietario;
    protected Dinero precio;
    protected int posicion;
    protected boolean tieneDuenio;


	public void modificarPropietario(Jugador unJugador) {
		this.propietario = unJugador;

		this.tieneDuenio = true;
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

    public abstract void dejarSinPropietario();


}
