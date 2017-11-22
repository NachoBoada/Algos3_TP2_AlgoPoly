package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioSimple;

public class AlquilerSinConstruccionBarrioSimple extends AlquilerBarrioSimple {

    public AlquilerSinConstruccionBarrioSimple(BarrioSimple barrioSimple){
        this.barrioSimple = barrioSimple;
    }

    @Override
    public void cobrarAlquiler( Jugador jugador){
    	try {
    		jugador.decrementarCapitalEn( this.barrioSimple.getPrecioAlquiler());
    	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

    	this.barrioSimple.getPropietario().incrementarCapitalEn(this.barrioSimple.getPrecioAlquiler());


    }

    @Override
    public void cambiarProximoAlquiler() {

        this.barrioSimple.setAlquiler(new AlquilerConCasaBarrioSimple(this.barrioSimple));

    }
}

