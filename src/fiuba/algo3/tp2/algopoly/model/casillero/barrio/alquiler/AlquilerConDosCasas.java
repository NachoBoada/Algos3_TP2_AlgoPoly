package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;

public class AlquilerConDosCasas extends AlquilerBarrioDividido {

   AlquilerConDosCasas( BarrioDividido barrioDividido){
       this.barrioDividido = barrioDividido;
   }

   @Override
   public void cobrarAlquiler( Jugador jugador){
	   try {
   		jugador.decrementarCapitalEn( this.barrioDividido.getPrecioAlquilerConDosCasas());
   	}catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

       this.barrioDividido.getPropietario().incrementarCapitalEn(this.barrioDividido.getPrecioAlquilerConDosCasas());
   }

    @Override
    public void cambiarProximoAlquiler() {

        this.barrioDividido.setAlquiler(new AlquilerConHotel( this.barrioDividido));

    }
}
