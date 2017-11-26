package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaNoComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.EstadoCompania;

public abstract class Compania implements Encasillable {

    protected final Dinero precio;
    private EstadoCompania estado;

    public Compania(Dinero precio) {
        this.precio = precio;
        this.estado = new CompaniaNoComprada();
    }

    public Dinero getPrecio() {
        return precio;
    }

    public Jugador getDuenio() {
        return estado.getDuenio();
    }

    public void modificarPropietario(Jugador jugador) {
        this.estado = new CompaniaComprada(jugador);
    }
    
    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this,this.getPosicion());
        this.estado.actuarSobre(jugador, this);
    }
    
    public abstract void cobrarDoble(Jugador jugador);

    public abstract void cobrarSimple(Jugador jugador);
    
    public abstract void doSomething(Jugador jugador);

    public void dejarSinPropietario(){

        this.estado = new CompaniaNoComprada();

    }
}
