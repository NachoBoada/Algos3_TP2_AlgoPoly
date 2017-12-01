package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class JugadoresRestantesVista extends VBox {


    private Image imagenJugador1;
    private Image imagenJugador2;
    private Image imagenJugador3;

    public JugadoresRestantesVista (){

        this.setPadding(new Insets(10));

        this.imagenJugador1 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_sombrero.png");
        this.imagenJugador2 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_auto.png");
        this.imagenJugador3 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_zapato.png");

    }

    public void setContenido(){

        Label jugadoresRestantes = new Label("Jugadores Restantes");

        this.getChildren().add(jugadoresRestantes);


        for (Jugador jugador : Juego.getInstance().getJugadores()) {

            HBox jugadorRestante = new HBox();

            Label labelJugador = new Label(jugador.getNombreJugador());

            if (jugador.getNombreJugador().equals("Jugador 1")){

                Image imagenJugador = this.imagenJugador1;

                Button botonJugador1 = new Button();
                botonJugador1.setPrefSize(40,31);
                BackgroundImage imagenFondo = new BackgroundImage(imagenJugador, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                botonJugador1.setBackground(new Background(imagenFondo));

                Label capital = new Label ("Capital: " + jugador.getCapital().getCantidad());

                jugadorRestante.getChildren().addAll(labelJugador,botonJugador1,capital);

            }

            if (jugador.getNombreJugador().equals("Jugador 2")){

                Image imagenJugador = this.imagenJugador2;

                Button botonJugador2 = new Button();
                botonJugador2.setPrefSize(40,31);
                BackgroundImage imagenFondo = new BackgroundImage(imagenJugador, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                botonJugador2.setBackground(new Background(imagenFondo));

                jugadorRestante.getChildren().addAll(labelJugador,botonJugador2);

            }


            if (jugador.getNombreJugador().equals("Jugador 3")){

                Image imagenJugador = this.imagenJugador3;

                Button botonJugador3 = new Button();
                botonJugador3.setPrefSize(40,31);
                BackgroundImage imagenFondo = new BackgroundImage(imagenJugador, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                botonJugador3.setBackground(new Background(imagenFondo));

                jugadorRestante.getChildren().addAll(labelJugador,botonJugador3);

            }






            this.getChildren().add(jugadorRestante);

            this.setSpacing(20);


        }



    }










}
