package fiuba.algo3.tp2.algopoly.model.casillero.compania.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.AlgunNombreDeInterfaz;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;

public interface EstadoCompania {


    public abstract void actuarSobre(Jugador jugador, Compania compania, AlgunNombreDeInterfaz algo);

}
