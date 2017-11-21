package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

public class BuenosAires extends Region {

	public BuenosAires () {
		barrioSur = new BuenosAiresSur(this);
		barrioNorte = new BuenosAiresNorte(this);
	}
	
	
}
