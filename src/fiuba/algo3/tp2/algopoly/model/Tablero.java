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
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BuenosAires;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BuenosAiresNorte;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BuenosAiresSur;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Cordoba;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.CordobaNorte;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.CordobaSur;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Neuquen;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Salta;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SaltaNorte;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SaltaSur;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Tucuman;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Aysa;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Edesur;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Subte;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Transportes;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Tren;

public class Tablero {
	
	private LinkedList<Encasillable> casilleros;
	
	/*Creo que no hacen falta los nombres, con poner casilleros.add(new NombreDeLaClase()) alcanza, pero ya lo hice, prefiero comentarlo
	y borrarlo mas adelante a borarrlo y despues tener que hacerlo*/
	private final Salida salida;
	private final Quini6 quini6;
	private final BuenosAires buenosaires;
	private final BuenosAiresSur buenosairesSur;
	private final BuenosAiresNorte buenosairesNorte;
	private final Servicios servicios;
	private final Edesur edesur;
	private final Aysa aysa;
	private final Carcel carcel;
	private final Cordoba cordoba;
	private final CordobaSur cordobaNorte;
	private final CordobaNorte cordobaSur;
	private final AvanceDinamico avanceDinamico;
	private final Transportes transportes;
	private final Subte subte;
	private final Tren tren;
	private final ImpuestoAlLujo impuestoAlLujo;
	private final SantaFe santafe;
	private final Salta salta;
	private final SaltaSur saltaNorte;
	private final SaltaNorte saltaSur;
	private final Policia policia;
	private final Neuquen neuquen;
	private final RetrocesoDinamico retrocesoDinamico;
	private final Tucuman tucuman;

	
	public Tablero(){
		casilleros = new LinkedList<Encasillable>();
		
		casilleros.add(salida = new Salida());
		casilleros.add(quini6 = new Quini6());
		buenosaires = new BuenosAires();
		casilleros.add(buenosairesSur = buenosaires.getBarrioSur());
		casilleros.add(buenosairesNorte = buenosaires.getBarrioNorte());
		servicios = new Servicios();
		casilleros.add(edesur = servicios.getEdesur());
		casilleros.add(aysa = servicios.getAysa());
		casilleros.add(carcel = new Carcel());
		cordoba = new Cordoba();
		casilleros.add(cordobaSur = cordoba.getBarrioSur());
		casilleros.add(cordobaNorte = cordoba.getBarrioNorte());
		casilleros.add(avanceDinamico = new AvanceDinamico());
		transportes = new Transportes();
		casilleros.add(subte = transportes.getSubte());
		casilleros.add(tren = transportes.getTren());
		casilleros.add(impuestoAlLujo = new ImpuestoAlLujo());
		casilleros.add(santafe = new SantaFe());
		salta = new Salta();
		casilleros.add(saltaNorte = salta.getBarrioNorte());
		casilleros.add(saltaSur = salta.getBarrioSur());
		casilleros.add(policia = new Policia(carcel));
		casilleros.add(neuquen = new Neuquen());
		casilleros.add(retrocesoDinamico = new RetrocesoDinamico());
		casilleros.add(tucuman = new Tucuman());		
	}
	

}
