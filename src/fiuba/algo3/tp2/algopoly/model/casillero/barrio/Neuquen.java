package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class Neuquen extends BarrioSimple {

    public Neuquen (){

        super();
        
        this.posicion = 17;
        this.nombre = "Neuquen";
        this.precio = new Dinero(17000);
        this.costoCasa= new Dinero(4800);

        this.estadoComprado = new Comprado(new Dinero (1500),new Dinero(3500),new Dinero(0),new Dinero(0));
    }
}
