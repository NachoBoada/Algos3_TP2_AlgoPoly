package fiuba.algo3.tp2.algopoly.model;

import java.util.LinkedList;

import fiuba.algo3.tp2.algopoly.model.casillero.AvanceDinamico;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.ImpuestoAlLujo;
import fiuba.algo3.tp2.algopoly.model.casillero.Policia;
import fiuba.algo3.tp2.algopoly.model.casillero.Quini6;
import fiuba.algo3.tp2.algopoly.model.casillero.RetrocesoDinamico;
import fiuba.algo3.tp2.algopoly.model.casillero.Salida;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BuenosAires;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Cordoba;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Neuquen;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Salta;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Tucuman;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Transportes;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

public class Tablero {
	
	private static final Tablero INSTANCE = new Tablero();
	private LinkedList<Encasillable> casilleros;

	private Tablero(){
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
	
	public Tablero getInstance() {
		return INSTANCE;
	}
	

}
