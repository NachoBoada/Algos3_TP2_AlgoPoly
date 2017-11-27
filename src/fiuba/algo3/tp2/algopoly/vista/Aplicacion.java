package fiuba.algo3.tp2.algopoly.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.tp2.algopoly.vista.eventos.*;

public class Aplicacion extends Application {


    final static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("ALGOPOLY");

       //Juego.getInstance().comenzarJuego();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640 , 480);


        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage,escenaJuego);
        Scene escenaTitulo = new Scene(contenedorBienvenidos,1200,600);

        stage.setScene(escenaTitulo);
        stage.setFullScreen(true);

        stage.show();

    }
}