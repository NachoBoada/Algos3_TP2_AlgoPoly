package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.Dados;

public class RetrocesoDinamico implements Encasillable {

    private final int posicion;

    public RetrocesoDinamico() {

        this.posicion = 18;

    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        int sumaDados = jugador.getUltimoTiroDeDados().resultado();

        if (sumaDados == 2 || sumaDados == 3 || sumaDados == 4 || sumaDados == 5 || sumaDados == 6) {
        	
        	int cantidadCasilleros = sumaDados - jugador.getCantidadDePropiedades();

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

}
