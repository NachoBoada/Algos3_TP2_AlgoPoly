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


	@Override
	public String getDescripcion() {
		return "Precio terreno: $25000 (veinte mil pesos)\n" + "Alquiler: $2500\n" + "Alquiler con 1 casa: $3500\n" + "Alquiler con 2 casas: $4000\n" + "Alquiler con Hotel: $6000\n" + "Construir casas cuestan $5500 y hotel $9000\n";
	}
}
