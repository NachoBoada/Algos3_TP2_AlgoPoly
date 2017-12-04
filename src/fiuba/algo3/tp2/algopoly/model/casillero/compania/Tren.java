package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;

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
    public String getDescripcion() {
        String propietario;
        try{  propietario = estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }
        return "Nombre: Tren \n" +
                "Propietario: "+ propietario+"\nPrecio compania: $" + getPrecio().getCantidad() + "\n" + "Monto : " + getFactorSimple() + " lo sacado en los dados\n"
                + "Monto con Subte: " + getFactorDoble() + " lo sacado en los dados\n";
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

}
