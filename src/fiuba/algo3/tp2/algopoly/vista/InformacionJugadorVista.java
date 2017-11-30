package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InformacionJugadorVista extends VBox{



        InformacionJugadorVista() {

            Jugador jugadorActual= Juego.getInstance().getJugadorActual();
            int cantidad= jugadorActual.getCantidadDePropiedadesParaMovimientoDinamico();

            Label infoJugadorActual = new Label("Informacion jugador actual:");
            infoJugadorActual.setLineSpacing(100);

            Label nombre = new Label( "Nombre: "+ jugadorActual.getNombreJugador());
            nombre.setLineSpacing(100);

            Label capital = new Label("Capital disponible: " + jugadorActual.getCapital().getCantidad());
            capital.setLineSpacing(100);

            Label posicion = new Label( "Posicion actual:" + jugadorActual.getPosicionActual());
            posicion.setLineSpacing(100);

            Label propiedades = new Label( "Propiedades:");
            propiedades.setLineSpacing(100);


            Label estado = new Label("Estado: "+ jugadorActual.getEstado());
            estado.setLineSpacing(100);

            this.getChildren().add(infoJugadorActual);
            this.getChildren().add(nombre);
            this.getChildren().add(capital);
            this.getChildren().add(posicion);
            this.getChildren().add(estado);
            this.getChildren().add(propiedades);


            for (Apropiable apropiable : jugadorActual.getPropiedades()) {

                Label propiedad = new Label("\t" + apropiable.getNombre());
                propiedad.setLineSpacing(100);
                this.getChildren().add(propiedad);

            }

        }
}
