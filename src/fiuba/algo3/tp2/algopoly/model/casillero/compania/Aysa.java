package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Aysa extends Compania {

    private static final Dinero PRECIO = new Dinero(30000);

    private final int posicion;

    public Aysa(ServiciosPublicos servicios) {
        super(PRECIO);
        posicion = 12;
        this.nombre = "Aysa";
        this.servicios = servicios;
        this.factorSimple = 300;
        this.factorDoble = 500;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }


}
