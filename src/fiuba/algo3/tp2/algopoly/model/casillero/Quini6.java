package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.boleta.Premio;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Quini6 implements Encasillable {

    private final int posicion;
    private final String nombre;

    public Quini6() {

        this.posicion = 1;

        this.nombre = "Quini 6";
    }

    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDescripcion() {
        return  "Nombre: Quini 6 \n" +
                "El jugador obtiene un premio \n" +
                "la primera y segunda vez que \n" +
                "cae en este casillero.";
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        BoletaQuini6 boleto = jugador.getBoletoQuini6();
        Premio premio = boleto.getPremio();

        jugador.incrementarCapitalEn(premio.getValor());

        boleto.actualizarPremio();
    }

    public boolean esPropiedad(){

        return false;

    }
}
