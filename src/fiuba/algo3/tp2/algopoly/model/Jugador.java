package fiuba.algo3.tp2.algopoly.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Salida;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.Estado;
import fiuba.algo3.tp2.algopoly.model.estado.Libre;

public class Jugador {

    private final Dinero capitalDelJugador;
    private final BoletaQuini6 boletaQuini6;
    private Encasillable casilleroActual;
    private int posicionActual;
    private Estado estado;
    private final Tablero tablero;
    private TiroDeDados ultimoTiro;
    private int contadorTirosDuplicados;
    private ArrayList<Apropiable> apropiables;

    public Jugador(Dinero capitalInicial, Tablero tablero) {

        capitalDelJugador = capitalInicial;

        this.apropiables = new ArrayList<Apropiable>();

        boletaQuini6 = new BoletaQuini6();

        casilleroActual = new Salida();
        posicionActual = 0;

        estado = new Libre();

        this.tablero = tablero;

        contadorTirosDuplicados = 0;
    }

    public void mover(int cantidadCasilleros) {
        estado.mover(this, this.posicionActual, cantidadCasilleros, this.tablero);
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

    public Dinero getCapital() {
        return capitalDelJugador;
    }

    public void incrementarCapitalEn(Dinero incrementoDeCapital) {
        capitalDelJugador.sumar(incrementoDeCapital);
    }

    public void decrementarCapitalEn(Dinero decrementoDeCapital) {
        try {
            capitalDelJugador.restar(decrementoDeCapital);
        } catch (ElDineroNoPuedeSerNegativoException e) {
            throw new CapitalInsuficienteException();
        }
    }

    public BoletaQuini6 getBoletoQuini6() {
        return boletaQuini6;
    }

    public boolean esPropietarioDe(Apropiable unaPropiedad) {
        return apropiables.contains(unaPropiedad);
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

    public void agregarPropiedad(Apropiable unaPropiedad) {

        this.apropiables.add(unaPropiedad);

    }

    public void quitarPropiedad(Apropiable unaPropiedad) {

        unaPropiedad.dejarSinPropietario();

        this.apropiables.remove(unaPropiedad);

    }

    public void intercambiarPropiedadPor(Barrio miBarrio, Barrio otroBarrio) {

        Jugador otroJugador = otroBarrio.getPropietario();

        otroJugador.quitarPropiedad(otroBarrio);

        this.quitarPropiedad(miBarrio);

        otroJugador.agregarPropiedad(miBarrio);
        miBarrio.modificarPropietario(otroJugador);

        this.agregarPropiedad(otroBarrio);
        otroBarrio.modificarPropietario(this);

    }

    public void construirCasaEn(Barrio unBarrio) {
        unBarrio.comprarCasa(this);
    }

    public void construirHotelEn(Barrio barrio) {

        barrio.comprarHotel(this);

    }

    public void comprarPropiedad(Apropiable apropiable){

        this.decrementarCapitalEn(apropiable.getPrecio());

        apropiable.modificarPropietario(this);

        this.agregarPropiedad(apropiable);

    }

    public void venderPropiedad(Apropiable apropiable){


        Dinero dineroVenta = new Dinero(apropiable.getPrecio().getCantidad() * 0.85);

        this.incrementarCapitalEn(dineroVenta);

        this.quitarPropiedad(apropiable);

    }

    public boolean saltearTurno() {
        return this.ultimoTiro.esDuplicado() && contadorTirosDuplicados == 2;
    }

    public TiroDeDados tirarDados() {
        this.ultimoTiro = Dados.getInstance().tirar();
        if (this.ultimoTiro.esDuplicado()) {
            contadorTirosDuplicados++;
        }
        return this.ultimoTiro;
    }

    public TiroDeDados getUltimoTiroDeDados() {
        return this.ultimoTiro;
    }

    //Metodo para probar test
    public TiroDeDados tirarDadosParaTests(int tiroUno, int tiroDos) {
        this.ultimoTiro = Dados.getInstance().tirar(tiroUno, tiroDos);
        if (this.ultimoTiro.esDuplicado()) {
            contadorTirosDuplicados++;
        }
        return this.ultimoTiro;
    }

    public int getCantidadDePropiedadesParaMovimientoDinamico() {

        int cantidad = 0;

        for ( Apropiable propiedad : this.apropiables ) {

            cantidad = cantidad + propiedad.obtenerCantidadDePropiedadesParaMovimientoDinamico();

        }

        return cantidad;

    }

}
