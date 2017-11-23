package fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class AlquilerConCasa extends AlquilerBarrio {


    public AlquilerConCasa(Comprado estadoBarrioComprado) {
        super(estadoBarrioComprado);

    }

    @Override
    public void cobrarAlquiler(Jugador jugador) {

        try {
            jugador.decrementarCapitalEn( this.estadoBarrioComprado.getPrecioAlquilerConUnaCasa());
        }catch (CapitalInsuficienteException e) {throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();}

        this.estadoBarrioComprado.getPropietario().incrementarCapitalEn(this.estadoBarrioComprado.getPrecioAlquilerConUnaCasa());

    }

    @Override
    public void cambiarProximoAlquiler() {

        this.estadoBarrioComprado.cambiarTipoAlquiler(new AlquilerConDosCasas(this.estadoBarrioComprado));

    }
}
