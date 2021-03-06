package fiuba.algo3.tp2.algopoly.model.casillero.compania;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.*;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.CompaniaNoComprada;
import fiuba.algo3.tp2.algopoly.model.casillero.compania.estado.EstadoCompania;

public abstract class Compania extends Propiedad implements Encasillable {

    protected final Dinero precio;
    protected EstadoCompania estadoActual;
    protected Servicios servicios;
    protected int factorSimple;
    protected int factorDoble;
    protected String nombre;

    public Compania(Dinero precio) {
        this.precio = precio;
        this.estadoActual = new CompaniaNoComprada();
    }

    @Override
    public Dinero getPrecio() {
        return precio;
    }

    @Override
    public void modificarPropietario(Jugador jugador) {



        this.estadoActual.venderA(jugador,this.precio,this);




        /*try{

            estadoActual.getPropietario();

            throw new NoSePuedeComprarUnaCompaniaYaCompradaException();

        }catch (SinPropietarioException e){

            jugador.decrementarCapitalEn(this.precio);

            this.estadoActual = new CompaniaComprada(jugador, factorSimple, factorDoble);


        }*/

    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.getPosicion());
        this.estadoActual.actuarSobre(jugador, this, servicios);
    }

    @Override
    public void dejarSinPropietario() {

        this.estadoActual = new CompaniaNoComprada();

    }

    @Override
    public int obtenerCantidadDePropiedadesParaMovimientoDinamico() {

        return 0;

    }

    @Override
    public String getNombre() {

        return this.nombre;

    }



    public int getFactorSimple() {
        return factorSimple;
    }

    public int getFactorDoble() {
        return factorDoble;
    }

    public boolean esPropiedad(){

        return true;

    }

    public void modificarPropietarioPorIntercambio(Jugador jugador) {
        this.estadoActual = new CompaniaComprada(jugador, factorSimple, factorDoble);
    }

    @Override
    public Jugador getPropietario() {
        return this.estadoActual.getPropietario();
    }

    public void comprada(Jugador jugador) {

        this.estadoActual = new CompaniaComprada(jugador,factorSimple,factorDoble);

    }
}
