package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class SantaFe extends BarrioSimple {

    public SantaFe() {

        super();

        this.posicion = 11;
        this.nombre = "Santa Fe";
        this.precio = new Dinero(15000);
        this.costoCasa= new Dinero(4000);

        this.estadoComprado = new Comprado(new Dinero (1500),new Dinero(3500),new Dinero(0),new Dinero(0));



    }

}
