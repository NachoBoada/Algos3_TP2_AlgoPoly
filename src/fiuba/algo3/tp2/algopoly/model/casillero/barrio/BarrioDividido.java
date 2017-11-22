package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenerPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerBarrioDividido;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerSinConstruccionBarrioDividido;

public abstract class BarrioDividido extends Barrio {
	
	protected Region region;
	
	protected Dinero precioAlquiler;
	protected Dinero precioAlquilerConUnaCasa;
	protected Dinero precioAlquilerConDosCasas;
	protected Dinero precioAlquilerConHotel;
	protected Dinero precioCasa;
	protected Dinero precioHotel;
	protected AlquilerBarrioDividido alquiler;
	
	protected int cantidadCasas = 0;
	protected int cantidadHoteles = 0;
	
	public BarrioDividido (Region region) {
		this.region = region;
		this.alquiler= new AlquilerSinConstruccionBarrioDividido( this.precioAlquiler );
	}
	
	

	@Override
	public void actuarSobre(Jugador jugador) throws ElJugadorDebeVenerPropiedadesPorCapitalInsuficienteException {

		if (!jugador.esPropietarioDe(this) && this.tieneDuenio) {
				this.alquiler.cobrarAlquiler(jugador);
		}
	}
	
	public void comprarCasa (Jugador jugador) throws CapitalInsuficienteException {
		if (cantidadCasas == 2) throw new NoSePermiteConstruirMasDeDosCasasEnBarrioDivididoException();
		region.agregarCasa(this, jugador, precioCasa);
		this.alquiler.cambiarProximoAlquiler(this);
	}
	
	public void comprarHotel (Jugador jugador) throws CapitalInsuficienteException {
		if (cantidadHoteles == 1) throw new NoSePermiteConstruirMasDeUnHotelEnBarrioDivididoException();
		region.agregarHotel(this, jugador, precioHotel);
		this.alquiler.cambiarProximoAlquiler(this);
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

	public Dinero getPrecioAlquiler() { return precioAlquiler; }

	public Dinero getPrecioAlquilerConUnaCasa(){ return precioAlquilerConUnaCasa; }

	public Dinero getPrecioAlquilerConDosCasas(){ return precioAlquilerConDosCasas; }

	public Dinero getPrecioAlquilerConHotel(){ return precioAlquilerConHotel; }

	public int getCantidadEdificaciones () {
		return (cantidadCasas + cantidadHoteles);
	}

	public void setAlquiler(AlquilerBarrioDividido alquiler) {

		this.alquiler = alquiler;

	}
}
