package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public abstract class Premio {

    private final Dinero valor;

    public Premio(Dinero valor) {
        this.valor = valor;
    }

    public Dinero getValor() {
        return this.valor;
    }

    public abstract Premio obtenerProximo();

}
