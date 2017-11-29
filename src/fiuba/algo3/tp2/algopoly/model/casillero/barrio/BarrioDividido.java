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

	@Override
	public void comprarHotel (Jugador jugador) throws CapitalInsuficienteException {
		if (cantidadHoteles == 1) throw new NoSePermiteConstruirMasDeUnHotelEnBarrioDivididoException();
		region.agregarHotel(this, jugador, precioHotel);
		this.estadoComprado.agregarConstruccion();
	}

	public Dinero getPrecioHotel() { return precioHotel; }

	public Dinero getPrecioCasa() { return precioCasa; }

	public void sumarCasa() {
		cantidadCasas += 1;
		
	};
	
	public int getCantidadCasas () {
		return cantidadCasas;
	}
    public int getCantidadHoteles(){ return cantidadHoteles;}

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
		return "Propietario: "+ estadoActual.getPropietario().getNombreJugador()+ "\nCantidad de casas construidas: "+ getCantidadCasas()
                + "\nCantidad de hoteles: "+ getCantidadHoteles()+"\nPrecio terreno: " + getPrecioDelBarrio().getCantidad()
                +"\nAlquiler: $" + estadoComprado.getPrecioAlquilerSinConstruccion().getCantidad()
                +"\nAlquiler con 1 casa: $" + estadoComprado.getPrecioAlquilerConUnaCasa().getCantidad()
                + "\nAlquiler con 2 casas: $" + estadoComprado.getPrecioAlquilerConDosCasas().getCantidad() +"\nAlquiler con Hotel: $"
                + estadoComprado.getPrecioAlquilerConHotel().getCantidad() +"\nConstruir casas: $" + getPrecioCasa().getCantidad()
                +"\nConstruir hotel: $"+ getPrecioHotel().getCantidad();
	}

}
