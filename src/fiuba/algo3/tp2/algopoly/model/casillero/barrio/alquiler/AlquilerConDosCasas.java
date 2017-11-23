package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class AlquilerConDosCasas extends AlquilerBarrio {

   AlquilerConDosCasas( Comprado estadoBarrioComprado){
       super(estadoBarrioComprado);
   }

   @Override
   public void cobrarAlquiler( Jugador jugador){
	   try {
   		jugador.decrementarCapitalEn( this.estadoBarrioComprado.getPrecioAlquilerConDosCasas());
   	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

       this.estadoBarrioComprado.getPropietario().incrementarCapitalEn(this.estadoBarrioComprado.getPrecioAlquilerConDosCasas());
   }

    @Override
    public void cambiarProximoAlquiler() {

        this.estadoBarrioComprado.cambiarTipoAlquiler(new AlquilerConHotel( this.estadoBarrioComprado));

    }
}
