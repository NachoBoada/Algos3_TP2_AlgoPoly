package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.NoComprado;

public abstract class BarrioSimple extends Barrio {

	protected int cantidadCasas = 0;
	protected Dinero costoCasa;


	public void comprarCasa(Jugador jugador ) throws CapitalInsuficienteException {

		this.estadoActual.agregarConstruccion();

		if (this.cantidadCasas == 1) throw new NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException();
		
		jugador.decrementarCapitalEn( this.costoCasa);
		
		this.cantidadCasas=1;

	}

	@Override
	public void dejarSinPropietario() {

		this.cantidadCasas = 0;

		this.estadoActual = new NoComprado();

		this.estadoComprado.resetear();

	}
	
	public int obtenerCantidadEdificaciones() {
		return cantidadCasas;
	}

	@Override
	public void comprarHotel(Jugador unJugador) {

		throw new NoSePuedeConstruirUnHotelEnUnBarrioSimpleException();

	}

    @Override
    public String getDescripcion() {
        String propietario;
        try{  propietario = estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }
        return "Propietario:" + propietario + "\nCasa: " + obtenerCantidadEdificaciones()
                + "\nPrecio terreno: $" + getPrecio().getCantidad() + "\nAlquiler: $" + estadoComprado.getPrecioAlquilerSinConstruccion().getCantidad()
                + "\nAlquiler con casa: $" + estadoComprado.getPrecioAlquilerConUnaCasa().getCantidad()
                + "\nConstruccion: $" + getCostoCasa().getCantidad();
    }

    public Dinero getCostoCasa() {
        return costoCasa;
    }
}
