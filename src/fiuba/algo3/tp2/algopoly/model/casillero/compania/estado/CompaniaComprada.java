package fiuba.algo3.tp2.algopoly.model.casillero.compania.estado;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.AlgunNombreDeInterfaz;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;

public class CompaniaComprada implements EstadoCompania {
	

    private final Jugador duenio;
    private int FACTOR_SIMPLE;
    private int FACTOR_DOBLE;
    
    public CompaniaComprada(Jugador jugador, int factorSimple, int factorDoble) {
        this.duenio = jugador;
        this.FACTOR_SIMPLE = factorSimple;
    	this.FACTOR_DOBLE = factorDoble;
    }

    public void actuarSobre(Jugador jugador, Compania compania, AlgunNombreDeInterfaz algo) {
        if (!jugador.esDuenioDe(compania)) {
            algo.cobrar(this, jugador);
        }
    }
    
    public void cobrarDoble(Jugador jugador) {
        cobrar(jugador, FACTOR_DOBLE);
    }

    public void cobrarSimple(Jugador jugador) {
        cobrar(jugador, FACTOR_SIMPLE);
    }
    

    private void cobrar(Jugador jugador, int factor) {
        int ultimaSumaDados = jugador.getUltimoTiroDeDados().resultado();
        Dinero dineroADecrementar = new Dinero(ultimaSumaDados * factor);
        try {
            jugador.decrementarCapitalEn(dineroADecrementar);
        } catch (CapitalInsuficienteException e) {
            throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();
        }
    }


    public Jugador getDuenio() {
        return this.duenio;
    }

}
