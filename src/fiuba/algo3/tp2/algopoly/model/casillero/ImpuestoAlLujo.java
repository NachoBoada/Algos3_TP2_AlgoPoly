package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class ImpuestoAlLujo implements Encasillable {
	
	private final int posicion;
	private double porcentajeDelImpuesto = 0.1;
	private final String nombre;
	
	public ImpuestoAlLujo(){

		this.posicion = 10;

		this.nombre = "Impuesto Al Lujo";
	}
	
    public int getPosicion() {
        return this.posicion;
    }

	@Override
	public String getDescripcion() {
		return " Se paga el 10% de todo el efectivo del jugador";
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}


	@Override
	public void actuarSobre(Jugador jugador) {

		jugador.actualizarCasillero(this,this.posicion);
		jugador.getCapital().multiplicar(1 - porcentajeDelImpuesto);
	}

	public boolean esPropiedad(){

		return false;

	}
	
	
	
}
