package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class BuenosAiresSur extends BarrioDividido {
	
	public BuenosAiresSur() {

        this.precio = new Dinero(20000);

    	this.precioAlquiler = new Dinero(2000);
    	this.precioAlquilerConUnaCasa = new Dinero(3000);
    	this.precioAlquilerConDosCasas = new Dinero(3500);
    	this.precioAlquilerConHotel = new Dinero(5000);
    	
    	this.precioCasa = new Dinero(5000);
    	this.precioHotel = new Dinero(8000);
	}

}
