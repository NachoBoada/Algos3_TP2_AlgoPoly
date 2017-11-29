package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.estado.Comprado;

public class SantaFe extends BarrioSimple {

    public SantaFe() {

        super();

        this.posicion = 11;
        this.precio = new Dinero(15000);
        this.costoCasa= new Dinero(4000);

        this.estadoComprado = new Comprado(new Dinero (1500),new Dinero(3500),new Dinero(0),new Dinero(0));



    }

    @Override
    public String getDescripcion() {
        return "Precio terreno: $15000\n" + "Alquiler: $1500\n" + "Alquiler con 1 casa: $3500\n" + "Construir la única casa posible cuesta $4000\n";
    }
}
