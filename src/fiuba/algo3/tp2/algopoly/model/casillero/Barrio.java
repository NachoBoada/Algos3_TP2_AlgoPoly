package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Casillero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Dinero;

public class Barrio extends Casillero{
    private Jugador propietario;
    private Dinero precio;
    private String nombre;

    public Barrio(String nombre, Dinero precio){
        this.precio= precio;
        this.nombre= nombre;
    }
    public Dinero getPrecioDelBarrio(){
        return this.precio;
    }

    @Override
    public void actuarSobre( Jugador jugador) {
        jugador.comprarBarrio(this);
    }
}
