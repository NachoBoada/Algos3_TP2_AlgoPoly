package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.vista.ContenedorBienvenidos;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.algopoly.vista.ContenedorProximoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComenzarJuegoEventHandler implements EventHandler<ActionEvent> {

    private final ContenedorPrincipal contenedorPrincipal;
    private Stage stage;
    private Scene proximaEscena;
    private ContenedorBienvenidos contenedorBienvenidos;

    public BotonComenzarJuegoEventHandler(Stage stage, Scene proximaEscena, ContenedorPrincipal contenedorPrincipal, ContenedorBienvenidos contenedorBienvenidos) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.contenedorPrincipal = contenedorPrincipal;
        this.contenedorBienvenidos= contenedorBienvenidos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedorBienvenidos.pararMusica();
        contenedorPrincipal.reproducirMusica();

        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);

        this.informarTurnoProximoJugador();

    }

    private void informarTurnoProximoJugador() {

        this.contenedorPrincipal.deshabilitarTirarYMover();

        Stage stageProximoJugador = new Stage();
        stageProximoJugador.setTitle("Proximo jugador");
        ContenedorProximoJugador contenedorProximoJugador = new ContenedorProximoJugador(stageProximoJugador,this.contenedorPrincipal);
        contenedorProximoJugador.setContenido();
        Scene escenaProximoJugador = new Scene(contenedorProximoJugador,300,200);
        stageProximoJugador.setScene(escenaProximoJugador);
        stageProximoJugador.initOwner(this.stage);
        stageProximoJugador.showAndWait();

    }
}

