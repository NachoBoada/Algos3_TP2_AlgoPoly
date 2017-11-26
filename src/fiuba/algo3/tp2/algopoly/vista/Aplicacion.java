package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.vista.eventos.AplicacionOnKeyPressEventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {


    final static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("ALGOPOLY");

        // Juego.getInstance().comenzarJuego();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640 , 480);

        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        stage.setScene(escenaJuego);
        stage.setFullScreen(true);

        stage.show();

    }
}
