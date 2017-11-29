package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class BuenosAiresSur extends BarrioDividido {
	
	public BuenosAiresSur (Region region) {

		super(region);
		
		this.posicion = 2;
        this.precio = new Dinero(20000);
    	this.precioCasa = new Dinero(5000);
    	this.precioHotel = new Dinero(8000);

    	this.estadoComprado = new Comprado(new Dinero(2000),new Dinero(3000),new Dinero(3500),new Dinero(5000));

	}

	@Override
	public String getDescripcion() {
		return "Precio terreno: $20000 (veinte mil pesos)\n" + "Alquiler: $2000\n" + "Alquiler con 1 casa: $3000\n" + "Alquiler con 2 casas: $3500\n" + "Alquiler con Hotel: $5000\n" + "Construir casas cuestan $5000 y hotel $8000\n";
	}
}
