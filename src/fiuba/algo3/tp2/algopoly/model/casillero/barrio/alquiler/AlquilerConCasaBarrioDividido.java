package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerConCasaBarrioDividido extends AlquilerBarrioDividido {

    public AlquilerConCasaBarrioDividido(Dinero dinero){
        this.precio=dinero;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
        jugador.decrementarCapitalEn( this.precio);
    }

    @Override
    public  void cambiarProximoAlquiler ( BarrioDividido barrio){

        barrio.setAlquiler(new AlquilerConDosCasas( barrio.getPrecioAlquilerConDosCasas()));

    }
}
