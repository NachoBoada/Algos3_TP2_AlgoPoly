package fiuba.algo3.tp2.algopoly.vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonAceptarTiroDadosEventHandler implements EventHandler<ActionEvent> {

    Stage stage;


    public BotonAceptarTiroDadosEventHandler(Stage stage){

        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent event) {

        this.stage.close();


    }
}
