package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;

public abstract class Compania implements Encasillable{

    private Jugador dueno;
    private final Dinero precio;
    
    public Compania(Dinero precio) {
        this.precio = precio;
    }

    public Dinero getPrecio() {
        return precio;
    }

	public Jugador getDueno() {
		return dueno;
	}

	public void modificarDueno(Jugador jugador) {
		this.dueno = jugador;
	}

}
