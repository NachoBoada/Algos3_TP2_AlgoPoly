package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class Libre extends Estado {
	
	private String nombre ;

	public Libre(){ nombre = "Libre "; }

	public void cambiarProximoEstadoPreso(Jugador jugador, Carcel carcel) {
		jugador.cambiarEstado( new PresoTurno0 () );
	}
	
	public void pagarFianza(Jugador jugador) {}
	
	public void mover(Jugador jugador, int posicionActual, int cantidadCasillero,Tablero tablero) {
		//jugador.sumarAPosicion(cantidadCasillero);
		tablero.moverJugador(jugador, posicionActual, cantidadCasillero);

	}

    @Override
    public String getNombre() {
        return nombre;
    }


}
