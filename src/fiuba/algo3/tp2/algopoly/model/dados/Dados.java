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

    public TiroDeDados tirar() {

        return new TiroDeDados(dadoUno.tirar(), dadoDos.tirar());

    }

    public TiroDeDados tirar(int tiroUno, int tiroDos) {

        return new TiroDeDados(tiroUno, tiroDos);

    }

}
