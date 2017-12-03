package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.vista.eventos.BotonComenzarJuegoEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;


public class ContenedorBienvenidos extends BorderPane {


    private Stage stage;
    private MediaPlayer musica;


    public ContenedorBienvenidos(Stage stage, Scene proximaEscena, ContenedorPrincipal contenedorPrincipal) {

        super();

        this.stage = stage;

        reproducirMusica();

        Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/algopoly3.png");
        BackgroundSize backgroundSize = new BackgroundSize(200, 200, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        this.setBackground(new Background(imagenDeFondo));


        final Button botonComenzarJuego = new Button();
        botonComenzarJuego.setPrefSize(500, 250);


        Image imagenComenzarJuego = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/start1.png");
        BackgroundSize backgroundSizeComenzarJuego = new BackgroundSize(200, 200, true, true, true, false);
        BackgroundImage imagenDeFondoComenzarJuego = new BackgroundImage(imagenComenzarJuego, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeComenzarJuego);
        botonComenzarJuego.setBackground(new Background(imagenDeFondoComenzarJuego));

        final MotionBlur blur = new MotionBlur();

        botonComenzarJuego.addEventHandler(MouseEvent.MOUSE_ENTERED,
                e -> botonComenzarJuego.setEffect(blur));

        botonComenzarJuego.addEventHandler(MouseEvent.MOUSE_EXITED,
                e -> botonComenzarJuego.setEffect(null));


        BotonComenzarJuegoEventHandler nuevoJuegoHandler = new BotonComenzarJuegoEventHandler(stage, proximaEscena, contenedorPrincipal,this);
        botonComenzarJuego.setOnAction(nuevoJuegoHandler);


        this.setCenter(botonComenzarJuego);


    }

    private void reproducirMusica() {
        String pathMusicaDeFondo = Paths.get("src/fiuba/algo3/tp2/algopoly/vista/sonidos/SonidoBienvenida.mp3").toAbsolutePath().toUri().toString();
        Media musicaDeFondo = new Media(pathMusicaDeFondo);
        musica = new MediaPlayer(musicaDeFondo);

        musica.setAutoPlay(true);
        musica.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void pararMusica() {
        musica.stop();
    }
}