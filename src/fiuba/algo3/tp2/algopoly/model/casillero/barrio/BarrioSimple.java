package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerBarrioSimple;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.alquiler.AlquilerSinConstruccionBarrioSimple;

public abstract class BarrioSimple extends Barrio {

	protected int casa;
	protected Dinero precioAlquiler;
	protected Dinero precioAlquilerConUnaCasa;
	protected Dinero costoCasa;
	protected AlquilerBarrioSimple alquiler;

	BarrioSimple(){

		this.tieneDuenio = false;
	}


	public void actuarSobre(Jugador jugador) throws ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException {

		if (!jugador.esPropietarioDe(this) && this.tieneDuenio){
			this.alquiler.cobrarAlquiler(jugador);
		}

	}

	public void comprarCasa(Jugador jugador ) throws CapitalInsuficienteException {
		
		if (this.casa == 1) throw new NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException();
		
		jugador.decrementarCapitalEn( this.costoCasa);
		
		this.casa=1;
		this.alquiler.cambiarProximoAlquiler();
	}
	
	public Dinero getPrecioAlquiler() { return precioAlquiler; }

	public Dinero getPrecioAlquilerConUnaCasa(){ return precioAlquilerConUnaCasa; }

	public void setAlquiler(AlquilerBarrioSimple alquiler) {

		this.alquiler = alquiler;

	}

	@Override
	public void dejarSinPropietario() {

		this.casa = 0;

		this.propietario = null;

		this.alquiler = new AlquilerSinConstruccionBarrioSimple(this);

	}
}
