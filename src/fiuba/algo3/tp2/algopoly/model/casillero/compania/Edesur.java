package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Edesur extends Compania {

    private static final Dinero PRECIO = new Dinero(35000);

    private final int posicion;

    public Edesur(Servicios servicios) {
        super(PRECIO);
        this.posicion = 3;
        this.algo = servicios;
        this.FACTOR_SIMPLE = 500;
        this.FACTOR_DOBLE = 1000;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
}
