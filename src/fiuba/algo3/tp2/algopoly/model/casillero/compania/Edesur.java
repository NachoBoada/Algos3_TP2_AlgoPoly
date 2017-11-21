package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

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
    	int ultimaSumaDados = Dados.getInstance().obtenerUltimaSuma();
    	Dinero dineroADecrementar = new Dinero(ultimaSumaDados * indiceDeMultiplicidadEdesur);
    	jugador.decrementarCapitalEn(dineroADecrementar);
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }
    
}
