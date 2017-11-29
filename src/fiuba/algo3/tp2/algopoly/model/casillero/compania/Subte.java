package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Subte extends Compania {

    private static final Dinero PRECIO = new Dinero(40000);

    private final int posicion;

    public Subte(Transportes transportes) {
        super(PRECIO);
        this.posicion = 8;
        this.algo = transportes;
        this.FACTOR_SIMPLE = 600;
        this.FACTOR_DOBLE = 1100;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
}
