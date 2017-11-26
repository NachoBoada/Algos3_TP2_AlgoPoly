package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Aysa extends Compania {

    private static final Dinero PRECIO = new Dinero(30000);
    private static final int FACTOR_SIMPLE = 300;
    private static final int FACTOR_DOBLE = 500;

    private final int posicion;
    private final Servicios servicios;

    public Aysa(Servicios servicios) {
        super(PRECIO);
        posicion = 12;
        this.servicios = servicios;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    private void cobrar(Jugador jugador, int factor) {
        int ultimaSumaDados = jugador.getUltimoTiroDeDados().resultado();
        Dinero dineroADecrementar = new Dinero(ultimaSumaDados * factor);
        try {
            jugador.decrementarCapitalEn(dineroADecrementar);
        } catch (CapitalInsuficienteException e) {
            throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();
        }
    }

    @Override
    public void cobrarDoble(Jugador jugador) {
        cobrar(jugador, FACTOR_DOBLE);
    }

    @Override
    public void cobrarSimple(Jugador jugador) {
        cobrar(jugador, FACTOR_SIMPLE);
    }

    @Override
    public void doSomething(Jugador jugador) {
        this.servicios.cobrar(this, jugador);
    }

}
