package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

public class Tren extends Compania {

    private static final Dinero PRECIO = new Dinero(38000);
    private static final int FACTOR_SIMPLE = 450;
    private static final int FACTOR_DOBLE = 800;

    private final int posicion;
    private final Transportes transaportes;

    public Tren(Transportes transportes) {
        super(PRECIO);
        this.posicion = 16;
        this.transaportes = transportes;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
    
    @Override
    public void doSomething(Jugador jugador) {
        this.transaportes.cobrarBoleto(this, jugador);
    }

    private void cobrarBoleto(Jugador jugador, int factor) {
        int ultimaSumaDados = Dados.getInstance().obtenerUltimaSuma();
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

}
