package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;

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
    public String getDescripcion() {
        String propietario;
        try{  propietario = this.estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }
        return "Nombre: Edesur \n" +
                "Propietario: "+ propietario+"\nPrecio compania: $" + getPrecio().getCantidad() + "\n" + "Monto : " + getFactorSimple() + " lo sacado en los dados\n"
                + "Monto con Aysa: " + getFactorDoble() + " lo sacado en los dados\n";
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
}
