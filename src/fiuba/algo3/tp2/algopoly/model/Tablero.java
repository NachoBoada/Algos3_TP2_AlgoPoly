package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;

public class Tablero {
	
	private final Jugador jugador1;
	private final Jugador jugador2;
	private final Jugador jugador3;
	private Dinero capitalInicial;
	private Servicios servicios;
	
	public Tablero(){
		capitalInicial = new Dinero(100000);
		
		jugador1 = new Jugador(capitalInicial);
		jugador2 = new Jugador(capitalInicial);
		jugador3 = new Jugador(capitalInicial);
		
		servicios = new Servicios();
		
	}
}
