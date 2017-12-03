package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.estado.NoSePuedePagarFianzaEnEsteTurnoException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonPagarFianzaEventHandler implements EventHandler<ActionEvent>{


    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

    public BotonPagarFianzaEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();
        Encasillable casilleroActual = jugadorActual.casilleroActual();
        Tablero tablero = Juego.getInstance().getTablero();

        try {

            jugadorActual.pagarFianza();

            Alert alertaJugadorPagoFianza = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPagoFianza.initOwner(stage);
            alertaJugadorPagoFianza.setTitle("ATENCION");
            alertaJugadorPagoFianza.setHeaderText("Pago de fianza realizado. Ya sos libre otra vez!");
            alertaJugadorPagoFianza.showAndWait();

        }catch (NoSePuedePagarFianzaEnEsteTurnoException e){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.WARNING);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("No se puede pagar fianza en este turno.");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

        }catch (CapitalInsuficienteException e){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.WARNING);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("No tenes dinero para pagar la fianza.");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

        }

        this.contenedorPrincipal.jugadorNoComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();


    }
}
