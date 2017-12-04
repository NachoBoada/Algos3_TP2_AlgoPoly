package fiuba.algo3.tp2.algopoly.model.casillero.compania.estado;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnBarrioYaCompradoException;
import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnaCompaniaYaCompradaException;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Compania;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.Servicios;

public class CompaniaComprada implements EstadoCompania {
	

    private final Jugador duenio;
    private final int factorSimple;
    private final int factorDoble;
    
    public CompaniaComprada(Jugador jugador, int factorSimple, int factorDoble) {
        this.duenio = jugador;
        this.factorSimple = factorSimple;
    	this.factorDoble = factorDoble;
    }

    @Override
    public void actuarSobre(Jugador jugador, Compania compania, Servicios algo) {
        if (!jugador.esPropietarioDe(compania)) {
            algo.cobrar(this, jugador);
        }
    }
    
    public void cobrarDoble(Jugador jugador) {
        cobrar(jugador, factorDoble);
    }

    public void cobrarSimple(Jugador jugador) {
        cobrar(jugador, factorSimple);
    }
    

    private void cobrar(Jugador jugador, int factor) {
        int ultimaSumaDados = jugador.getUltimoTiroDeDados().resultado();
        Dinero dineroACobrar = new Dinero(ultimaSumaDados * factor);
        try {
            jugador.decrementarCapitalEn(dineroACobrar);
            this.duenio.incrementarCapitalEn(dineroACobrar);
        } catch (CapitalInsuficienteException e) {
            throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();
        }
    }


    public Jugador getPropietario() {
        return this.duenio;
    }

    @Override
    public void venderA(Jugador jugador, Dinero precio, Compania compania) {

        throw new NoSePuedeComprarUnaCompaniaYaCompradaException();

    }

}
