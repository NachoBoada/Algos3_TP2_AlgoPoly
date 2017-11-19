package fiuba.algo3.tp2.algopoly.model.dados;

public class Dados {

    private static final Dados INSTANCE = new Dados();
    private final Dado dadoUno;
    private final Dado dadoDos;

    private Dados() {
        dadoUno = new Dado();
        dadoDos = new Dado();
    }

    public static Dados getInstance() {
        return INSTANCE;
    }
    
    public int tirar() {
        return dadoUno.tirar() + dadoDos.tirar();
    }

}
