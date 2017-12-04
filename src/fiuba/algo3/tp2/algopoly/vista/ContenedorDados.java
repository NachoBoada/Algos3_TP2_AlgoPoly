package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
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

import java.util.ArrayList;

public class ContenedorDados extends BorderPane {

    Stage stage;
    VBox centro;
    ArrayList<Image> imagenes;


    public ContenedorDados(Stage stage){

        this.stage = stage;

        this.imagenes = new ArrayList<Image>();

        this.imagenes.add(new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/dado-1.png"));
        this.imagenes.add(new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/dado-2.png"));
        this.imagenes.add(new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/dado-3.png"));
        this.imagenes.add(new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/dado-4.png"));
        this.imagenes.add(new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/dado-5.png"));
        this.imagenes.add(new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/dado-6.png"));

    }


    public void setContenido(TiroDeDados tiro){

        this.centro = new VBox();
        this.centro.setAlignment(Pos.CENTER);
        this.centro.setSpacing(20);

        HBox dados = new HBox();
        dados.setAlignment(Pos.CENTER);
        dados.setSpacing(20);

        Button dado1 = new Button();
        dado1.setPrefSize(75,73);
        BackgroundImage imagenDado1 = new BackgroundImage(this.imagenes.get(tiro.getTiroUno() - 1), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        dado1.setBackground(new Background(imagenDado1));

        Button dado2 = new Button();
        dado2.setPrefSize(75,73);
        BackgroundImage imagenDado2 = new BackgroundImage(this.imagenes.get(tiro.geTiroDos() - 1), BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        dado2.setBackground(new Background(imagenDado2));

        Button botonAceptarYCerrarVentana = new Button("Aceptar");
        BotonAceptarYCerrarVentanaEventHandler botonAceptarTiroDadosEventHandler = new BotonAceptarYCerrarVentanaEventHandler(this.stage);
        botonAceptarYCerrarVentana.setOnAction(botonAceptarTiroDadosEventHandler);
        botonAceptarYCerrarVentana.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonAceptarYCerrarVentana.setStyle("-fx-base: #FF6666;");

        Label labelCantidadDeCasilleros = new Label();
        labelCantidadDeCasilleros.setText("Resultado: " + tiro.resultado());
        labelCantidadDeCasilleros.setTextFill(Color.web("#FF6666"));
        labelCantidadDeCasilleros.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        if(tiro.esDuplicado() && Juego.getInstance().getJugadorActual().getContadorTirosDuplicados() == 2){

            Label labelTiroDoble = new Label("Ambos dados arrojaron el mismo numero pero \n" +
                    "   no podes tener dos turnos dobles seguidos!");
            labelTiroDoble.setTextFill(Color.web("#FF6666"));
            labelTiroDoble.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
            this.centro.getChildren().addAll(dados,labelCantidadDeCasilleros,labelTiroDoble,botonAceptarYCerrarVentana);

        }


        if (tiro.esDuplicado() && Juego.getInstance().getJugadorActual().getContadorTirosDuplicados() == 1){


            Label labelTiroDoble = new Label("Ambos dados arrojaron el mismo numero y tenes turno doble!");
            labelTiroDoble.setTextFill(Color.web("#FF6666"));
            labelTiroDoble.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
            this.centro.getChildren().addAll(dados,labelCantidadDeCasilleros,labelTiroDoble,botonAceptarYCerrarVentana);


        }if(!tiro.esDuplicado()){


            this.centro.getChildren().addAll(dados,labelCantidadDeCasilleros,botonAceptarYCerrarVentana);

        }

        Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/fondo_paneles2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        dados.getChildren().addAll(dado1,dado2);

        this.setCenter(this.centro);

    }


}
