package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class BuenosAiresNorte extends BarrioDividido {

	public BuenosAiresNorte() {

        this.precio = new Dinero(25000);

    	this.precioAlquiler = new Dinero(2500);
    	this.precioAlquilerConUnaCasa = new Dinero(3500);
    	this.precioAlquilerConDosCasas = new Dinero(4000);
    	this.precioAlquilerConHotel = new Dinero(6000);
    	
    	this.precioCasa = new Dinero(5500);
    	this.precioHotel = new Dinero(9000);
	}
}
