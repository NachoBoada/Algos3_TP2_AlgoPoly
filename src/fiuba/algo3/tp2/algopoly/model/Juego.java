package fiuba.algo3.tp2.algopoly.model;

public class Juego {

    private Jugadores jugadores;
    private Jugador jugadorActual;
    private static final Juego INSTANCE = new Juego();
    private boolean juegoFinalizado;

    private Juego() {

    }

    public static Juego getInstance() {
        return INSTANCE;
    }

    public void comenzarJuego() {

        this.juegoFinalizado = false;
        jugadores = new Jugadores(new Tablero());
        this.jugadorActual = this.jugadores.primero();
    }

    public void turnoProximojugador() {
        if (this.jugadorActual.saltearTurno()) {
            this.jugadorActual = this.jugadores.proximo();
        }
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void jugadorPierdeElJuego(Jugador jugador) {
        jugadores.eliminar(jugador);

        if (jugadores.quedaUno()) {
            this.finalizarJuego();
        }
    }

    public void finalizarJuego(){

        this.juegoFinalizado = true;

    }
}
