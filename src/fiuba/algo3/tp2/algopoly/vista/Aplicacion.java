package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.tp2.algopoly.vista.eventos.*;

public class Aplicacion extends Application {

    private static final double capitalInicial = 100000;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("ALGOPOLY");

        double capitalInicialDeJugadores = capitalInicial;

        Juego.getInstance().comenzarJuego(capitalInicialDeJugadores);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640 , 480);


        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, contenedorPrincipal);
        Scene escenaTitulo = new Scene(contenedorBienvenidos,1200,600);

        stage.setScene(escenaTitulo);
        stage.setFullScreen(true);

        stage.show();

    }
}
