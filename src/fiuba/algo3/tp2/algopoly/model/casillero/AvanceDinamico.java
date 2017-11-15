package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Jugador;

public class AvanceDinamico extends Casillero {


    public AvanceDinamico(){

        this.posicion = 7;

    }


    @Override
    public void actuarSobre(Jugador jugador) {
    	
    	jugador.actualizarCasillero(this, this.posicion);

        int sumaDados = jugador.obtenerUltimaSumaDados();

        if (sumaDados == 2 || sumaDados == 3 || sumaDados == 4 || sumaDados == 5 || sumaDados == 6){

            jugador.mover(sumaDados - 2);

        }

        if (sumaDados == 7 || sumaDados == 8 || sumaDados == 9 || sumaDados == 10){

            jugador.mover(jugador.getCapital().getCantidad() % sumaDados);

        }

        if (sumaDados == 11 || sumaDados == 12){

            jugador.mover(sumaDados - jugador.getCantidadDePropiedades());

        }

    }
}
