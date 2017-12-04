package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class RetrocesoDinamico implements Encasillable {

    private final int posicion;
    private final String nombre;

    public RetrocesoDinamico() {

        this.posicion = 18;

        this.nombre = "Retroceso Dinamico";

    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return "Nombre: Retroceso Dinamico \n" +
                "Modifica el movimiento del jugador";
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.setretrocesoDinamico();
        jugador.actualizarCasillero(this, this.posicion);

        int sumaDados = jugador.getUltimoTiroDeDados().resultado();

        if (sumaDados == 2 || sumaDados == 3 || sumaDados == 4 || sumaDados == 5 || sumaDados == 6) {
        	
        	int cantidadCasilleros = sumaDados - jugador.getCantidadDePropiedadesParaMovimientoDinamico();

            if (cantidadCasilleros > 0)	jugador.mover(cantidadCasilleros * -1);
        }

        if (sumaDados == 7 || sumaDados == 8 || sumaDados == 9 || sumaDados == 10) {
        	
        	int cantidadCasilleros = (int) jugador.getCapital().getCantidad() % sumaDados;

            if (cantidadCasilleros > 0)	jugador.mover(cantidadCasilleros * -1);

        }

        if (sumaDados == 11 || sumaDados == 12) {

            jugador.mover((sumaDados - 2) * -1);

        }

    }

    public boolean esPropiedad(){

        return false;

    }

}
