package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Servicios {

    private final Aysa aysa;
    private final Edesur edesur;

    public Servicios() {
        aysa = new Aysa();
        edesur = new Edesur(this);
    }

    public Edesur getEdesur() {
        return this.edesur;
    }

    public Aysa getAysa() {
        return this.aysa;
    }

    public void cobrar(Compania compania, Jugador jugador) {
        Jugador duenio = compania.getDuenio();
        if (duenio.esDuenioDe(edesur) && duenio.esDuenioDe(aysa)) {
            compania.cobrarDoble(jugador);
        } else {
            compania.cobrarSimple(jugador);
        }
    }

}
