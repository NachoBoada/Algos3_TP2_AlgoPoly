package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Salida implements Encasillable {

    private final int posicion;

    public Salida() {

        this.posicion = 0;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

}
