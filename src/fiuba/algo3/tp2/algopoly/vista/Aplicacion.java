package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import javafx.application.Application;
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





    }
}
