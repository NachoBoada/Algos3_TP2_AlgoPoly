package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class BuenosAiresSur extends BarrioDividido {
	
	public BuenosAiresSur (Region region) {
		super(region);
		
        this.precio = new Dinero(20000);

    	this.precioAlquiler = new Dinero(2000);
    	this.precioAlquilerConUnaCasa = new Dinero(3000);
    	this.precioAlquilerConDosCasas = new Dinero(3500);
    	this.precioAlquilerConHotel = new Dinero(5000);
    	
    	this.precioCasa = new Dinero(5000);
    	this.precioHotel = new Dinero(8000);
	}
	
	public void comprarCasa (Jugador jugador) {
		region.agregarCasa(this, jugador, precioCasa);
	}
	
	public void comprarHotel (Jugador jugador) {
		region.agregarHotel(this, jugador, precioHotel);
	}

}
