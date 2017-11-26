package fiuba.algo3.tp2.algopoly.model;

import java.util.LinkedList;
import java.util.ListIterator;

public class Jugadores {

    private ListIterator<Jugador> iterador;
    private final LinkedList<Jugador> jugadores;

    public Jugadores(Tablero tablero) {
        jugadores = new LinkedList<>();

        jugadores.add(new Jugador(new Dinero(10000), tablero));
        jugadores.add(new Jugador(new Dinero(10000), tablero));
        jugadores.add(new Jugador(new Dinero(10000), tablero));

        this.iterador = jugadores.listIterator(1);
    }

    public Jugador proximo() {
        if (iterador.hasNext()) {
            return iterador.next();
        }
        this.iterador = jugadores.listIterator(0);
        return iterador.next();
    }

    public Jugador primero() {
        return jugadores.getFirst();
    }

    public void eliminar(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public boolean quedaUno() {
        return jugadores.size() == 1;
    }

}
