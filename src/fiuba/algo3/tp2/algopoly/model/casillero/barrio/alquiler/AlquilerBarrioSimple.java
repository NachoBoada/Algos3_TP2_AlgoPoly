package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;


import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioSimple;

public abstract class AlquilerBarrioSimple {

        protected BarrioSimple barrioSimple;

        public abstract void cobrarAlquiler( Jugador jugador);

        public abstract void cambiarProximoAlquiler ();
    }
