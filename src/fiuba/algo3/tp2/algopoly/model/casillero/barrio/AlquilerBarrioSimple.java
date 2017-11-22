package fiuba.algo3.tp2.algopoly.model.casillero.barrio;


import fiuba.algo3.tp2.algopoly.model.*;

public abstract class AlquilerBarrioSimple {

        protected Dinero precio;

        public abstract void cobrarAlquiler( Jugador jugador);

        public abstract void cambiarProximoAlquiler ( BarrioSimple barrio);
    }
