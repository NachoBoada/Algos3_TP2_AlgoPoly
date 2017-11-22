package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerConCasaBarrioDividido extends AlquilerBarrioDividido {

    public AlquilerConCasaBarrioDividido(BarrioDividido barrioDividido){
        this.barrioDividido = barrioDividido;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
    	try {
    		jugador.decrementarCapitalEn( this.barrioDividido.getPrecioAlquilerConUnaCasa());
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

        this.barrioDividido.getPropietario().incrementarCapitalEn(this.barrioDividido.getPrecioAlquilerConUnaCasa());

    }

    @Override
    public  void cambiarProximoAlquiler (){

        this.barrioDividido.setAlquiler(new AlquilerConDosCasas( this.barrioDividido));

    }
}
