package fiuba.algo3.tp2.algopoly.vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {



    @Override
    public void handle(ActionEvent event) {

        System.exit(0);

    }
}
