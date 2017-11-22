package fiuba.algo3.tp2.algopoly.model.casillero.barrio;


import fiuba.algo3.tp2.algopoly.model.*;

public abstract class AlquilerBarrioDividido {

    protected Dinero precio;

    public abstract void cobrarAlquiler(Jugador jugador);

    public abstract void cambiarProximoAlquiler ( BarrioDividido barrio);
}
