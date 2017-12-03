package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;

import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Salida;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.Estado;
import fiuba.algo3.tp2.algopoly.model.estado.Libre;

public class Jugador {

    private final Dinero capitalDelJugador;
    private final BoletaQuini6 boletaQuini6;
    private Encasillable casilleroActual;
    private String nombreJugador;
    private int posicionActual;
    private Estado estado;
    private final Tablero tablero;
    private TiroDeDados ultimoTiro;
    private int contadorTirosDuplicados;
    private ArrayList<Propiedad> propiedades;
    private boolean avanzoDinamicamente;
    private boolean retrocedioDinamicamente;
    private boolean fueDetenido;

    public Jugador(Dinero capitalInicial, Tablero tablero, String nombreJugador) {

        capitalDelJugador = capitalInicial;

        this.nombreJugador = nombreJugador;

        this.propiedades = new ArrayList<Propiedad>();

        boletaQuini6 = new BoletaQuini6();

        casilleroActual = new Salida();
        posicionActual = 0;

        estado = new Libre();

        this.tablero = tablero;

        contadorTirosDuplicados = 0;

        avanzoDinamicamente = false;
        retrocedioDinamicamente = false;
        fueDetenido = false;

    }

    public void mover(int cantidadCasilleros) {
        estado.mover(this, this.posicionActual, cantidadCasilleros, this.tablero);
    }

    public void caerEn(Encasillable casillero) {
        casillero.actuarSobre(this);
    }

    public String getEstado(){
        return estado.getNombre();
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

    public boolean esPropietarioDe(Propiedad unaPropiedad) {
        return propiedades.contains(unaPropiedad);
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

    public void agregarPropiedad(Propiedad unaPropiedad) {

        this.propiedades.add(unaPropiedad);

    }

    public void quitarPropiedad(Propiedad unaPropiedad) {

        unaPropiedad.dejarSinPropietario();

        this.propiedades.remove(unaPropiedad);

    }

    public void intercambiarPropiedadPor(Barrio miBarrio, Barrio otroBarrio) {

        Jugador otroJugador = otroBarrio.getPropietario();

        otroJugador.quitarPropiedad(otroBarrio);

        this.quitarPropiedad(miBarrio);

        otroJugador.agregarPropiedad(miBarrio);
        miBarrio.modificarPropietarioPorIntercambio(otroJugador);

        this.agregarPropiedad(otroBarrio);
        otroBarrio.modificarPropietarioPorIntercambio(this);

    }

    public void construirCasaEn(Barrio unBarrio) {
        unBarrio.comprarCasa(this);
    }

    public void construirHotelEn(Barrio barrio) {

        barrio.comprarHotel(this);

    }

    public void comprarPropiedad(Propiedad propiedad){

        propiedad.vendidaA(this);
    }

    public void venderPropiedad(Propiedad apropiable){

        Dinero dineroVenta = new Dinero(apropiable.getPrecio().getCantidad() * 0.85);

        this.incrementarCapitalEn(dineroVenta);

        this.quitarPropiedad(apropiable);

    }

    public boolean tienePropiedades(){

        return !this.propiedades.isEmpty();

    }

    public boolean saltearTurno() {
        return ( (this.ultimoTiro.esDuplicado() && contadorTirosDuplicados == 2) || ( ! this.ultimoTiro.esDuplicado() ) );
    }

    public TiroDeDados tirarDados() {
        this.ultimoTiro = Dados.getInstance().tirar();

        if ( this.contadorTirosDuplicados == 2){

            this.contadorTirosDuplicados = 0;

        }
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

        for ( Propiedad propiedad : this.propiedades ) {

            cantidad = cantidad + propiedad.obtenerCantidadDePropiedadesParaMovimientoDinamico();

        }

        return cantidad;

    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public ArrayList<Propiedad> getPropiedades(){ return propiedades; }

    public int getContadorTirosDuplicados(){

        return this.contadorTirosDuplicados;

    }

    public boolean avanzoDinamicamente() {
        return avanzoDinamicamente;
    }

    public boolean retrocedioDinamicamente() {
        return retrocedioDinamicamente;
    }

    public void setAvanceDinamico() {
        avanzoDinamicamente = true;
    }

    public void setretrocesoDinamico() {
        retrocedioDinamicamente = true;
    }

    public boolean fueDetenido() {
        return fueDetenido;
    }

    public void detener() {
        fueDetenido = true;
    }
}
