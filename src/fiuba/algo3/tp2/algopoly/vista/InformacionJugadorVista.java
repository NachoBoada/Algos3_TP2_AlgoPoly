package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InformacionJugadorVista extends VBox{



        InformacionJugadorVista() {

            Jugador jugadorActual= Juego.getInstance().getJugadorActual();
            int cantidad= jugadorActual.getCantidadDePropiedadesParaMovimientoDinamico();

            this.setSpacing(10);

            Label infoJugadorActual = new Label("INFORMACION DE JUGADOR ACTUAL");
            infoJugadorActual.setTextFill(Color.web("#0066CC"));
            infoJugadorActual.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
            infoJugadorActual.setLineSpacing(300);

            Label nombre = new Label( jugadorActual.getNombreJugador());
            nombre.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            nombre.setLineSpacing(300);


            if (jugadorActual.getNombreJugador().equals("Jugador 1")){

                nombre.setTextFill(Color.web("#CC0000"));

            }

            if (jugadorActual.getNombreJugador().equals("Jugador 2")){

                nombre.setTextFill(Color.web("#006600"));

            }

            if (jugadorActual.getNombreJugador().equals("Jugador 3")){

                nombre.setTextFill(Color.web("#6600CC"));

            }



            Label capital = new Label("Capital disponible: " + jugadorActual.getCapital().getCantidad());
            capital.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            capital.setLineSpacing(300);

            Label posicion = new Label( "Posicion actual:" + jugadorActual.getPosicionActual());
            posicion.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            posicion.setLineSpacing(300);

            Label propiedades = new Label( "Propiedades:");
            propiedades.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            propiedades.setLineSpacing(300);


            Label estado = new Label("Estado: "+ jugadorActual.getEstado());
            estado.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
            estado.setLineSpacing(300);

            this.getChildren().add(infoJugadorActual);
            this.getChildren().add(nombre);
            this.getChildren().add(capital);
            this.getChildren().add(posicion);
            this.getChildren().add(estado);
            this.getChildren().add(propiedades);
            this.setAlignment(Pos.CENTER);


            if (jugadorActual.getPropiedades().isEmpty()){

                Label propiedad = new Label("No tiene");
                propiedad.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
                propiedad.setLineSpacing(100);
                this.getChildren().add(propiedad);



            }

            for (Propiedad apropiable : jugadorActual.getPropiedades()) {

                Label propiedad = new Label("\t" + apropiable.getNombre());
                propiedad.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
                propiedad.setLineSpacing(100);
                this.getChildren().add(propiedad);

            }



        }
}
