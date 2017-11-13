package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Capital;

public class PremioSinValor extends Premio {

    public PremioSinValor() {
        super(new Capital(0));
    }

    @Override
    public Premio obtenerProximo() {
        return this;
    }
    
}
