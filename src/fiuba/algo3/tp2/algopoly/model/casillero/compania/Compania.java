package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaNoComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.EstadoCompania;

public abstract class Compania implements Encasillable, Apropiable{

    protected final Dinero precio;
    private EstadoCompania estadoActual;
    protected AlgunNombreDeInterfaz algo;
    protected int FACTOR_SIMPLE;
    protected int FACTOR_DOBLE;
    protected String nombre;

    public Compania(Dinero precio) {
        this.precio = precio;
        this.estadoActual = new CompaniaNoComprada();
    }

    public Dinero getPrecio() {
        return precio;
    }

    public void modificarPropietario(Jugador jugador) {
        this.estadoActual = new CompaniaComprada (jugador, FACTOR_SIMPLE, FACTOR_DOBLE);
    }
    
    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this,this.getPosicion());
        this.estadoActual.actuarSobre(jugador, this, algo);
    }
    
    public void dejarSinPropietario(){

        this.estadoActual = new CompaniaNoComprada();

    }

    public int obtenerCantidadDePropiedadesParaMovimientoDinamico(){

        return 0;

    }

    public String getNombre(){

        return this.nombre;

    }
}
