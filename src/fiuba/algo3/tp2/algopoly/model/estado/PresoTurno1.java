package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class PresoTurno1 extends Preso {

	public PresoTurno1(){
		nombre= "Preso ( primer turno)";
	}
	@Override
	public void cambiarProximoEstadoPreso (Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado ( new PresoTurno2 (carcel) );
	}
	
	public void pagarFianza(Jugador jugador) {

		throw new NoSePuedePagarFianzaEnEsteTurnoException();

	}

	@Override
	public String getNombre() {
		return nombre;
	}

}
