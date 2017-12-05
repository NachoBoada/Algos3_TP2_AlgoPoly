package fiuba.algo3.tp2.algopoly.vista;


import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.vista.eventos.BotonAceptarYCerrarVentanaEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorProximoJugador extends BorderPane{


    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;
    private VBox centro;
    private Image piezaJugador1;
    private Image piezaJugador2;
    private Image piezaJugador3;

    public ContenedorProximoJugador(Stage stageProximoJugador, ContenedorPrincipal contenedorPrincipal) {

        this.stage = stageProximoJugador;
        this.contenedorPrincipal = contenedorPrincipal;

        this.piezaJugador1 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_sombrero.png");
        this.piezaJugador2 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_auto.png");
        this.piezaJugador3 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_zapato.png");

    }

    public void setContenido() {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        this.centro = new VBox();
        this.centro.setAlignment(Pos.CENTER);
        this.centro.setSpacing(20);

        HBox jugador = new HBox();
        jugador.setAlignment(Pos.CENTER);
        jugador.setSpacing(20);

        Button botonAceptarYCerrarVentana = new Button("Aceptar");
        BotonAceptarYCerrarVentanaEventHandler botonAceptarTiroDadosEventHandler = new BotonAceptarYCerrarVentanaEventHandler(this.stage,this.contenedorPrincipal);
        botonAceptarYCerrarVentana.setOnAction(botonAceptarTiroDadosEventHandler);
        botonAceptarYCerrarVentana.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonAceptarYCerrarVentana.setStyle("-fx-base: #0066CC;");

        Label labelProximo = new Label("AHORA JUEGA");
        labelProximo.setTextFill(Color.web("#0066CC"));
        labelProximo.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Label labelJugador = new Label(Juego.getInstance().getJugadorActual().getNombreJugador());

        Image imagenJugador = this.piezaJugador3;
        labelJugador.setTextFill(Color.web("#6600CC"));
        labelJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 12));


        if (jugadorActual.getNombreJugador().equals("Jugador 1")){

            imagenJugador = this.piezaJugador1;
            labelJugador.setTextFill(Color.web("#CC0000"));
            labelJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        }

        if (jugadorActual.getNombreJugador().equals("Jugador 2")){

            imagenJugador = this.piezaJugador2;
            labelJugador.setTextFill(Color.web("#006600"));
            labelJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        }

        Button botonJugador = new Button();
        botonJugador.setPrefSize(40,31);
        BackgroundImage imagenFondo = new BackgroundImage(imagenJugador, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        botonJugador.setBackground(new Background(imagenFondo));

        jugador.getChildren().addAll(labelJugador,botonJugador);

        this.centro.getChildren().addAll(labelProximo,jugador,botonAceptarYCerrarVentana);

        this.setCenter(this.centro);

        Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/fondo_paneles2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

    }
}
