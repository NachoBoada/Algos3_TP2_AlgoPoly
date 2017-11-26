package fiuba.algo3.tp2.algopoly.model;

public class Juego {

    private Jugadores jugadores;
    private Jugador jugadorActual;
    private static final Juego INSTANCE = new Juego();

    private Juego() {
    }

    public static Juego getInstance() {
        return INSTANCE;
    }

    public void comenzarJuego() {
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
            //this.finalizarJuego();
        }
    }
}
