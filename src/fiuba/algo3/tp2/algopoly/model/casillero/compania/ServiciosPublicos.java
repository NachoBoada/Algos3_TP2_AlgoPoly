package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;

public class ServiciosPublicos implements Servicios {

    private final Aysa aysa;
    private final Edesur edesur;

    public ServiciosPublicos() {
        aysa = new Aysa(this);
        edesur = new Edesur(this);
    }

    public Edesur getEdesur() {
        return this.edesur;
    }

    public Aysa getAysa() {
        return this.aysa;
    }

    @Override
    public void cobrar(CompaniaComprada companiaComprada, Jugador jugador) {
        Jugador duenio = companiaComprada.getPropietario();
        if (duenio.esPropietarioDe(edesur) && duenio.esPropietarioDe(aysa)) {
            companiaComprada.cobrarDoble(jugador);
        } else {
            companiaComprada.cobrarSimple(jugador);
        }
    }

}
