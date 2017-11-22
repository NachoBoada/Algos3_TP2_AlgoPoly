package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.*;

public class AlquilerSimpleBarrioDividido extends AlquilerBarrioDividido {

    AlquilerSimpleBarrioDividido(Dinero dinero){
        this.precio=dinero;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador){
        jugador.decrementarCapitalEn( this.precio);
    }


    @Override
    public void cambiarProximoAlquiler(BarrioDividido barrio) {

        barrio.alquiler= new AlquilerConCasaBarrioDividido( barrio.getPrecioAlquilerConUnaCasa());
    }
}
