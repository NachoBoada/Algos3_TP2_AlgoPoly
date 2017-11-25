package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.NoComprado;

public abstract class BarrioDividido extends Barrio {
	
	protected Region region;

	protected Dinero precioCasa;
	protected Dinero precioHotel;
	
	protected int cantidadCasas = 0;
	protected int cantidadHoteles = 0;
	
	public BarrioDividido (Region region) {
		this.region = region;
	}

	public void comprarCasa (Jugador jugador) throws CapitalInsuficienteException {
		if (cantidadCasas == 2) throw new NoSePermiteConstruirMasDeDosCasasEnBarrioDivididoException();
		region.agregarCasa(this, jugador, precioCasa);
		this.estadoComprado.agregarConstruccion();
	}
	
	public void comprarHotel (Jugador jugador) throws CapitalInsuficienteException {
		if (cantidadHoteles == 1) throw new NoSePermiteConstruirMasDeUnHotelEnBarrioDivididoException();
		region.agregarHotel(this, jugador, precioHotel);
		this.estadoComprado.agregarConstruccion();
	}


	public void sumarCasa() {
		cantidadCasas += 1;
		
	};
	
	public int getCantidadCasas () {
		return cantidadCasas;
	}


	public void sumarHotel() {
		cantidadCasas = 0;
		cantidadHoteles = 1;	
	}

	public int getCantidadEdificaciones () {
		return (cantidadCasas + cantidadHoteles);
	}

	@Override
	public void dejarSinPropietario() {

		this.cantidadCasas = 0;

		this.cantidadHoteles = 0;

		this.estadoActual = new NoComprado();

		this.estadoComprado.resetear();

	}
	
	public int obtenerCantidadEdiicaciones() {
		return cantidadCasas + cantidadHoteles;
	}

}
