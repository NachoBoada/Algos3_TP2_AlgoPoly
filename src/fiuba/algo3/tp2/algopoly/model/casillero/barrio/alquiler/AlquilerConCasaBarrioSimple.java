package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;


import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioSimple;

public class AlquilerConCasaBarrioSimple extends AlquilerBarrioSimple {

    public AlquilerConCasaBarrioSimple(BarrioSimple barrioSimple){
        this.barrioSimple = barrioSimple;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador ){
    	try {
    		jugador.decrementarCapitalEn( this.barrioSimple.getPrecioAlquilerConUnaCasa());
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

        this.barrioSimple.getPropietario().incrementarCapitalEn(this.barrioSimple.getPrecioAlquilerConUnaCasa());
    }

    @Override
    public void cambiarProximoAlquiler() {

        //ACA SE PODRIA LANZAR LA EXCEPCION DE QUE NO SE PUEDE CONSTRUIR MAS DE UNA CASA

    }
}

