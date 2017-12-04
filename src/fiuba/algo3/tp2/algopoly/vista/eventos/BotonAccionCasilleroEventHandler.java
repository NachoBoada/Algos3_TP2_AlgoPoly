package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.vista.InformacionCasilleroVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;

public class BotonAccionCasilleroEventHandler implements EventHandler<ActionEvent> {


    private InformacionCasilleroVista informacionCasillero;
    private Encasillable casillero;

    public BotonAccionCasilleroEventHandler(Encasillable casillero, InformacionCasilleroVista informacionCasillero){

        this.informacionCasillero= informacionCasillero;
        this.casillero= casillero;


    }
    @Override
    public void handle(ActionEvent event) {

        this.informacionCasillero.setContenido( casillero.getDescripcion());


    }
}
