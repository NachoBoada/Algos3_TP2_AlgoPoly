package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class SegundoPremio extends Premio {

    public SegundoPremio() {
        super(new Dinero(30000));
    }

    @Override public Premio obtenerProximo() {
        return new PremioSinValor();
    }

}
