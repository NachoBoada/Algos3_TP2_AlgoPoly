package fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;

public interface EstadoBarrio {


    public  void actuarSobre(Jugador jugador,Barrio unBarrio);

    public  Jugador getPropietario();

    public void agregarConstruccion(Jugador jugador);

    public void venderA(Jugador jugador,Dinero precio,Barrio barrio);


}
