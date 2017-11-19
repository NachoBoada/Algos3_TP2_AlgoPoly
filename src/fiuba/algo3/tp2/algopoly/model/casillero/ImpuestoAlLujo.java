package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class ImpuestoAlLujo implements Encasillable {
	
	private final int posicion;
	private double porcentajeDelImpuesto = 0.1;
	
	public ImpuestoAlLujo(){
		posicion = 10;
	}
	
    public int getPosicion() {
        return this.posicion;
    }

	@Override
	public void actuarSobre(Jugador jugador) {
		jugador.getCapital().multiplicar(1 - porcentajeDelImpuesto);
	}
	
	
	
}