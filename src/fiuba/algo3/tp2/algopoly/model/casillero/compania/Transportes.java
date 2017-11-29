package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;

public class Transportes implements AlgunNombreDeInterfaz {

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

    public void cobrar(CompaniaComprada companiaComprada, Jugador jugador) {
        Jugador duenio = companiaComprada.getDuenio();
        if (duenio.esDuenioDe(subte) && duenio.esDuenioDe(tren)) {
        	companiaComprada.cobrarDoble(jugador);
        } else {
        	companiaComprada.cobrarSimple(jugador);
        }
    }
}
