package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AvanceDinamico implements Encasillable {

    private final int posicion;
    private final String nombre;

    public AvanceDinamico() {
        this.posicion = 7;
        this.nombre = "Avance Dinamico";
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getDescripcion() {
        return " Modifica el movimiento del jugador";
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        int sumaDados = jugador.getUltimoTiroDeDados().resultado();

        //si los dados suman 2, moveria 0 casilleros.
        if (sumaDados == 3 || sumaDados == 4 || sumaDados == 5 || sumaDados == 6) {

            jugador.mover(sumaDados - 2);

        }

        if (sumaDados == 7 || sumaDados == 8 || sumaDados == 9 || sumaDados == 10) {
        	
        	int cantidadCasilleros = (int) jugador.getCapital().getCantidad() % sumaDados;

            if (cantidadCasilleros > 0)	jugador.mover(cantidadCasilleros);

        }

        if (sumaDados == 11 || sumaDados == 12) {

        	int cantidadCasilleros = sumaDados - jugador.getCantidadDePropiedadesParaMovimientoDinamico();
        	
        	if (cantidadCasilleros > 0)	jugador.mover(cantidadCasilleros);

        }

    }

    public boolean esApropiable(){

        return false;

    }
}
