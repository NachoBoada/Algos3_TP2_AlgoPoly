package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

public class Cordoba extends Region {
	
	public Cordoba () {
		barrioSur = new CordobaSur(this);
		barrioNorte = new CordobaNorte(this);
	}
}
