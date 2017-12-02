package fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruir;
import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnBarrioYaComprado;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerBarrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerSinConstruccion;

public class Comprado implements EstadoBarrio {

    protected Jugador propietario;
    protected AlquilerBarrio alquiler;
    protected Dinero precioAlquilerSinConstruccion;
    protected Dinero precioAlquilerConUnaCasa;
    protected Dinero precioAlquilerConDosCasas;
    protected Dinero precioAlquilerConHotel;

    public Comprado(Dinero precioAlquilerSinConstruccion, Dinero precioAlquilerConUnaCasa, Dinero precioAlquilerConDosCasas, Dinero precioAlquilerConHotel){

        this.precioAlquilerSinConstruccion = precioAlquilerSinConstruccion;
        this.precioAlquilerConUnaCasa = precioAlquilerConUnaCasa;
        this.precioAlquilerConDosCasas = precioAlquilerConDosCasas;
        this.precioAlquilerConHotel = precioAlquilerConHotel;

        this.alquiler = new AlquilerSinConstruccion(this);

    }

    @Override
    public void actuarSobre(Jugador jugador, Barrio unBarrio) {

        if (!jugador.esPropietarioDe(unBarrio)){

            this.alquiler.cobrarAlquiler(jugador);

        }

    }


    public void modificarPropietario(Jugador unJugador, Dinero precioBarrio) {

        if ( (this.propietario == null) ){

            this.propietario = unJugador;

            unJugador.decrementarCapitalEn(precioBarrio);

        }else {throw new NoSePuedeComprarUnBarrioYaComprado(); }


    }


    public Dinero getPrecioAlquilerSinConstruccion() { return precioAlquilerSinConstruccion; }

    public Dinero getPrecioAlquilerConUnaCasa(){ return precioAlquilerConUnaCasa; }

    public Dinero getPrecioAlquilerConDosCasas(){

        return this.precioAlquilerConDosCasas;

    }

    public Dinero getPrecioAlquilerConHotel(){

        return this.precioAlquilerConHotel;
    }

    public void cambiarTipoAlquiler(AlquilerBarrio alquiler) {

        this.alquiler = alquiler;

    }

    public void resetear() {

        this.cambiarTipoAlquiler(new AlquilerSinConstruccion(this));

        this.propietario = null;
    }

    public void agregarConstruccion(Jugador jugador) {

        if(jugador.getNombreJugador() == this.propietario.getNombreJugador()){

            this.alquiler.cambiarProximoAlquiler();

        }else { throw new JugadorDebeComprarElBarrioParaPoderConstruir(); }


    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void modificarPropietarioPorIntercambio(Jugador unJugador) {

        this.propietario = unJugador;


    }
}
