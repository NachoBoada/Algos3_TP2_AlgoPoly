package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerConHotel extends AlquilerBarrioDividido {

    AlquilerConHotel( BarrioDividido barrioDividido){
        this.barrioDividido = barrioDividido;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
    	try {
    		jugador.decrementarCapitalEn( this.barrioDividido.getPrecioAlquilerConHotel());
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

        this.barrioDividido.getPropietario().incrementarCapitalEn(this.barrioDividido.getPrecioAlquilerConHotel());
    }

    @Override
    public void cambiarProximoAlquiler() {

        //ACA SE PODRIA LANZAR EXCEPCION DE QUE NO SE PUEDEN CONSTRUIR MAS HOTELES

    }
}

