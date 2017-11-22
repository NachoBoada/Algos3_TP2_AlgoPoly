package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class SaltaNorte extends BarrioDividido {
	
	public SaltaNorte(Region region) {

		super(region);
		
        this.precio = new Dinero(23000);
    	this.precioAlquiler = new Dinero(2000);
    	this.precioAlquilerConUnaCasa = new Dinero(3250);
    	this.precioAlquilerConDosCasas = new Dinero(3850);
    	this.precioAlquilerConHotel = new Dinero(5500);
    	this.precioCasa = new Dinero(4500);
    	this.precioHotel = new Dinero(7500);
	}
	
	public void comprarCasa (Jugador jugador) {
		region.agregarCasa(this, jugador, precioCasa);
	}
	
	public void comprarHotel (Jugador jugador) {
		region.agregarHotel(this, jugador, precioHotel);
	}
}
