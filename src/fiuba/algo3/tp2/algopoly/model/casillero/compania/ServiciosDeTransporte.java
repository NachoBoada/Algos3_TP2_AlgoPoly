package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;

public class ServiciosDeTransporte implements Servicios {

    private final Subte subte;
    private final Tren tren;

    public ServiciosDeTransporte() {
        subte = new Subte(this);
        tren = new Tren(this);
    }

    public Subte getSubte() {
        return this.subte;
    }

    public Tren getTren() {
        return this.tren;
    }

    @Override
    public void cobrar(CompaniaComprada companiaComprada, Jugador jugador) {
        Jugador duenio = companiaComprada.getDuenio();
        if (duenio.esPropietarioDe(subte) && duenio.esPropietarioDe(tren)) {
            companiaComprada.cobrarDoble(jugador);
        } else {
            companiaComprada.cobrarSimple(jugador);
        }
    }
}
