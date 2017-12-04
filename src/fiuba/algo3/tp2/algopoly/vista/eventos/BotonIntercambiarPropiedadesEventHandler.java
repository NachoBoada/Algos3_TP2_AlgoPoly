package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BotonIntercambiarPropiedadesEventHandler implements EventHandler<ActionEvent> {


    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

    public BotonIntercambiarPropiedadesEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent event) {


        Stage stagePropiedades = new Stage();
        stagePropiedades.setTitle("Intercambio de propiedades");

        HBox centro = new HBox();
        centro.setAlignment(Pos.CENTER);
        centro.setSpacing(20);

        Juego juego = Juego.getInstance();

        for (Jugador jugador : juego.getJugadores()) {

            if( !jugador.equals(juego.getJugadorActual()) ) {

                MenuButton menuJugador = new MenuButton("Propiedades de \n" + jugador.getNombreJugador());
                menuJugador.setTextAlignment(TextAlignment.CENTER);
                menuJugador.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
                menuJugador.setStyle("-fx-base: #99FF99;");

                for (Propiedad propiedad : jugador.getPropiedades()) {

                    MenuItem opcionPropiedad = new MenuItem(propiedad.getNombre());
                    OpcionIntercambiarPropiedadEventHandler opcionPropiedadEventHandler = new OpcionIntercambiarPropiedadEventHandler(stage, propiedad);
                    opcionPropiedad.setOnAction(opcionPropiedadEventHandler);

                    menuJugador.getItems().add(opcionPropiedad);
                }

                centro.getChildren().add(menuJugador);
            }
        }


        stagePropiedades.setScene(new Scene(centro, 350, 150));
        stagePropiedades.initOwner(this.stage);
        stagePropiedades.showAndWait();

    }
}
