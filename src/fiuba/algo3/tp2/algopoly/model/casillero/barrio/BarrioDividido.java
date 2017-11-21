package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class BarrioDividido extends Barrio{
	
	protected Region region;
	
	protected Dinero precioAlquiler;
	protected Dinero precioAlquilerConUnaCasa;
	protected Dinero precioAlquilerConDosCasas;
	protected Dinero precioAlquilerConHotel;
	protected Dinero precioCasa;
	protected Dinero precioHotel;
	
	protected int cantidadCasas;
	protected int cantidadHoteles;
	
	public BarrioDividido (Region region) {
		this.region = region;
	}
	
	

	@Override
	public void actuarSobre(Jugador jugador){}


	public void sumarCasa() {
		cantidadCasas += 1;
		
	};
	
	public int getCantidadCasas () {
		return cantidadCasas;
	}


	public void sumarHotel() {
		cantidadHoteles += 1;	
	}
	
	public int getCantidadEdificaciones () {
		return (cantidadCasas + cantidadHoteles);
	}

}
