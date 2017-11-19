package fiuba.algo3.tp2.algopoly.model.casillero.compania;

public class Transportes {

    private final Subte subte;
    private final Tren tren;

    public Transportes() {
        subte = new Subte();
        tren = new Tren();
    }

    public Subte getSubte() {
        return this.subte;
    }

    public Tren getTren() {
        return this.tren;
    }
}
