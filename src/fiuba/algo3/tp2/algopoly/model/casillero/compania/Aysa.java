package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;

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
    public String getDescripcion() {
        String propietario;
        try{  propietario = estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }
        return "Nombre: Aysa \n" +
                "Propietario: "+ propietario+"\nPrecio compania: $" + getPrecio().getCantidad() + "\n" + "Monto : " + getFactorSimple() + " lo sacado en los dados\n"
                + "Monto con Edesur: " + getFactorDoble() + " lo sacado en los dados\n";
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }


}
