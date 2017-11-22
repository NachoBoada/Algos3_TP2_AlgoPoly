package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class SantaFe extends BarrioSimple {

    public SantaFe() {

        this.precio = new Dinero(15000);
        this.costoCasa= new Dinero(4000);
        this.alquiler= new Dinero (1500);
        this.alquilerConCasa= new Dinero(3500);
        this.casa=0;
    }

}
