package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioSimple;

public class AlquilerSinConstruccionBarrioSimple extends AlquilerBarrioSimple {

    public AlquilerSinConstruccionBarrioSimple(Dinero dinero){
        this.precio=dinero;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador){
        jugador.decrementarCapitalEn( this.precio);
    }


    @Override
    public void cambiarProximoAlquiler(BarrioSimple barrio) {

        barrio.setAlquiler(new AlquilerConCasaBarrioSimple( barrio.getPrecioAlquilerConUnaCasa()));

    }
}

