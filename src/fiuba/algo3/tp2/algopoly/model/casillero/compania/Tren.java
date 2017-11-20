package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Tren extends Compania {

    private static final Dinero PRECIO = new Dinero(38000);
    private final int posicion;

    public Tren() {
        super(PRECIO);
        this.posicion = 18;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void actuarSobre(Jugador jugador) {
        int indiceDeMultiplicidadEdesur = 450;
        Dinero dineroADecrementar = new Dinero(jugador.getUltimaSumaDados() * indiceDeMultiplicidadEdesur);
        jugador.decrementarCapitalEn(dineroADecrementar);
    }

}
