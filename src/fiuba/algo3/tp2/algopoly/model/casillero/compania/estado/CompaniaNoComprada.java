package fiuba.algo3.tp2.algopoly.model.casillero.compania.estado;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;

public class CompaniaNoComprada implements EstadoCompania {

    @Override
    public void actuarSobre(Jugador jugador, Compania compania) {

    }

    @Override
    public Jugador getDuenio() {
        return new Jugador(new Dinero(0));
    }
}
