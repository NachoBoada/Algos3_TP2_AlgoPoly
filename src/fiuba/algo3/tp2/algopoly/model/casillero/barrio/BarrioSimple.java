package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.NoComprado;

public abstract class BarrioSimple extends Barrio {

	protected int cantidadCasas = 0;
	protected Dinero costoCasa;


	public void comprarCasa(Jugador jugador ) throws CapitalInsuficienteException {
		
		if (this.cantidadCasas == 1) throw new NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException();
		
		jugador.decrementarCapitalEn( this.costoCasa);
		
		this.cantidadCasas=1;
		this.estadoComprado.agregarConstruccion();
	}

	@Override
	public void dejarSinPropietario() {

		this.cantidadCasas = 0;

		this.estadoActual = new NoComprado();

		this.estadoComprado.resetear();

	}
	
	public int obtenerCantidadEdificaciones() {
		return cantidadCasas;
	}
}
