package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.estado.Estado;
import fiuba.algo3.tp2.algopoly.model.estado.Libre;
import fiuba.algo3.tp2.algopoly.model.estado.PresoTurno0;

public class Jugador {
	
	private Dinero capitalDelJugador;
	private ArrayList<Barrio> propiedadesDelJugador;
	private BoletaQuini6 boletaQuini6DelJugador;
	private Casillero casilleroActualDelJugador; //se deberia inicializar en el casillero Salida???
	private Estado estado;
	
	public Jugador(Dinero capitalInicial){
		capitalDelJugador = capitalInicial;
		propiedadesDelJugador = new ArrayList<Barrio>();
		boletaQuini6DelJugador = new BoletaQuini6();
		estado = new Libre();
	}
	
	public void caerEn(Casillero casillero){
		casillero.actuarSobre(this);
	}
	
	public void incrementarCapitalEn(Dinero incrementoDeCapital){
		capitalDelJugador.sumar(incrementoDeCapital);
	}
	
	public void derementarCapitalEn(Dinero decrementoDeCapital){
		
		if (capitalDelJugador.esMenorA (decrementoDeCapital)){
			throw new CapitalDelJugadorInsuficiente();
		}
		
		capitalDelJugador.restar(decrementoDeCapital);
	}
	
	public void comprarBarrio(Barrio barrioAComprar){
		try{
			this.derementarCapitalEn(barrioAComprar.getPrecioDelBarrio());
		}
		catch (CapitalDelJugadorEsNegativo e){
			throw new ElJugadorNoTieneCapitalSuficienteParaComprarEsteBarrio();
		}
		propiedadesDelJugador.add(barrioAComprar);
	}
	
	public Dinero getCapital(){
		return capitalDelJugador;
	}
	
	public BoletaQuini6 getBoletoQuini6(){
		return boletaQuini6DelJugador;
	}
	
	public boolean esPropietarioDe(Barrio barrio){
		return propiedadesDelJugador.contains(barrio);
	}
	
	public Casillero casilleroActual(){
		return casilleroActualDelJugador;
	}
	
	public void pagarFianza(){
	}
	
	public void cambiarEstado (Estado estado){
		
		this.estado = estado;
	}
	
	public void irPreso (Carcel carcel){
		
		estado.cambiarProximoEstadoPreso(this, carcel);
	}
	
}
