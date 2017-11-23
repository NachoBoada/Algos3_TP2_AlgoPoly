package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public abstract class AlquilerBarrio {

    protected Comprado estadoBarrioComprado;

    AlquilerBarrio(Comprado estadoBarrioComprado){

        this.estadoBarrioComprado = estadoBarrioComprado;

    }

    public abstract void cobrarAlquiler( Jugador jugador);

    public abstract void cambiarProximoAlquiler ();
}
