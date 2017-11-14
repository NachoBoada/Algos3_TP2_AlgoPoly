package fiuba.algos3.tp2.algopoly;

import java.util.ArrayList;


public class Jugador {
	
	private Capital capitalDelJugador;
	private ArrayList<Barrio> propiedadesDelJugador;
	private BoletaQuini6 boletaQuini6DelJugador;
	
	public Jugador(Capital capitalInicial){
		capitalDelJugador = new Capital(capitalInicial);
		propiedadesDelJugador = new ArrayList<Barrio>();
		boletaQuini6DelJugador = new BoletaQuini6();
	}
	
	public void caerEn(Casillero casillero){
		casillero.actuarSobre(this);
	}
	
	public void incrementarCapitalEn(Capital incrementoDeCapital){
		capitalDelJugador.sumar(incrementoDeCapital);
	}
	
	public void comprarBarrio(Barrio barrioAComprar){
		propiedadesDelJugador.add(barrioAComprar);
	}
	
	public Capital getCapital(){
		return capitalDelJugador;
	}
	
	public BoletaQuini6 getBoletoQuini6(){
		return boletaQuini6DelJugador;
	}
	
}
