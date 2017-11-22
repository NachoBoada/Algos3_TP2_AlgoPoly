package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class CordobaSur extends BarrioDividido {
	
	public CordobaSur (Region region) {
		
		super(region);
		
        this.precio = new Dinero(18000);
    	this.precioAlquiler = new Dinero(1000);
    	this.precioAlquilerConUnaCasa = new Dinero(1500);
    	this.precioAlquilerConDosCasas = new Dinero(2500);
    	this.precioAlquilerConHotel = new Dinero(3000);
    	this.precioCasa = new Dinero(2000);
    	this.precioHotel = new Dinero(3000);

	}
	
	public void comprarCasa (Jugador jugador) {
		region.agregarCasa(this, jugador, precioCasa);
	}
	
	public void comprarHotel (Jugador jugador) {
		region.agregarHotel(this, jugador, precioHotel);
	}

}
