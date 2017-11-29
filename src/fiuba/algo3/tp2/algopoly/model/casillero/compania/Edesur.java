package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Edesur extends Compania {

    private static final Dinero PRECIO = new Dinero(35000);
    private static final int FACTOR_SIMPLE = 500;
    private static final int FACTOR_DOBLE = 1000;

    private final int posicion;
    private final Servicios servicios;

    public Edesur(Servicios servicios) {
        super(PRECIO);
        this.posicion = 3;
        this.servicios = servicios;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getDescripcion() {
        return "Precio compania: $35000\n"+" Monto a pagar unica comapnia: 500 veces lo que dice los dados\n"+"Monto a pagar teniendo 2 companias: $1000 lo sacado en los dados\n";
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

    @Override
    public void cobrarDoble(Jugador jugador) {
        cobrar(jugador, FACTOR_DOBLE);
    }

    @Override
    public void cobrarSimple(Jugador jugador) {
        cobrar(jugador, FACTOR_SIMPLE);
    }

    @Override
    public void doSomething(Jugador jugador) {
        this.servicios.cobrar(this, jugador);
    }
}
