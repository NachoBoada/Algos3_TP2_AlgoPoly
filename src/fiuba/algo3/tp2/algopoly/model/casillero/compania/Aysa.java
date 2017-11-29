package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Aysa extends Compania {

    private static final Dinero PRECIO = new Dinero(30000);

    private final int posicion;

    public Aysa(Servicios servicios) {
        super(PRECIO);
        posicion = 12;
        this.algo = servicios;
        this.FACTOR_SIMPLE = 300;
        this.FACTOR_DOBLE = 500;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }


}
