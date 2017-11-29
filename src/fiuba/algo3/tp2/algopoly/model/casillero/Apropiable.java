package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public interface Apropiable {

    public void modificarPropietario(Jugador jugador);

    public void dejarSinPropietario();

    public Dinero getPrecio();

    public int obtenerCantidadDePropiedadesParaMovimientoDinamico();
}
