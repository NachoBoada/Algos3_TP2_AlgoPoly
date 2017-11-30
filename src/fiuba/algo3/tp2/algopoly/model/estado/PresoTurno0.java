package fiuba.algo3.tp2.algopoly.model.estado;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;

public class PresoTurno0 extends Preso {
	
	public PresoTurno0(){ nombre= "Preso";}
	@Override
	public void cambiarProximoEstadoPreso(Jugador jugador, Carcel carcel) {
		
		jugador.cambiarEstado( new PresoTurno1 () );
	}
	
	public void pagarFianza(Jugador jugador) {

		throw new NoSePuedePagarFianzaEnEsteTurnoException();

	}

	@Override
	public String getNombre() {
		return nombre;
	}
}
