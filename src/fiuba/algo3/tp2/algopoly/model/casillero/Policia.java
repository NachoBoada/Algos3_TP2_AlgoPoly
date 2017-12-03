package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Policia implements Encasillable {

    private final int posicion;
    private final Encasillable carcel;
    private final String nombre;

    public Policia(Encasillable carcel) {

        this.posicion = 15;

        this.nombre = "Policia";

        this.carcel = carcel;
    }

    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return "Al caer en este casillero el jugador va a la cárcel";
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.detener();

        jugador.actualizarCasillero(this, this.posicion);

        jugador.caerEn(this.carcel);
    }

    public boolean esPropiedad(){

        return false;

    }
}
