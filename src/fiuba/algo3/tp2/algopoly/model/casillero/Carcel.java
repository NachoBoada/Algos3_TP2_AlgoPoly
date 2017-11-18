package fiuba.algo3.tp2.algopoly.model.casillero;

import fiuba.algo3.tp2.algopoly.model.ElDineroNoPuedeSerNegativo;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public class Carcel implements Encasillable {

    private final int posicion;
    private final Dinero costoFianza;

    public Carcel() {

        this.posicion = 5;

        this.costoFianza = new Dinero(45000);
    }
    
    public int getPosicion() {
        return this.posicion;
    }

    @Override
    public void actuarSobre(Jugador jugador) {

        jugador.actualizarCasillero(this, this.posicion);

        jugador.irPreso(this);

    }

    public void pagarFianza(Jugador jugador) {

        try {
            jugador.derementarCapitalEn(costoFianza);
        } catch (ElDineroNoPuedeSerNegativo e) {
            throw new ElJugadorNoTieneCapitalSuficienteParaPagarFianza();
        }

    }

}
