package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class PrimerPremio extends Premio {

    public PrimerPremio() {
        super(new Dinero(50000));
    }
    
    @Override public Premio obtenerProximo() {
        return new SegundoPremio();
    }
}
