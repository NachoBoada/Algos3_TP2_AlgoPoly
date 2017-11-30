package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Carcel implements Encasillable {

    private final int posicion;
    private final Dinero costoFianza;
    private final String nombre;

    public Carcel() {

        this.posicion = 5;

        this.nombre = "Carcel";

        this.costoFianza = new Dinero(45000);
    }
    
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return "Precio de la fianza:45000 ( se podra pagar en el turno 2 o 3)";
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        jugador.irPreso(this);

    }

	public Dinero getCostoFianza() {
		return costoFianza;
	}

    public boolean esApropiable(){

        return false;

    }

}
