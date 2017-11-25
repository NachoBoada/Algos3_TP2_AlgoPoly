package fiuba.algo3.tp2.algopoly.model.casillero.compania.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;

public class CompaniaComprada implements EstadoCompania {

    private final Jugador duenio;

    public CompaniaComprada(Jugador jugador) {
        this.duenio = jugador;
    }

    @Override
    public void actuarSobre(Jugador jugador, Compania compania) {
        if (!jugador.esDuenioDe(compania)) {
            compania.doSomething(jugador);
        }
    }

    @Override
    public Jugador getDuenio() {
        return this.duenio;
    }
}
