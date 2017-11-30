package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaNoComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.EstadoCompania;

public abstract class Compania implements Encasillable, Apropiable {

    protected final Dinero precio;
    private EstadoCompania estadoActual;
    protected Servicios servicios;
    protected int factorSimple;
    protected int factorDoble;
    protected String nombre;

    public Compania(Dinero precio) {
        this.precio = precio;
        this.estadoActual = new CompaniaNoComprada();
    }

    @Override
    public Dinero getPrecio() {
        return precio;
    }

    @Override
    public void modificarPropietario(Jugador jugador) {
        this.estadoActual = new CompaniaComprada(jugador, factorSimple, factorDoble);
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.getPosicion());
        this.estadoActual.actuarSobre(jugador, this, servicios);
    }

    @Override
    public void dejarSinPropietario() {

        this.estadoActual = new CompaniaNoComprada();

    }

    @Override
    public int obtenerCantidadDePropiedadesParaMovimientoDinamico() {

        return 0;

    }

    @Override
    public String getNombre() {

        return this.nombre;

    }

    @Override
    public String getDescripcion() {
        String propietario;
        try{  propietario = estadoActual.getPropietario().getNombreJugador(); }
        catch ( SinPropietarioException e){ propietario = "Sin propietario"; }
        return "Propietario: "+ propietario+"\nPrecio compania: $" + getPrecio().getCantidad() + "\n" + "Monto : " + getFactorSimple() + " lo sacado en los dados\n"
                + "Monto con Edesur: " + getFactorDoble() + " lo sacado en los dados\n";
    }

    public int getFactorSimple() {
        return factorSimple;
    }

    public int getFactorDoble() {
        return factorDoble;
    }
}
