package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
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
		this.alquiler= new AlquilerSinConstruccionBarrioSimple( this.precioAlquiler );
	}


	public void actuarSobre(Jugador jugador){

		if (!jugador.esPropietarioDe(this) && this.tieneDuenio){

			this.alquiler.cobrarAlquiler(jugador);

		}

	}

	public void comprarCasa(Jugador jugador ) {
		
		if (this.casa == 1) throw new NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException();
		
		try {
			jugador.decrementarCapitalEn( this.costoCasa);
		}catch (CapitalInsuficienteException e) {throw new CapitalInsuficienteException();}
		
		this.casa=1;
		this.alquiler.cambiarProximoAlquiler(this);
	}
	public Dinero getPrecioAlquiler() { return precioAlquiler; }

	public Dinero getPrecioAlquilerConUnaCasa(){ return precioAlquilerConUnaCasa; }

	public void setAlquiler(AlquilerBarrioSimple alquiler) {

		this.alquiler = alquiler;

	}
}
