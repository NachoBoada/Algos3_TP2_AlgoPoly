package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Tren extends Compania {
    
    private static final Dinero PRECIO = new Dinero(38000);

    public Tren() {
        super(PRECIO);
    }

    @Override
    public void actuarSobre(Jugador jugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
