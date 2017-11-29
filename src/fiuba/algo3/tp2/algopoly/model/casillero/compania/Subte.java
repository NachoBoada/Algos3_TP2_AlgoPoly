package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Subte extends Compania {

    private static final Dinero PRECIO = new Dinero(40000);

    private final int posicion;

    public Subte(ServiciosDeTransporte transportes) {
        super(PRECIO);
        this.posicion = 8;
        this.nombre = "Subte";
        this.servicios = transportes;
        this.factorSimple = 600;
        this.factorDoble = 1100;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
}
