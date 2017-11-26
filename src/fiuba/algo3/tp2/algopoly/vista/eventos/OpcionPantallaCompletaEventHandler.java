package fiuba.algo3.tp2.algopoly.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent>{

    Stage stage;
    MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta){

        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;

    }

    @Override
    public void handle(ActionEvent event) {

        if ( !stage.isFullScreen() ) {

            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();

        }

    }
}
