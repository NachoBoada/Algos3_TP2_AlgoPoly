package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public interface Encasillable {

   void actuarSobre(Jugador jugador);
    
    int getPosicion();

    String getNombre();

    String getDescripcion();

}
