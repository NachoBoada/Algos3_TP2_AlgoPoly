package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerSinConstruccionBarrioDividido extends AlquilerBarrioDividido {

    public AlquilerSinConstruccionBarrioDividido(BarrioDividido barrioDividido){

        this.barrioDividido = barrioDividido;

    }

    @Override
    public void cobrarAlquiler( Jugador jugador){
    	try {
    		jugador.decrementarCapitalEn( this.barrioDividido.getPrecioAlquiler());
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

        this.barrioDividido.getPropietario().incrementarCapitalEn(this.barrioDividido.getPrecioAlquiler());


    }


    @Override
    public void cambiarProximoAlquiler() {

        this.barrioDividido.setAlquiler(new AlquilerConCasaBarrioDividido( this.barrioDividido));

    }
}
