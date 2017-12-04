package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;

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
    public String getDescripcion() {
        String propietario;
        try{  propietario = estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }
        return "Nombre: Subte \n" +
                "Propietario: "+ propietario+"\nPrecio compania: $" + getPrecio().getCantidad() + "\n" + "Monto : " + getFactorSimple() + " lo sacado en los dados\n"
                + "Monto con Tren: " + getFactorDoble() + " lo sacado en los dados\n";
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
}
