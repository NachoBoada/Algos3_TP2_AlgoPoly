package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Subte extends Compania {

    private static final Dinero PRECIO = new Dinero(40000);

    private final int posicion;
    private final Transportes transportes;

    public Subte(Transportes transportes) {
        super(PRECIO);
        this.posicion = 8;
        FACTOR_SIMPLE = 600;
        FACTOR_DOBLE = 1100;
        this.transportes = transportes;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    private void cobrarBoleto(Jugador jugador, int factor) {
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
        cobrarBoleto(jugador, FACTOR_DOBLE);
    }

    @Override
    public void cobrarSimple(Jugador jugador) {
        cobrarBoleto(jugador, FACTOR_SIMPLE);
    }

    @Override
    public void doSomething(Jugador jugador) {
        this.transportes.cobrarBoleto(this, jugador);
    }

}
