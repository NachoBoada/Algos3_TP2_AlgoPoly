package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Barrio;


public class Jugador {
	
	private Dinero capitalDelJugador;
	private ArrayList<Barrio> propiedadesDelJugador;
	private BoletaQuini6 boletaQuini6DelJugador;
	
	public Jugador(int capitalInicial){
		capitalDelJugador = new Dinero(capitalInicial);
		propiedadesDelJugador = new ArrayList<Barrio>();
		boletaQuini6DelJugador = new BoletaQuini6();
	}
	
	public void caerEn(Casillero casillero){
		casillero.actuarSobre(this);
	}
	
	public void incrementarCapitalEn(Dinero incrementoDeCapital){
		capitalDelJugador.sumar(incrementoDeCapital);
	}
	
	public void derementarCapitalEn(Dinero decrementoDeCapital){
		capitalDelJugador.restar(decrementoDeCapital);
		if (capitalDelJugador < 0){
			lanzar excepcion.
	}
	
	public void comprarBarrio(Barrio barrioAComprar){
		propiedadesDelJugador.add(barrioAComprar);
	}
	
	public Dinero getCapital(){
		return capitalDelJugador;
	}
	
	public BoletaQuini6 getBoletoQuini6(){
		return boletaQuini6DelJugador;
	}
	
}
