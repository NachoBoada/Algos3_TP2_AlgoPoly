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
	
	protected int cantidadCasas;
	
	

	@Override
	public void actuarSobre(Jugador jugador){}


	public void sumarCasa() {
		// TODO Auto-generated method stub
		
	};
	
	public int getCantidadCasas () {
		return cantidadCasas;
	}


	public void sumarHotel() {
		// TODO Auto-generated method stub
		
	}

}
