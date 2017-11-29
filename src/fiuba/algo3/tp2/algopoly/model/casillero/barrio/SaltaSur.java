package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class SaltaSur extends BarrioDividido {
	
	public SaltaSur(Region region) {

		super(region);
		
		this.posicion = 14;
		this.nombre = "Salta Sur";
        this.precio = new Dinero(23000);
    	this.precioCasa = new Dinero(4500);
    	this.precioHotel = new Dinero(7500);

    	this.estadoComprado = new Comprado(new Dinero(2000),new Dinero(3250),new Dinero(3850),new Dinero(5500));
	}

}
