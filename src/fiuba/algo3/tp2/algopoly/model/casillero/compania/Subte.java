package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Subte extends Compania {
    
    private static final Dinero PRECIO = new Dinero(40000);
    private final int posicion;

    public Subte() {
        super(PRECIO);
        posicion = 8;
    }

    @Override
    public void actuarSobre(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
    
}
