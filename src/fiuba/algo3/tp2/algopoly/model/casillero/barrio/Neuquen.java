package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Neuquen extends BarrioSimple {

    public Neuquen (){

        super();
        this.precio = new Dinero(17000);
        this.costoCasa= new Dinero(4800);
        this.precioAlquiler= new Dinero (1500);
        this.precioAlquilerConUnaCasa= new Dinero(3500);
        this.casa=0;
    }
}
