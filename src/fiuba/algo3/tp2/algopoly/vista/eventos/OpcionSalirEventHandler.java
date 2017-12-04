package fiuba.algo3.tp2.algopoly.vista.eventos;


import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {


    private Stage stage;

    public OpcionSalirEventHandler(Stage stage){

        this.stage =stage;

    }


    @Override
    public void handle(ActionEvent event) {

        Alert alertaNuevoJuego = new Alert(Alert.AlertType.CONFIRMATION);

        alertaNuevoJuego.initOwner(stage);
        alertaNuevoJuego.setTitle("Salir del juego");
        alertaNuevoJuego.setHeaderText("Seguro que queres salir del juego?");

        Optional<ButtonType> result = alertaNuevoJuego.showAndWait();
        if (result.get() == ButtonType.OK) {

            System.exit(0);

        }

    }
}
