package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class BuenosAiresSur extends BarrioDividido {
	
	public BuenosAiresSur (Region region) {

		super(region);
		
		this.posicion = 2;
		this.nombre = "Buenos Aires Sur";
        this.precio = new Dinero(20000);
    	this.precioCasa = new Dinero(5000);
    	this.precioHotel = new Dinero(8000);

    	this.estadoComprado = new Comprado(new Dinero(2000),new Dinero(3000),new Dinero(3500),new Dinero(5000));

	}

}
