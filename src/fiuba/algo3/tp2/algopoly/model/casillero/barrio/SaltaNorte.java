package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class SaltaNorte extends BarrioDividido {
	
	public SaltaNorte(Region region) {

		super(region);
		
		this.posicion = 13;
		this.nombre = "Salta Norte";
        this.precio = new Dinero(23000);
    	this.precioCasa = new Dinero(4500);
    	this.precioHotel = new Dinero(7500);

    	this.estadoComprado = new Comprado(new Dinero(2000),new Dinero(3250),new Dinero(3850),new Dinero(5500));
	}
	
}
