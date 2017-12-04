package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.vista.eventos.OpcionVenderPropiedadEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JugadoresRestantesVista extends VBox {


    private Image imagenJugador1;
    private Image imagenJugador2;
    private Image imagenJugador3;

    public JugadoresRestantesVista (){

        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);

        this.imagenJugador1 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_sombrero.png");
        this.imagenJugador2 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_auto.png");
        this.imagenJugador3 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_zapato.png");

    }

    public void setContenido(){

        Label jugadoresRestantes = new Label("JUGADORES RESTANTES");
        jugadoresRestantes.setTextFill(Color.web("#0066CC"));
        jugadoresRestantes.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

        this.getChildren().add(jugadoresRestantes);



        for (Jugador jugador : Juego.getInstance().getJugadores()) {

            HBox jugadorRestante = new HBox();
            VBox infoJugador = new VBox();
            jugadorRestante.setSpacing(5);
            jugadorRestante.setAlignment(Pos.CENTER);

            Label labelJugador = new Label(jugador.getNombreJugador());



            Image imagenJugador = this.imagenJugador3;

            if (jugador.getNombreJugador().equals("Jugador 1")){

                imagenJugador = this.imagenJugador1;
                labelJugador.setTextFill(Color.web("#CC0000"));
                labelJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

            }

            if (jugador.getNombreJugador().equals("Jugador 2")){

                imagenJugador = this.imagenJugador2;
                labelJugador.setTextFill(Color.web("#006600"));
                labelJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            }

            if (jugador.getNombreJugador().equals("Jugador 3")){

                imagenJugador = this.imagenJugador3;
                labelJugador.setTextFill(Color.web("#6600CC"));
                labelJugador.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

            }

            Button botonJugador = new Button();
            botonJugador.setPrefSize(40,31);
            MenuButton botonPropiedades = new MenuButton("Propiedades");
            botonPropiedades.setFont((Font.font("Verdana", FontWeight.BOLD, 10)));
            botonPropiedades.setStyle("-fx-base: #FFCCFF;");
            this.agregarPropiedadesDeAMenuPropiedades(jugador,botonPropiedades);
            BackgroundImage imagenFondo = new BackgroundImage(imagenJugador, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
            botonJugador.setBackground(new Background(imagenFondo));

            if (jugador.getPropiedades().isEmpty()){

                botonPropiedades.setDisable(true);

            }

            Label capital = new Label ("Capital: " + jugador.getCapital().getCantidad());
            capital.setTextFill(Color.web("#000000"));
            capital.setFont(Font.font("Verdana", FontWeight.BOLD, 10));


            this.getChildren().add(labelJugador);
            jugadorRestante.getChildren().addAll(botonJugador,capital);
            infoJugador.getChildren().addAll(jugadorRestante, botonPropiedades);

            this.getChildren().add(infoJugador);

            this.setSpacing(20);

        }

    }

    private void agregarPropiedadesDeAMenuPropiedades(Jugador unJugador, MenuButton botonPropiedades) {

        Jugador jugador = unJugador ;

        for ( Propiedad propiedad : jugador.getPropiedades() ) {

            MenuItem opcionVenderPropiedad = new MenuItem(propiedad.getNombre());

            botonPropiedades.getItems().add(opcionVenderPropiedad);

        }
    }

}
