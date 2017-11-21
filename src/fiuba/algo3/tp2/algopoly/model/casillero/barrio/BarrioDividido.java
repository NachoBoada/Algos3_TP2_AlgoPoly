package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class BarrioDividido extends Barrio{
	
	protected Dinero precioAlquiler;
	protected Dinero precioAlquilerConUnaCasa;
	protected Dinero precioAlquilerConDosCasas;
	protected Dinero precioAlquilerConHotel;
	protected Dinero precioCasa;
	protected Dinero precioHotel;
	

	@Override
	public void actuarSobre(Jugador jugador){};

}
