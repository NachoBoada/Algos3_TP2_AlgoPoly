package fiuba.algo3.tp2.algopoly.model;

public class Juego {

    private Jugadores jugadores;
    private Jugador jugadorActual;
    private static  Juego INSTANCE;
    private Tablero tablero;

    private Juego() {
        tablero= new Tablero();
    }

    public static Juego getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Juego();
        }
        return INSTANCE;
    }

    public void comenzarJuego() {
        jugadores = new Jugadores( tablero);
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

    public Tablero getTablero() {
        return tablero;
    }
}
