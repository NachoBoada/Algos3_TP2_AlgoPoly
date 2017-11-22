package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;


import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public abstract class AlquilerBarrioDividido {

    protected Dinero precio;

    public abstract void cobrarAlquiler(Jugador jugador);

    public abstract void cambiarProximoAlquiler ( BarrioDividido barrio);
}
