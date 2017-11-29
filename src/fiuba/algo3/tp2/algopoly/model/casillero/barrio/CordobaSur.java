package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class CordobaSur extends BarrioDividido {
	
	public CordobaSur (Region region) {
		
		super(region);
		
		this.posicion = 6;
        this.precio = new Dinero(18000);
    	this.precioCasa = new Dinero(2000);
    	this.precioHotel = new Dinero(3000);

		this.estadoComprado = new Comprado(new Dinero(1000),new Dinero(1500),new Dinero(2500),new Dinero(3000));

	}

	@Override
	public String getDescripcion() {
		return "Precio terreno: $18000\n" + "Alquiler: $1000\n" + "Alquiler con 1 casa: $1500\n" + "Alquiler con 2 casas: $2500\n" + "Alquiler con Hotel: $3000\n" + "Construir casas cuestan $2000 y hotel $3000\n";
	}
}
