package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.casillero.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.*;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Transportes;

import java.util.LinkedList;

public class Tablero {
	
	private static final Tablero INSTANCE = new Tablero();
	private static final int TotalCasilleros = 20;
	private LinkedList<Encasillable> casilleros;

	public Tablero(){
		BuenosAires buenosaires = new BuenosAires();
		Servicios servicios = new Servicios();
		Cordoba cordoba = new Cordoba();
		Transportes transportes = new Transportes();
		Salta salta = new Salta();
		Carcel carcel = new Carcel();
		
		casilleros = new LinkedList<Encasillable>();
		
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(buenosaires.getBarrioSur());
		casilleros.add(servicios.getEdesur());
		casilleros.add(buenosaires.getBarrioNorte());
		casilleros.add(carcel);
		casilleros.add(cordoba.getBarrioSur());
		casilleros.add(new AvanceDinamico());
		casilleros.add(transportes.getSubte());
		casilleros.add(cordoba.getBarrioNorte());
		casilleros.add(new ImpuestoAlLujo());
		casilleros.add(new SantaFe());
		casilleros.add(servicios.getAysa());
		casilleros.add(salta.getBarrioNorte());
		casilleros.add(salta.getBarrioSur());
		casilleros.add(new Policia(carcel));
		casilleros.add(transportes.getTren());
		casilleros.add(new Neuquen());
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(new Tucuman());		
	}
	
	/*public static Tablero getInstance() {
		return INSTANCE;
	}*/
	
	public void moverJugador (Jugador jugador, int posicionActual, int cantidadCasilleros) {

		int posicion = (posicionActual + cantidadCasilleros) % TotalCasilleros ;

		jugador.caerEn( casilleros.get( posicion ) );
	}

	public Encasillable getEncasillable ( int posicion ){
		return casilleros.get(posicion);
	}

}
