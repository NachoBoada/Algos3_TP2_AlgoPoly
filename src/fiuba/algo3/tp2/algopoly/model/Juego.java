package fiuba.algo3.tp2.algopoly.model;

import java.util.LinkedList;

public class Juego {

    private Jugadores jugadores;
    private Jugador jugadorActual;
    private String nombreJugadorGanador;
    private Tablero tablero;
    private static final Juego INSTANCE = new Juego();
    private boolean juegoFinalizado;

    private Juego() {

    }

    public static Juego getInstance() {
        return INSTANCE;
    }

    public void comenzarJuego(double capitalInicialDeJugadores) {
        tablero= new Tablero();
        this.juegoFinalizado = false;
        jugadores = new Jugadores( tablero,capitalInicialDeJugadores);
        this.jugadorActual = this.jugadores.primero();
    }

    public void turnoProximojugador() {

        if ( ! this.jugadorActual.getUltimoTiroDeDados().esDuplicado() && this.jugadorActual.getContadorTirosDuplicados() == 1){

            this.jugadorActual.resetContadorTirosDuplicados();

        }

        if (this.jugadorActual.saltearTurno()) {

            this.jugadorActual = this.jugadores.proximo();
        }
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void jugadorPierdeElJuego(Jugador jugador) {

        jugadores.eliminar(jugador);

        this.jugadorActual = this.jugadores.getJugadorActual();

        if (jugadores.quedaUno()) {
            this.nombreJugadorGanador = this.jugadores.primero().getNombreJugador();
            this.finalizarJuego();
        }
    }

    public Tablero getTablero(){ return tablero; }

    public void finalizarJuego(){

        this.juegoFinalizado = true;

    }

    public Jugador obtenerJugador(String nombre) {

        return this.jugadores.obtenerJugador(nombre);
    }

    public LinkedList<Jugador> getJugadores (){
        return this.jugadores.getJugadores();
    }

    public boolean finalizado() {

        return this.juegoFinalizado;
    }

    public String obtenerNombreJugadorGanador() {

        return this.nombreJugadorGanador;

    }
}
