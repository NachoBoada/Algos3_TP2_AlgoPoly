package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.boleta.Premio;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Quini6 implements Encasillable {

    private final int posicion;

    public Quini6() {
        this.posicion = 1;
    }

    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        BoletaQuini6 boleto = jugador.getBoletoQuini6();
        Premio premio = boleto.getPremio();

        jugador.incrementarCapitalEn(premio.getValor());

        boleto.actualizarPremio();
    }
}
