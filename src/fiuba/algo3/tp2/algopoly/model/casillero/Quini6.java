package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.boleta.Premio;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Quini6 {

    public void actuarSobre(Jugador jugador) {
        BoletaQuini6 boleto = jugador.getBoletoQuini6();
        Premio premio = boleto.getPremio();

        jugador.incrementarCapitalEn(premio.getValor());

        boleto.actualizarPremio();
    }
}
