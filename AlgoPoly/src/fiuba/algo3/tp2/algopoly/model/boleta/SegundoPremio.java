package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Capital;

public class SegundoPremio extends Premio {

    public SegundoPremio() {
        super(new Capital(30000));
    }

    @Override public Premio obtenerProximo() {
        return new PremioSinValor();
    }

}
