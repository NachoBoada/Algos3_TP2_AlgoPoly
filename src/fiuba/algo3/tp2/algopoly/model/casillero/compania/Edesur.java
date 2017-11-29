package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Edesur extends Compania {

    private static final Dinero PRECIO = new Dinero(35000);

    private final int posicion;

    public Edesur(ServiciosPublicos servicios) {
        super(PRECIO);
        this.posicion = 3;
        this.nombre = "Edesur";
        this.servicios = servicios;
        this.factorSimple = 500;
        this.factorDoble = 1000;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
}
