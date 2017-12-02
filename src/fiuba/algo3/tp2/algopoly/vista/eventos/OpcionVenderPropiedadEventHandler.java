package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionVenderPropiedadEventHandler implements EventHandler<ActionEvent>{

    Propiedad propiedad;
    ContenedorPrincipal contenedorPrincipal;



    public OpcionVenderPropiedadEventHandler(Propiedad propiedad, ContenedorPrincipal contenedorPrincipal){

        this.propiedad = propiedad;
        this.contenedorPrincipal = contenedorPrincipal;

    }


    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        jugadorActual.venderPropiedad(this.propiedad);

        if (this.contenedorPrincipal.getJugadorTieneQueVender()){

            jugadorActual.caerEn(jugadorActual.casilleroActual());
            Juego.getInstance().turnoProximojugador();
            this.contenedorPrincipal.setJugadorTieneQueVender(false);

        }

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

    }
}
