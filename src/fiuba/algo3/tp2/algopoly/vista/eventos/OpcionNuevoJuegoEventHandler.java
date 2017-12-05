package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.algopoly.vista.ContenedorProximoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class OpcionNuevoJuegoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;

    public OpcionNuevoJuegoEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.stage =stage;
        this.contenedorPrincipal = contenedorPrincipal;

    }

    @Override
    public void handle(ActionEvent event) {


        Alert alertaNuevoJuego = new Alert(Alert.AlertType.CONFIRMATION);

        alertaNuevoJuego.initOwner(stage);
        alertaNuevoJuego.setTitle("Nuevo juego");
        alertaNuevoJuego.setHeaderText("Seguro que queres empezar un nuevo juego?");

        Optional<ButtonType> result = alertaNuevoJuego.showAndWait();
        if (result.get() == ButtonType.OK) {

            Juego.getInstance().comenzarJuego(100000);
            this.contenedorPrincipal.jugadorNoComproPropiedad();

            this.contenedorPrincipal.setPanelIzquierdo();
            this.contenedorPrincipal.setPanelDerecho();
            this.contenedorPrincipal.setCentro();

            this.informarTurnoProximoJugador();
        }

    }

    private void informarTurnoProximoJugador() {

        Stage stageProximoJugador = new Stage();
        stageProximoJugador.setTitle("Proximo jugador");
        ContenedorProximoJugador contenedorProximoJugador = new ContenedorProximoJugador(stageProximoJugador,this.contenedorPrincipal);
        contenedorProximoJugador.setContenido();
        Scene escenaProximoJugador = new Scene(contenedorProximoJugador, 375, 200);
        stageProximoJugador.setScene(escenaProximoJugador);
        stageProximoJugador.initOwner(this.stage);
        stageProximoJugador.showAndWait();

    }
}
