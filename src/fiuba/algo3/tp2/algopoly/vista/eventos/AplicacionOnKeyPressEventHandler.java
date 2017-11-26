package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.vista.BarraDeMenu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent>{

    Stage stage;
    BarraDeMenu barraDeMenu;

    public AplicacionOnKeyPressEventHandler(Stage stage, BarraDeMenu barraDeMenu) {

        this.stage = stage;
        this.barraDeMenu = barraDeMenu;

    }


    @Override
    public void handle(KeyEvent event) {

        if ( event.getCode() == KeyCode.ESCAPE ) {

            stage.setMaximized(true);
            barraDeMenu.aplicacionMaximizada();
        }

    }
}
