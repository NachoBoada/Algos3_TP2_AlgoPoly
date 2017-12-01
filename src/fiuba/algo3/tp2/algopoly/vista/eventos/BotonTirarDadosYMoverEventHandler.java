package fiuba.algo3.tp2.algopoly.vista.eventos;

import com.sun.org.apache.bcel.internal.generic.ALOAD;
import fiuba.algo3.tp2.algopoly.model.ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.AvanceDinamico;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

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
        TiroDeDados tiro = jugadorActual.tirarDados();

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

            Juego.getInstance().turnoProximojugador();

        }catch (JugadorPresoNoSePuedeMoverException e){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.WARNING);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Estas preso y no te podes mover!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

            jugadorActual.caerEn(jugadorActual.casilleroActual());

            Juego.getInstance().turnoProximojugador();

        }catch (ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException e){

            Alert alertaJugadorDebeVenderPropiedades = new Alert(Alert.AlertType.WARNING);
            alertaJugadorDebeVenderPropiedades.initOwner(stage);
            alertaJugadorDebeVenderPropiedades.setTitle("ATENCION");
            alertaJugadorDebeVenderPropiedades.setHeaderText("Tenes que vender propiedades para afrontar el gasto.");
            alertaJugadorDebeVenderPropiedades.showAndWait();

            if ( jugadorActual.getPropiedades().isEmpty() ){

                Juego.getInstance().jugadorPierdeElJuego(jugadorActual);
                Alert alertaJugadorEliminado = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorEliminado.initOwner(stage);
                alertaJugadorEliminado.setTitle("ATENCION");
                alertaJugadorEliminado.setHeaderText(jugadorActual.getNombreJugador() + " perdiste porque no tenes dinero ni propiedades para afrontar el gasto!");
                alertaJugadorEliminado.showAndWait();

                Juego.getInstance().turnoProximojugador();

                this.contenedorPrincipal.jugadorNoComproPropiedad();

                this.contenedorPrincipal.setPanelIzquierdo();
                this.contenedorPrincipal.setPanelDerecho();
                this.contenedorPrincipal.setCentro();

            }

            this.contenedorPrincipal.jugadorTieneQueVender();

        }

        if (Juego.getInstance().finalizado()){

            Alert alertaJuegoFinalizado = new Alert(Alert.AlertType.CONFIRMATION );


            alertaJuegoFinalizado.initOwner(stage);
            alertaJuegoFinalizado.setTitle("Fin de Juego!");
            String jugadorGanador = Juego.getInstance().obtenerNombreJugadorGanador();
            alertaJuegoFinalizado.setHeaderText(jugadorGanador + " ha ganado el Juego \n Desea reiniciar el juego?");

            Optional<ButtonType> result = alertaJuegoFinalizado.showAndWait();
            if (result.get() == ButtonType.OK){
                Juego.getInstance().comenzarJuego(100000);
                this.contenedorPrincipal.jugadorNoComproPropiedad();

                this.contenedorPrincipal.setPanelIzquierdo();
                this.contenedorPrincipal.setPanelDerecho();
                this.contenedorPrincipal.setCentro();
            } else {
                System.exit(0);
            }

        }

        this.contenedorPrincipal.jugadorNoComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

    }

}
