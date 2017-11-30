package fiuba.algo3.tp2.algopoly.vista.eventos;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonTirarDadosYMoverEventHandler implements EventHandler<ActionEvent> {

    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

    public BotonTirarDadosYMoverEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }



    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        TiroDeDados tiro = Juego.getInstance().getJugadorActual().tirarDados();

        Alert alertaTiroDeDados = new Alert(Alert.AlertType.INFORMATION);
        alertaTiroDeDados.initOwner(stage);
        alertaTiroDeDados.setTitle("Tiro de dados");

        if (!jugadorActual.saltearTurno()){
            alertaTiroDeDados.setHeaderText("Ambos dados arrijaron el mismo numero y suman: " + tiro.resultado() + "\n" +
                    "Podes volver a jugar!");
        }else {
            alertaTiroDeDados.setHeaderText("El resultado de la tirada de dados es: " + tiro.resultado());
        }

        alertaTiroDeDados.showAndWait();

        try {

            jugadorActual.mover(tiro.resultado());

        }catch (JugadorPresoNoSePuedeMoverException e){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.WARNING);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Estas preso y no te podes mover!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

            jugadorActual.caerEn(jugadorActual.casilleroActual());

        }

        Juego.getInstance().turnoProximojugador();

        this.contenedorPrincipal.jugadorNoComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

    }
}
