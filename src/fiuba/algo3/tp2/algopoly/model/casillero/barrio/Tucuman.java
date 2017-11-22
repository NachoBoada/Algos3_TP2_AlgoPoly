package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Tucuman extends BarrioSimple {

    public Tucuman (){

        this.precio = new Dinero(25000);
        this.costoCasa= new Dinero(7000);
        this.precioAlquiler= new Dinero (2500);
        this.precioAlquilerConUnaCasa= new Dinero(4500);
        this.casa=0;

    }
}
