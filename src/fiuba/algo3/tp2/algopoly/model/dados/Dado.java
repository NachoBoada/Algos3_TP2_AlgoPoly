package fiuba.algo3.tp2.algopoly.model.dados;

import java.util.Random;

public class Dado {
    
    private final static int MAX_VALOR = 7;
    private final static int MIN_VALOR = 1;

    public int tirar() {
        return new Random().nextInt(MAX_VALOR - MIN_VALOR) + MIN_VALOR;
    }    
}
