package fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruirException;
import fiuba.algo3.tp2.algopoly.model.casillero.SinPropietarioException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;

public class NoComprado implements EstadoBarrio {

    @Override
    public void actuarSobre(Jugador jugador, Barrio unBarrio) {

    }

    @Override
    public Jugador getPropietario(){
        throw new SinPropietarioException();
    }

    @Override
    public void agregarConstruccion(Jugador jugador) {

        throw new JugadorDebeComprarElBarrioParaPoderConstruirException();
    }

    @Override
    public void venderA(Jugador jugador, Dinero precio, Barrio barrio) {

        jugador.decrementarCapitalEn(precio);

        barrio.comprado(jugador);

    }
}
