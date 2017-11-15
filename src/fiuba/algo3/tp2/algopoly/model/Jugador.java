package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Casillero;
import fiuba.algo3.tp2.algopoly.model.casillero.Salida;
import fiuba.algo3.tp2.algopoly.model.estado.Estado;
import fiuba.algo3.tp2.algopoly.model.estado.Libre;
import fiuba.algo3.tp2.algopoly.model.estado.PresoTurno0;

public class Jugador {
	
	private Dinero capitalDelJugador;
	private ArrayList<Barrio> propiedades;
	private BoletaQuini6 boletaQuini6;
	private Casillero casilleroActual;
	private int posicionActual;
	private Estado estado;
	
	private int ultimaSumaDados; //Temporal hasta tener clase Dados
	
	public Jugador(Dinero capitalInicial) {
		
		capitalDelJugador = capitalInicial;
		
		propiedades = new ArrayList<Barrio>();
		
		boletaQuini6 = new BoletaQuini6();
		
		casilleroActual = new Salida();
		posicionActual = 0;
		
		estado = new Libre();
	}
	
	public boolean mover(int cantidadCasilleros) {
		ultimaSumaDados = cantidadCasilleros;
		return ( estado.mover( cantidadCasilleros ) );
	}
	
	public void caerEn(Casillero casillero) {
		casillero.actuarSobre(this);
	}
	
	public Casillero casilleroActual() {
		return casilleroActual;
	}
	
	public int posicionActual() {
		return posicionActual;
	}
	
	public void actualizarCasillero (Casillero casillero, int posicion) {
		casilleroActual = casillero;
		posicionActual = posicion;
	}
	
	public void incrementarCapitalEn(Dinero incrementoDeCapital) {
		capitalDelJugador.sumar(incrementoDeCapital);
	}
	
	public void derementarCapitalEn(Dinero decrementoDeCapital) throws CapitalDelJugadorInsuficiente {
			capitalDelJugador.restar(decrementoDeCapital);
	}
	
	public Dinero getCapital() {
		return capitalDelJugador;
	}
	
	
	public BoletaQuini6 getBoletoQuini6() {
		return boletaQuini6;
	}
	
	public void comprarBarrio(Barrio barrioAComprar) {
		
		try{
			this.derementarCapitalEn(barrioAComprar.getPrecioDelBarrio());
		}
		catch (CapitalDelJugadorInsuficiente e) {
			throw new ElJugadorNoTieneCapitalSuficienteParaComprarEsteBarrio();
		}
		
		propiedades.add(barrioAComprar);
	}

	public boolean esPropietarioDe(Barrio barrio) {
		return propiedades.contains(barrio);
	}

	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void irPreso(Carcel carcel) {
		estado.cambiarProximoEstadoPreso(this, carcel);
	}
	
	public void pagarFianza() {
		estado.pagarFianza(this);
	}
	
}
