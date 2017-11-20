package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

public abstract class Region {

    protected BarrioDividido barrioSur;
    protected BarrioDividido barrioNorte;

    public BarrioDividido getBarrioNorte() {
        return barrioNorte;
    }

    public BarrioDividido getBarrioSur() {
        return barrioSur;
    }

}
