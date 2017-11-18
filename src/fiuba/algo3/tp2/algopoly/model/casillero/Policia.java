package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Policia implements Encasillable {

    private final int posicion;
    private final Encasillable carcel;

    public Policia(Encasillable carcel) {

        this.posicion = 15;
        this.carcel = carcel;
    }

    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        jugador.caerEn(this.carcel);
    }
}
