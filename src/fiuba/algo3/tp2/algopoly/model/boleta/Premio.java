package fiuba.algo3.tp2.algopoly.model.boleta;

import fiuba.algo3.tp2.algopoly.model.Capital;

public abstract class Premio {

    private final Capital valor;

    public Premio(Capital valor) {
        this.valor = valor;
    }

    public Capital getValor() {
        return this.valor;
    }

    public abstract Premio obtenerProximo();

}
