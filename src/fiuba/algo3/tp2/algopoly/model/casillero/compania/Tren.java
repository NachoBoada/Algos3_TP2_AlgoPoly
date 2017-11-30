package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Tren extends Compania {

    private static final Dinero PRECIO = new Dinero(38000);
    private final int posicion;

    public Tren(ServiciosDeTransporte transportes) {
        super(PRECIO);
        this.posicion = 16;
        this.nombre = "Tren";
        this.servicios = transportes;
        this.factorSimple = 450;
        this.factorDoble = 800;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

}
