package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;

public abstract class Compania implements Encasillable {

    protected Jugador duenio;
    protected final Dinero precio;

    public Compania(Dinero precio) {
        this.precio = precio;
    }

    public Dinero getPrecio() {
        return precio;
    }

    public Jugador getDuenio() {
        return duenio;
    }

    public void modificarDuenio(Jugador jugador) {
        this.duenio = jugador;
    }

    @Override
    public abstract void actuarSobre(Jugador jugador);

    @Override
    public abstract int getPosicion();
    
    public abstract void cobrarDoble(Jugador jugador);

    public abstract void cobrarSimple(Jugador jugador);
    
}
