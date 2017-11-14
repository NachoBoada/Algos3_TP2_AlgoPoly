package fiuba.algo3.tp2.algopoly.model.boleta;

public class BoletaQuini6 {
    
    private Premio premio;
    
    public BoletaQuini6() {
        this.premio = new PrimerPremio();
    }

    public Premio getPremio() {
        return this.premio;
    }

    public void actualizarPremio() {
        this.premio = this.premio.obtenerProximo();
    }
    
}
