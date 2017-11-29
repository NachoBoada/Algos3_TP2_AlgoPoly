package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Tren extends Compania {

    private static final Dinero PRECIO = new Dinero(38000);
    private static final int FACTOR_SIMPLE = 450;
    private static final int FACTOR_DOBLE = 800;

    private final int posicion;
    private final Transportes transaportes;

    public Tren(Transportes transportes) {
        super(PRECIO);
        this.posicion = 16;
        this.transaportes = transportes;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getDescripcion() {
        return "Precio compania: $38000\n"+" Monto a pagar unica comapnia: 450 veces lo que dice los dados\n"+"Monto a pagar teniendo 2 companias: $800 lo sacado en los dados\n";
    }

    @Override
    public void doSomething(Jugador jugador) {
        this.transaportes.cobrarBoleto(this, jugador);
    }

    private void cobrarBoleto(Jugador jugador, int factor) {
        int ultimaSumaDados = jugador.getUltimoTiroDeDados().resultado();
        Dinero dineroADecrementar = new Dinero(ultimaSumaDados * factor);

        try {
            jugador.decrementarCapitalEn(dineroADecrementar);
        } catch (CapitalInsuficienteException e) {
            throw new ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException();
        }
    }

    @Override
    public void cobrarDoble(Jugador jugador) {
        cobrarBoleto(jugador, FACTOR_DOBLE);
    }

    @Override
    public void cobrarSimple(Jugador jugador) {
        cobrarBoleto(jugador, FACTOR_SIMPLE);
    }

}
