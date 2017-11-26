package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;
import java.util.ListIterator;

import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Salida;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;
import fiuba.algo3.tp2.algopoly.model.estado.Estado;
import fiuba.algo3.tp2.algopoly.model.estado.Libre;

public class Jugador {

    private final Dinero capitalDelJugador;
    private final ArrayList<Barrio> propiedades;
    private final ArrayList<Compania> companias;
    private final BoletaQuini6 boletaQuini6;
    private Encasillable casilleroActual;
    private int posicionActual;
    private Estado estado;
    private Tablero tablero;

    public Jugador(Dinero capitalInicial,Tablero tablero) {

        capitalDelJugador = capitalInicial;

        propiedades = new ArrayList<>();
        companias = new ArrayList<>();

        boletaQuini6 = new BoletaQuini6();

        casilleroActual = new Salida();
        posicionActual = 0;

        estado = new Libre();

        this.tablero = tablero;
    }
    

    public boolean mover(int cantidadCasilleros) {
        return (estado.mover(this, this.posicionActual, cantidadCasilleros,this.tablero));
    }

    public void caerEn(Encasillable casillero) {
        casillero.actuarSobre(this);
    }

    public Encasillable casilleroActual() {
        return casilleroActual;
    }

    public int posicionActual() {
        return posicionActual;
    }

    public void actualizarCasillero(Encasillable casillero, int posicion) {
        casilleroActual = casillero;
        posicionActual = posicion;
    }

    public void sumarAPosicion(int cantidad) {
        this.posicionActual += cantidad;
    }

    public Dinero getCapital() {
        return capitalDelJugador;
    }

    public void incrementarCapitalEn(Dinero incrementoDeCapital) {
        capitalDelJugador.sumar(incrementoDeCapital);
    }

    public void decrementarCapitalEn(Dinero decrementoDeCapital) {
        try {
            capitalDelJugador.restar(decrementoDeCapital);
        } catch (ElDineroNoPuedeSerNegativo e) {
            throw new CapitalInsuficienteException();
        }
    }

    public BoletaQuini6 getBoletoQuini6() {
        return boletaQuini6;
    }

    public void comprarBarrio(Barrio barrioAComprar) {
        this.decrementarCapitalEn(barrioAComprar.getPrecioDelBarrio());
        
        barrioAComprar.modificarPropietario(this);
        this.agregarPropiedad(barrioAComprar);
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

    public int getCantidadDePropiedades() {
    	
    	int cantidadPropiedades = this.propiedades.size();
    	
    	ListIterator<Barrio> iterador = propiedades.listIterator();
    	int cantidadEdificaciones = 0;
    	
    	for (int i = 0; i < cantidadPropiedades; i++) {
    		cantidadEdificaciones += iterador.next().obtenerCantidadEdificaciones();
    	}

    	return cantidadPropiedades + cantidadEdificaciones;
    }

    public void comprarCompania(Compania compania) {
        this.decrementarCapitalEn(compania.getPrecio());

        compania.modificarEstado(this);
        companias.add(compania);
    }

    public void agregarPropiedad(Barrio unaPropiedad){

        this.propiedades.add(unaPropiedad);

    }

    public void quitarPropiedad(Barrio unaPropiedad){


        unaPropiedad.dejarSinPropietario();

        this.propiedades.remove(unaPropiedad);


    }

    public boolean esDuenioDe(Compania compania) {
        return companias.contains(compania);
    }

    public void intercambiarPropiedadPor(Barrio miPropiedad,Barrio otraPropiedad){

        Jugador otroJugador = otraPropiedad.getPropietario();

        otroJugador.quitarPropiedad(otraPropiedad);

        this.quitarPropiedad(miPropiedad);

        otroJugador.agregarPropiedad(miPropiedad);
        miPropiedad.modificarPropietario(otroJugador);

        this.agregarPropiedad(otraPropiedad);
        otraPropiedad.modificarPropietario(this);

    }

    public void construirCasaEn(Barrio unBarrio) {
        unBarrio.comprarCasa(this);
    }
    
    public void construirHotelEn(BarrioDividido barrio) {
        barrio.comprarHotel(this);
    }

    public void venderBarrio(Barrio unBarrio) {

        Dinero dineroVenta = new Dinero(unBarrio.getPrecioDelBarrio().getCantidad() * 0.75);

        this.incrementarCapitalEn(dineroVenta);

        unBarrio.dejarSinPropietario();

        this.propiedades.remove(unBarrio);

    }
}
