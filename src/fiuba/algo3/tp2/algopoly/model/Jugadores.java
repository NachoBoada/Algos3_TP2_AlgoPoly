package fiuba.algo3.tp2.algopoly.model;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Jugadores {

    private ListIterator<Jugador> iterador;
    private final LinkedList<Jugador> jugadores;
    private Jugador jugadorActual;

    public Jugadores(Tablero tablero, double capitalInicialDeJugadores) {
        jugadores = new LinkedList<>();

        jugadores.add(new Jugador(new Dinero(capitalInicialDeJugadores), tablero, "Jugador 1"));
        jugadores.add(new Jugador(new Dinero(capitalInicialDeJugadores), tablero, "Jugador 2"));
        jugadores.add(new Jugador(new Dinero(capitalInicialDeJugadores), tablero, "Jugador 3"));

        this.iterador = jugadores.listIterator(1);
        jugadorActual = jugadores.get(0);
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

    public boolean eliminar(Jugador jugador) {
        if (jugadores.isEmpty()) {
            return false;
        }
        this.jugadorActual = proximo();
        jugadores.remove(jugador);
        return true;
    }

    public boolean quedaUno() {
        return jugadores.size() == 1;
    }

    public Jugador obtenerJugador(String nombre) {

        Jugador jugadorPedido = null;

        for (Jugador jugador : this.jugadores) {

            if (jugador.getNombreJugador().equals(nombre)){

                jugadorPedido = jugador;
            }

        }

        return jugadorPedido;

    }

    public LinkedList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public Jugador getJugadorActual() {
        return this.jugadorActual;
    }


}
