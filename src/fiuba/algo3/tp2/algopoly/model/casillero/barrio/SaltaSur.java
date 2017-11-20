package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class SaltaSur extends BarrioDividido {
	
	public SaltaSur() {

        this.precio = new Dinero(23000);

    	this.precioAlquiler = new Dinero(2000);
    	this.precioAlquilerConUnaCasa = new Dinero(3250);
    	this.precioAlquilerConDosCasas = new Dinero(3850);
    	this.precioAlquilerConHotel = new Dinero(5500);
    	
    	this.precioCasa = new Dinero(4500);
    	this.precioHotel = new Dinero(7500);
	}

}
