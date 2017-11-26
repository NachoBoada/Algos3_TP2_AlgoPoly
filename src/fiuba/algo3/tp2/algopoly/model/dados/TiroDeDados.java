package fiuba.algo3.tp2.algopoly.model.dados;

public class TiroDeDados {

    private final int _tiroUno;
    private final int _tiroDos;
    
    public TiroDeDados(int tiroUno, int tiroDos) {
        _tiroUno = tiroUno;
        _tiroDos = tiroDos;
    }
    
    public boolean esDuplicado() {
        return _tiroUno == _tiroDos;
    }
    
    public int resultado() {
        return _tiroUno + _tiroDos;
    }
    
    private boolean tiroValido(int tiro) {
        return tiro >= 1 && tiro <= 12;
    }

    public boolean esValido() {
        return tiroValido(_tiroUno) && tiroValido(_tiroDos);
    }
}
