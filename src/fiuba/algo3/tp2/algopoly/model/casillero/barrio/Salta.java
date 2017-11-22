package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

public class Salta extends Region {
	
	public Salta () {
		barrioSur = new SaltaSur(this);
		barrioNorte = new SaltaNorte(this);
	}
}
