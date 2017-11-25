package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class BuenosAiresNorte extends BarrioDividido {

	public BuenosAiresNorte(Region region) {

		super(region);
		
		this.posicion = 4;
		this.precio = new Dinero(25000);
    	this.precioCasa = new Dinero(5500);
    	this.precioHotel = new Dinero(9000);

    	this.estadoComprado = new Comprado(new Dinero(2500),new Dinero(3500),new Dinero(4000),new Dinero(6000));


	}
	
	
}
