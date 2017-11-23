package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.NoComprado;

public abstract class BarrioSimple extends Barrio {

	protected int casa = 0;
	protected Dinero costoCasa;


	public void comprarCasa(Jugador jugador ) throws CapitalInsuficienteException {
		
		if (this.casa == 1) throw new NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException();
		
		jugador.decrementarCapitalEn( this.costoCasa);
		
		this.casa=1;
		this.estadoComprado.agregarConstruccion();
	}

	@Override
	public void dejarSinPropietario() {

		this.casa = 0;

		this.estadoActual = new NoComprado();

		this.estadoComprado.resetear();

	}
}
