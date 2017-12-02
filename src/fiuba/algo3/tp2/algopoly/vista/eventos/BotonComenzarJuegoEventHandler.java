package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.vista.ContenedorBienvenidos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    ContenedorBienvenidos escenaBienvenidos;

    public BotonComenzarJuegoEventHandler(Stage stage, Scene proximaEscena, ContenedorBienvenidos escenaBienvenidos) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.escenaBienvenidos= escenaBienvenidos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);

        this.informarTurnoProximoJugador();

    }

    private void informarTurnoProximoJugador() {

        Alert alertaProximoJugador = new Alert(Alert.AlertType.INFORMATION);
        alertaProximoJugador.initOwner(this.stage);
        alertaProximoJugador.setTitle("ATENCION");
        alertaProximoJugador.setHeaderText("Ahora juega: " + Juego.getInstance().getJugadorActual().getNombreJugador());
        alertaProximoJugador.showAndWait();

    }
}

