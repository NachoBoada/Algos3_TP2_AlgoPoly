package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerConDosCasas extends AlquilerBarrioDividido {

   AlquilerConDosCasas( Dinero dinero){
       this.precio = dinero;
   }

   @Override
   public void cobrarAlquiler( Jugador jugador){
	   try {
   		jugador.decrementarCapitalEn( this.precio);
   	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenerPropiedadesPorCapitalInsuficienteException();}
   }

    @Override
    public void cambiarProximoAlquiler(BarrioDividido barrio) {

        barrio.setAlquiler(new AlquilerConHotel( barrio.getPrecioAlquilerConHotel()));

    }
}
