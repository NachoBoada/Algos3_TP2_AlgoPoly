package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AvanceDinamico implements Encasillable {

    private final int posicion;

    public AvanceDinamico() {
        this.posicion = 7;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

//        int sumaDados = (Dados.getInstance()).obtenerUltimaSuma();
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

        	int cantidadCasilleros = sumaDados - jugador.getCantidadDePropiedades();
        	
        	if (cantidadCasilleros > 0)	jugador.mover(cantidadCasilleros);

        }

    }
}
