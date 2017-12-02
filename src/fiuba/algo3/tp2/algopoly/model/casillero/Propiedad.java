package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class Propiedad {

    public abstract void modificarPropietario(Jugador jugador);

    public abstract void dejarSinPropietario();

    public abstract Dinero getPrecio();

    public abstract int obtenerCantidadDePropiedadesParaMovimientoDinamico();

    public abstract String getNombre();

    public void vendidaA(Jugador jugador){

        jugador.decrementarCapitalEn(this.getPrecio());

        this.modificarPropietario(jugador);

        jugador.agregarPropiedad(this);


    }
}
