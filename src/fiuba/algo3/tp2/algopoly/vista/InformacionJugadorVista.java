package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InformacionJugadorVista extends VBox{



        InformacionJugadorVista() {

            Jugador jugadorActual= Juego.getInstance().getJugadorActual();
            int cantidad= jugadorActual.getCantidadDePropiedadesParaMovimientoDinamico();

            Label infoJugadorActual = new Label("Informacion jugador actual:");
            infoJugadorActual.setLineSpacing(300);

            Label nombre = new Label( "Nombre: "+ jugadorActual.getNombreJugador());
            nombre.setLineSpacing(300);

            Label capital = new Label("Capital disponible: " + jugadorActual.getCapital().getCantidad());
            capital.setLineSpacing(300);

            Label posicion = new Label( "Posicion actual:" + jugadorActual.getPosicionActual());
            posicion.setLineSpacing(300);

            Label propiedades = new Label( "Propiedades:");
            propiedades.setLineSpacing(300);


            Label estado = new Label("Estado: "+ jugadorActual.getEstado());
            estado.setLineSpacing(300);

            this.getChildren().add(infoJugadorActual);
            this.getChildren().add(nombre);
            this.getChildren().add(capital);
            this.getChildren().add(posicion);
            this.getChildren().add(estado);
            this.getChildren().add(propiedades);


            for (Propiedad apropiable : jugadorActual.getPropiedades()) {

                Label propiedad = new Label("\t" + apropiable.getNombre());
                propiedad.setLineSpacing(100);
                this.getChildren().add(propiedad);

            }

        }
}
