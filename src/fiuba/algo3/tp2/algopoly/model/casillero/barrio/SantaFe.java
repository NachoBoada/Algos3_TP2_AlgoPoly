package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class SantaFe extends BarrioSimple {

    public SantaFe() {

        super();
        this.precio = new Dinero(15000);
        this.costoCasa= new Dinero(4000);
        this.precioAlquiler= new Dinero (1500);
        this.precioAlquilerConUnaCasa= new Dinero(3500);
        this.casa=0;
    }

}
