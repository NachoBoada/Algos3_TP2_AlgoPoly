package fiuba.algo3.tp2.algopoly.model.casillero.compania.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;

public class CompaniaNoComprada implements EstadoCompania {

    @Override
    public void actuarSobre(Jugador jugador, Compania compania, Servicios algo) {}

    @Override
    public Jugador getPropietario() {
        throw new SinPropietarioException();
    }


}
