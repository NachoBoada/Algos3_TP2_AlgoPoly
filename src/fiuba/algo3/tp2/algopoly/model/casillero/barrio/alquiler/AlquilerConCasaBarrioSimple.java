package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;


import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenerPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioSimple;

public class AlquilerConCasaBarrioSimple extends AlquilerBarrioSimple {

    public AlquilerConCasaBarrioSimple(Dinero dinero){
        this.precio=dinero;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
    	try {
    		jugador.decrementarCapitalEn( this.precio);
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenerPropiedadesPorCapitalInsuficienteException();}
    }

    @Override
    public void cambiarProximoAlquiler(BarrioSimple barrio) {

        //ACA SE PODRIA LANZAR LA EXCEPCION DE QUE NO SE PUEDE CONSTRUIR MAS DE UNA CASA

    }
}

