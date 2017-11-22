package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class CordobaNorte extends BarrioDividido {
	
	public CordobaNorte(Region region) {
		
		super(region);

        this.precio = new Dinero(20000);
        this.precioAlquiler = new Dinero(1300);
    	this.precioAlquilerConUnaCasa = new Dinero(1800);
    	this.precioAlquilerConDosCasas = new Dinero(2900);
    	this.precioAlquilerConHotel = new Dinero(3500);
    	this.precioCasa = new Dinero(2200);
    	this.precioHotel = new Dinero(3500);

	}

}
