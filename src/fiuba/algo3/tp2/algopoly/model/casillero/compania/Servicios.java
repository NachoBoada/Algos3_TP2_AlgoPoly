package fiuba.algo3.tp2.algopoly.model.casillero.compania;

public class Servicios {

    private final Subte subte;
    private final Tren tren;
    
    public Servicios() {
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
