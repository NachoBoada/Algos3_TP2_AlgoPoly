package fiuba.algo3.tp2.algopoly.model.dados;

public class Dados {

    private static final Dados INSTANCE = new Dados();
    private final Dado dadoUno;
    private final Dado dadoDos;
    private int ultimaSuma;

    private Dados() {
        dadoUno = new Dado();
        dadoDos = new Dado();
    }

    public static Dados getInstance() {
        return INSTANCE;
    }
    
    public int tirar() {
    	ultimaSuma = dadoUno.tirar() + dadoDos.tirar();
        return ultimaSuma;
    }
    
    public int obtenerUltimaSuma () {
    	return ultimaSuma;
    }
    
    //Metodo para probar test
	public void manipularSuma(int cantidadCasilleros) {
		ultimaSuma = cantidadCasilleros;		
	}

}
