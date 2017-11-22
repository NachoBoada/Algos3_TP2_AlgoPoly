package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerConHotel extends AlquilerBarrioDividido {

    AlquilerConHotel( Dinero dinero){
        this.precio = dinero;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
    	try {
    		jugador.decrementarCapitalEn( this.precio);
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

    }

    @Override
    public void cambiarProximoAlquiler(BarrioDividido barrio) {

        //ACA SE PODRIA LANZAR EXCEPCION DE QUE NO SE PUEDEN CONSTRUIR MAS HOTELES

    }
}

