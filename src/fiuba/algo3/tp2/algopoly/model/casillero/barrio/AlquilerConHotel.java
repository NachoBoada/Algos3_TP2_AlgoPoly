package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AlquilerConHotel extends AlquilerBarrioDividido {

    AlquilerConHotel( Dinero dinero){
        this.precio = dinero;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
        jugador.decrementarCapitalEn(this.precio);

    }

    @Override
    public void cambiarProximoAlquiler(BarrioDividido barrio) {

    }
}

