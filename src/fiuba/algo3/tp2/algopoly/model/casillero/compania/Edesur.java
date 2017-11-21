package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

public class Edesur extends Compania {

    private static final Dinero PRECIO = new Dinero(35000);
    private static final int FACTOR_SIMPLE = 500;
    private static final int FACTOR_DOBLE = 1000;

    private final int posicion;
    private final Servicios servicios;

    public Edesur(Servicios servicios) {
        super(PRECIO);
        posicion = 3;
        this.servicios = servicios;
    }

    @Override
    public void actuarSobre(Jugador jugador) {
        this.servicios.cobrar(this, jugador);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    private void cobrar(Jugador jugador, int factor) {
        int ultimaSumaDados = Dados.getInstance().obtenerUltimaSuma();
        Dinero dineroADecrementar = new Dinero(ultimaSumaDados * factor);

        jugador.decrementarCapitalEn(dineroADecrementar);
    }

    @Override
    public void cobrarDoble(Jugador jugador) {
        cobrar(jugador, FACTOR_DOBLE);
    }

    @Override
    public void cobrarSimple(Jugador jugador) {
        cobrar(jugador, FACTOR_SIMPLE);
    }
}
