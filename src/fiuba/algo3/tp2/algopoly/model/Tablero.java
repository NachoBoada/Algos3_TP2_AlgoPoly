package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;
import java.util.LinkedList;

import fiuba.algo3.tp2.algopoly.model.casillero.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.*;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.ServiciosPublicos;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.ServiciosDeTransporte;

public class Tablero {
	
	private static final int TotalCasilleros = 20;
	private LinkedList<Encasillable> casilleros;
	private ArrayList<Barrio> barrios;
	private ArrayList<Compania> companias;

	public Tablero(){
		BuenosAires buenosAires = new BuenosAires();
		ServiciosPublicos servicios = new ServiciosPublicos();
		Cordoba cordoba = new Cordoba();
		ServiciosDeTransporte transportes = new ServiciosDeTransporte();
		Salta salta = new Salta();
		Carcel carcel = new Carcel();
		
		casilleros = new LinkedList<Encasillable>();
		barrios = new ArrayList<Barrio>();
		companias = new ArrayList<Compania>();
		
		casilleros.add(new Salida());

		casilleros.add(new Quini6());

		Barrio buenosAiresSur = buenosAires.getBarrioSur();
		casilleros.add(buenosAiresSur);
		barrios.add(buenosAiresSur);

		Compania edesur = servicios.getEdesur();
		casilleros.add(edesur);
		companias.add(edesur);

		Barrio buenosAiresNorte = buenosAires.getBarrioNorte();
		casilleros.add(buenosAiresNorte);
		barrios.add(buenosAiresNorte);

		casilleros.add(carcel);

		Barrio cordobaSur = cordoba.getBarrioSur();
		casilleros.add(cordobaSur);
		barrios.add(cordobaSur);

		casilleros.add(new AvanceDinamico());

		Compania subte = transportes.getSubte();
		casilleros.add(subte);
		companias.add(subte);

		Barrio cordobaNorte = cordoba.getBarrioNorte();
		casilleros.add(cordobaNorte);
		barrios.add(cordobaNorte);

		casilleros.add(new ImpuestoAlLujo());

		Barrio santaFe = new SantaFe();
		casilleros.add(santaFe);
		barrios.add(santaFe);

		Compania aysa = servicios.getAysa();
		casilleros.add(aysa);
		companias.add(aysa);

		Barrio saltaNorte = salta.getBarrioNorte();
		casilleros.add(saltaNorte);
		barrios.add(saltaNorte);

		Barrio saltaSur = salta.getBarrioSur();
		casilleros.add(saltaSur);
		barrios.add(saltaSur);

		casilleros.add(new Policia(carcel));

		Compania tren = transportes.getTren();
		casilleros.add(tren);
		companias.add(tren);

		Barrio neuquen = new Neuquen();
		casilleros.add(neuquen);
		barrios.add(neuquen);

		casilleros.add(new RetrocesoDinamico());

		Barrio tucuman = new Tucuman();
		casilleros.add(tucuman);
		barrios.add(tucuman);
	}
	
	public void moverJugador (Jugador jugador, int posicionActual, int cantidadCasilleros) {

		int posicion = (posicionActual + cantidadCasilleros) % TotalCasilleros ;

		jugador.caerEn( casilleros.get( posicion ) );
	}

	public Encasillable obtenerCasilleroPorNombre(String nombre){

		Encasillable casilleroPedido = null;
		
		for ( Encasillable casillero: this.casilleros ) {

			if (casillero.getNombre().equals(nombre)) {

				casilleroPedido = casillero;

			}

		}
		
		return casilleroPedido;

	}

	public Barrio obtenerBarrioPorNombre(String nombre){

		Barrio barrioPedido = null;

		for ( Barrio barrio : this.barrios ) {

			if (barrio.getNombre().equals(nombre)) {

				barrioPedido = barrio;

			}

		}

		return barrioPedido;


	}

	public Compania obtenerCompaniaPorNombre(String nombre){

		Compania companiaPedida = null;

		for ( Compania compania : this.companias ) {

			if (compania.getNombre() == nombre ) {

				companiaPedida = compania;

			}

		}

		return companiaPedida;


	}
	

}
