package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Edesur extends Compania {
    
    private static final Dinero PRECIO = new Dinero(35000);
    private final int posicion;
    private Jugador duenio;

    public Edesur() {
        super(PRECIO);
        posicion = 3;
    }
    
    

    @Override
    public void actuarSobre(Jugador jugador) {
    	int indiceDeMultiplicidadEdesur = 500;
    	Dinero dineroADecrementar = new Dinero(jugador.getUltimaSumaDados() * indiceDeMultiplicidadEdesur);
    	jugador.decrementarCapitalEn(dineroADecrementar);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
    
}
