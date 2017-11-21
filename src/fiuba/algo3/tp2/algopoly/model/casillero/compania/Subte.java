package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

public class Subte extends Compania {

    private static final Dinero PRECIO = new Dinero(40000);
    private static final int FACTOR_SIMPLE = 600;
    private static final int FACTOR_DOBLE = 1100;
    
    private final int posicion;
    private final Transportes transportes;

    public Subte(Transportes transportes) {
        super(PRECIO);
        this.posicion = 8;
        this.transportes = transportes;
    }

    @Override
    public void actuarSobre(Jugador jugador) {
        this.transportes.cobrarBoleto(this, jugador);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    private void cobrarBoleto(Jugador jugador, int factor) {
        int ultimaSumaDados = Dados.getInstance().obtenerUltimaSuma();
        Dinero dineroADecrementar = new Dinero(ultimaSumaDados * factor);

        jugador.decrementarCapitalEn(dineroADecrementar);
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
