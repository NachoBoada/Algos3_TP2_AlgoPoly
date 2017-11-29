package fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;

public class NoComprado implements EstadoBarrio {

    @Override
    public void actuarSobre(Jugador jugador, Barrio unBarrio) {

    }
    public Jugador getPropietario() {
        return new Jugador(new Dinero(0), new Tablero(), "Sin propietario");
    }
}
