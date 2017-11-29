package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;

public class Servicios implements AlgunNombreDeInterfaz {

    private final Aysa aysa;
    private final Edesur edesur;

    public Servicios() {
        aysa = new Aysa(this);
        edesur = new Edesur(this);
    }

    public Edesur getEdesur() {
        return this.edesur;
    }

    public Aysa getAysa() {
        return this.aysa;
    }

    public void cobrar(CompaniaComprada companiaComprada, Jugador jugador) {
        Jugador duenio = companiaComprada.getDuenio();
        if (duenio.esPropietarioDe(edesur) && duenio.esPropietarioDe(aysa)) {
        	companiaComprada.cobrarDoble(jugador);
        } else {
        	companiaComprada.cobrarSimple(jugador);
        }
    }


}
