package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class CordobaNorte extends BarrioDividido {
	
	public CordobaNorte(Region region) {
		
		super(region);

        this.precio = new Dinero(20000);
    	this.precioCasa = new Dinero(2200);
    	this.precioHotel = new Dinero(3500);

    	this.estadoComprado = new Comprado(new Dinero(1300),new Dinero(1800),new Dinero(2900),new Dinero(3500));

	}

}
