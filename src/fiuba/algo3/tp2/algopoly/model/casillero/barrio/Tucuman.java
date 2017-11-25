package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class Tucuman extends BarrioSimple {

    public Tucuman (){

        super();
        this.posicion = 19;
        this.precio = new Dinero(25000);
        this.costoCasa= new Dinero(7000);

        this.estadoComprado = new Comprado(new Dinero (2500),new Dinero(4500),new Dinero(0),new Dinero(0));

    }
}
