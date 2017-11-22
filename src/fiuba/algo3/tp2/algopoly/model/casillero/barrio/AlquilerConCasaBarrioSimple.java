package fiuba.algo3.tp2.algopoly.model.casillero.barrio;


import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AlquilerConCasaBarrioSimple extends AlquilerBarrioSimple {

    AlquilerConCasaBarrioSimple(Dinero dinero){
        this.precio=dinero;
    }
    @Override
    public void cobrarAlquiler( Jugador jugador ){
        jugador.decrementarCapitalEn( this.precio);
    }

    @Override
    public void cambiarProximoAlquiler(BarrioSimple barrio) {
        barrio.alquiler= new AlquilerConCasaBarrioSimple( barrio.getPrecioAlquilerConUnaCasa());

    }
}

