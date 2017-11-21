package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Transportes {

    private final Subte subte;
    private final Tren tren;

    public Transportes() {
        subte = new Subte(this);
        tren = new Tren(this);
    }

    public Subte getSubte() {
        return this.subte;
    }

    public Tren getTren() {
        return this.tren;
    }

    public void cobrarBoleto(Compania compania, Jugador jugador) {
        Jugador duenio = compania.getDuenio();
        if (duenio.esDuenioDe(tren) && duenio.esDuenioDe(subte)) {
            compania.cobrarDoble(jugador);
        } else {
            compania.cobrarSimple(jugador);
        }
    }
}
