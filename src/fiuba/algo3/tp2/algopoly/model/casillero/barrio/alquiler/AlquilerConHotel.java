package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class AlquilerConHotel extends AlquilerBarrio {

    AlquilerConHotel( Comprado estadoBarrioComprado){
        super(estadoBarrioComprado);
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
    	try {
    		jugador.decrementarCapitalEn( this.estadoBarrioComprado.getPrecioAlquilerConHotel());
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

        this.estadoBarrioComprado.getPropietario().incrementarCapitalEn(this.estadoBarrioComprado.getPrecioAlquilerConHotel());
    }

    @Override
    public void cambiarProximoAlquiler() {

        //ACA SE PODRIA LANZAR EXCEPCION DE QUE NO SE PUEDEN CONSTRUIR MAS HOTELES

    }
}

