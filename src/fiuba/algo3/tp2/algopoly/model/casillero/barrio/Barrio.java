package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerConCasa;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.EstadoBarrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.NoComprado;

public abstract class Barrio implements Encasillable {

	protected EstadoBarrio estadoActual;
	protected Comprado estadoComprado;
    protected Dinero precio;
    protected int posicion;


    Barrio(){

    	this.estadoActual = new NoComprado();

	}

	public void modificarPropietario(Jugador unJugador) {

    	this.estadoActual = estadoComprado;

		this.estadoComprado.modificarPropietario(unJugador);

	}

	public Dinero getPrecioDelBarrio() {
		return this.precio;
	}


	public void actuarSobre(Jugador jugador) throws ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException {
		
		jugador.actualizarCasillero(this, this.posicion);

		this.estadoActual.actuarSobre(jugador,this);

	}

	@Override
	public int getPosicion(){

    	return this.posicion;

	}
	
	public abstract void comprarCasa (Jugador jugador);

    public abstract void dejarSinPropietario();

	public Jugador getPropietario(){

		return this.estadoComprado.getPropietario();

	}
}
