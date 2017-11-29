package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class SaltaSur extends BarrioDividido {
	
	public SaltaSur(Region region) {

		super(region);
		
		this.posicion = 14;
        this.precio = new Dinero(23000);
    	this.precioCasa = new Dinero(4500);
    	this.precioHotel = new Dinero(7500);

    	this.estadoComprado = new Comprado(new Dinero(2000),new Dinero(3250),new Dinero(3850),new Dinero(5500));
	}

	@Override
	public String getDescripcion() {
		return "Precio terreno: $23000\n" + "Alquiler: $2000\n" + "Alquiler con 1 casa: $3250\n" + "Alquiler con 2 casas: $3850\n" + "Alquiler con Hotel: $5500\n" + "Construir casas cuestan $4500 y hotel $7500\n";
	}
}
