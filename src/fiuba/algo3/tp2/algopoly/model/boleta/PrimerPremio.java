package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Capital;

public class PrimerPremio extends Premio {

    public PrimerPremio() {
        super(new Capital(50000));
    }
    
    @Override public Premio obtenerProximo() {
        return new SegundoPremio();
    }
}
