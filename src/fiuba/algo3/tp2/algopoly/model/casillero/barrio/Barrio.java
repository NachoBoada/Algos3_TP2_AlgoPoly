package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnBarrioYaComprado;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.EstadoBarrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.NoComprado;

public abstract class Barrio extends Propiedad implements Encasillable {

	protected EstadoBarrio estadoActual;
	protected Comprado estadoComprado;
    protected Dinero precio;
    protected int posicion;
    protected String nombre;


    Barrio(){

    	this.estadoActual = new NoComprado();

	}

	public void modificarPropietario(Jugador unJugador) {

    	this.estadoActual = estadoComprado;

		this.estadoComprado.modificarPropietario(unJugador,this.precio);

	}

	public Dinero getPrecio() {
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

	@Override
	public String getNombre() {
		return nombre;
	}

	public abstract void comprarCasa (Jugador jugador);

	public abstract void comprarHotel(Jugador jugador);

    public abstract void dejarSinPropietario();

	public Jugador getPropietario(){

		return this.estadoComprado.getPropietario();

	}

	public abstract int obtenerCantidadEdificaciones();

	public int obtenerCantidadDePropiedadesParaMovimientoDinamico(){

		return ( 1 + this.obtenerCantidadEdificaciones() );

	}

	public boolean esPropiedad(){

		return true;

	}

	public void modificarPropietarioPorIntercambio(Jugador jugador) {

		this.estadoActual = estadoComprado;

		this.estadoComprado.modificarPropietarioPorIntercambio(jugador);

	}
}
