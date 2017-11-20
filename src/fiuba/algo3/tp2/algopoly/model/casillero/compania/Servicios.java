package fiuba.algo3.tp2.algopoly.model.casillero.compania;

public class Servicios {

    private Aysa aysa;
    private Edesur edesur;
    
    public Servicios() {
    	aysa = new Aysa();
    	edesur = new Edesur();
    }
    
    public Edesur getEdesur() {
        return this.edesur;
    }
    
    public Aysa getAysa() {
        return this.aysa;
    }
        
}
