package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BotonAccionCasilleroEventHandler implements EventHandler<KeyEvent> {

    private VBox informacionCasillero;
    private Encasillable casillero;

    BotonAccionCasilleroEventHandler( Encasillable casillero, VBox panelDerecho){

        this.casillero= casillero;
        StackPane stackSeleccion = (StackPane) panelDerecho.getChildren().get(4);
        this.informacionCasillero = (VBox) stackSeleccion.getChildren().get(1);
    }
    @Override
    public void handle(KeyEvent event) {


    }
}
