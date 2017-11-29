package fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;

public interface EstadoBarrio {


    public abstract void actuarSobre(Jugador jugador,Barrio unBarrio);
    public abstract Jugador getPropietario();

}
