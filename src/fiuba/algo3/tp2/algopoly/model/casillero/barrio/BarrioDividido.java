package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;
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
		this.estadoActual.agregarConstruccion(jugador);
		region.agregarCasa(this, jugador, precioCasa);

	}

	@Override
	public void comprarHotel (Jugador jugador) throws CapitalInsuficienteException {
		if (cantidadHoteles == 1) throw new NoSePermiteConstruirMasDeUnHotelEnBarrioDivididoException();
		this.estadoActual.agregarConstruccion(jugador);
		region.agregarHotel(this, jugador, precioHotel);

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

	public int obtenerCantidadEdificaciones () {
		return (cantidadCasas + cantidadHoteles);
	}

	@Override
	public void dejarSinPropietario() {

		region.demolerEdificaciones();

		this.estadoActual = new NoComprado();

		this.estadoComprado.resetear();

	}

	public void demolerEdificaciones() {
		cantidadCasas = 0;
		cantidadHoteles = 0;		
	}

	@Override
	public String getDescripcion() {
        String propietario;
        try{  propietario = estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }

		return "Propietario: " + propietario + "\nCantidad de casas construidas: " + getCantidadCasas()
				+ "\nCantidad de hoteles: " + getCantidadHoteles() + "\nPrecio terreno: " + getPrecio().getCantidad()
				+ "\nAlquiler: $" + estadoComprado.getPrecioAlquilerSinConstruccion().getCantidad()
				+ "\nAlquiler con 1 casa: $" + estadoComprado.getPrecioAlquilerConUnaCasa().getCantidad()
				+ "\nAlquiler con 2 casas: $" + estadoComprado.getPrecioAlquilerConDosCasas().getCantidad() + "\nAlquiler con Hotel: $"
				+ estadoComprado.getPrecioAlquilerConHotel().getCantidad() + "\nConstruir casas: $" + getPrecioCasa().getCantidad()
				+ "\nConstruir hotel: $" + getPrecioHotel().getCantidad();
	}

	public int getCantidadHoteles() {
		return cantidadHoteles;
	}

	public Dinero getPrecioCasa() {
		return precioCasa;
	}

	public Dinero getPrecioHotel() {
		return precioHotel;
	}

}
