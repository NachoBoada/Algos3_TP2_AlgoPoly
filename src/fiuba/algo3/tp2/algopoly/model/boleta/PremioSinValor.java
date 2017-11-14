package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class PremioSinValor extends Premio {

    public PremioSinValor() {
        super(new Dinero(0));
    }

    @Override
    public Premio obtenerProximo() {
        return this;
    }
    
}
