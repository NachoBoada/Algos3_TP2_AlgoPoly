package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Salida implements Encasillable {

    private final int posicion;
    private final String nombre;

    public Salida() {

        this.posicion = 0;

        this.nombre = "Salida";
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return " casillero de partida de los jugadores";
    }

    public boolean esPropiedad(){

        return false;

    }
}
