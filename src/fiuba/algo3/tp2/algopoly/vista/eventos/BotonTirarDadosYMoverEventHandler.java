package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorDados;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.algopoly.vista.ContenedorProximoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

import java.util.Optional;

public class BotonTirarDadosYMoverEventHandler implements EventHandler<ActionEvent> {

    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

    public BotonTirarDadosYMoverEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();
        TiroDeDados tiro = jugadorActual.tirarDados();


        Stage stageDados = new Stage();
        stageDados.setTitle("Tiro de Dados");
        ContenedorDados contenedorDados = new ContenedorDados(stageDados);
        contenedorDados.setContenido(tiro);
        Scene escenaTiroDeDados = new Scene(contenedorDados, 450, 250);
        stageDados.setScene(escenaTiroDeDados);
        stageDados.initOwner(this.stage);
        stageDados.showAndWait();

        try {

            Dinero capitalAntesDeMoverse = new Dinero(jugadorActual.getCapital().getCantidad());

            jugadorActual.mover(tiro.resultado());

            //jugadorActual.caerEn(Juego.getInstance().getTablero().obtenerCasilleroPorNombre("Tucuman"));

            this.informarCaidaEnPolicia(jugadorActual);

            this.informarCaidaEnRetrocesoDinamico(jugadorActual);

            this.informarCaidaEnAvanceDinamico(jugadorActual);

            this.informarCaidaEnQuini6(jugadorActual, capitalAntesDeMoverse);

            this.informarCaidaEnCarcel(jugadorActual);

            this.informarCaidaEnPropiedad(jugadorActual, capitalAntesDeMoverse);

            this.informarCaidaEnImpuestoAlLujo(jugadorActual);


            Juego.getInstance().turnoProximojugador();


        } catch (JugadorPresoNoSePuedeMoverException e) {

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.WARNING);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Estas preso y no te podes mover!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

            jugadorActual.caerEn(jugadorActual.casilleroActual());

            Juego.getInstance().turnoProximojugador();


        } catch (ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException e) {

            Alert alertaJugadorDebeVenderPropiedades = new Alert(Alert.AlertType.WARNING);
            alertaJugadorDebeVenderPropiedades.initOwner(stage);
            alertaJugadorDebeVenderPropiedades.setTitle("ATENCION");
            alertaJugadorDebeVenderPropiedades.setHeaderText("Caiste en la propiedad: " + jugadorActual.casilleroActual().getNombre() +
                    " y no tenes dinero en efectivo. ");
            alertaJugadorDebeVenderPropiedades.setContentText("Tenes que vender propiedades para afrontar el gasto.");
            alertaJugadorDebeVenderPropiedades.showAndWait();

            if (jugadorActual.getPropiedades().isEmpty()) {

                Juego.getInstance().jugadorPierdeElJuego(jugadorActual);

                Alert alertaJugadorEliminado = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorEliminado.initOwner(stage);
                alertaJugadorEliminado.setTitle("ATENCION");
                alertaJugadorEliminado.setHeaderText(jugadorActual.getNombreJugador() + " perdiste porque no tenes dinero ni propiedades para afrontar el gasto!");
                alertaJugadorEliminado.showAndWait();

                //Juego.getInstance().turnoProximojugador();

                this.contenedorPrincipal.jugadorNoComproPropiedad();

                this.contenedorPrincipal.setPanelIzquierdo();
                this.contenedorPrincipal.setPanelDerecho();
                this.contenedorPrincipal.setCentro();

                this.informarTurnoProximoJugador();

            }

            this.contenedorPrincipal.jugadorTieneQueVender();

        }

        if (Juego.getInstance().finalizado()) {

            Alert alertaJuegoFinalizado = new Alert(Alert.AlertType.CONFIRMATION);


            alertaJuegoFinalizado.initOwner(stage);
            alertaJuegoFinalizado.setTitle("Fin de Juego!");
            String jugadorGanador = Juego.getInstance().obtenerNombreJugadorGanador();
            alertaJuegoFinalizado.setHeaderText(jugadorGanador + " ha ganado el Juego \n Desea reiniciar el juego?");

            Optional<ButtonType> result = alertaJuegoFinalizado.showAndWait();
            if (result.get() == ButtonType.OK) {
                Juego.getInstance().comenzarJuego(100000);
                this.contenedorPrincipal.jugadorNoComproPropiedad();

                this.contenedorPrincipal.setPanelIzquierdo();
                this.contenedorPrincipal.setPanelDerecho();
                this.contenedorPrincipal.setCentro();

                this.informarTurnoProximoJugador();
            } else {
                System.exit(0);
            }

        }

        this.contenedorPrincipal.jugadorNoComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

        this.informarTurnoProximoJugador();

    }

    private void informarCaidaEnRetrocesoDinamico(Jugador jugador) {
        if (jugador.retrocedioDinamicamente()) {

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Retroceso Dinamico!");
            alertaJugadorPresoNoSePuedeMover.setContentText("Vaya a dar un paseo por " + jugador.casilleroActual().getNombre());
            alertaJugadorPresoNoSePuedeMover.showAndWait();

        }
    }

    private void informarCaidaEnAvanceDinamico(Jugador jugador) {
        if (jugador.avanzoDinamicamente()) {

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Avance Dinamico!");
            alertaJugadorPresoNoSePuedeMover.setContentText("Vaya a dar un paseo por " + jugador.casilleroActual().getNombre());
            alertaJugadorPresoNoSePuedeMover.showAndWait();

        }
    }

    private void informarTurnoProximoJugador() {

        /*Alert alertaProximoJugador = new Alert(Alert.AlertType.INFORMATION);
        alertaProximoJugador.initOwner(this.stage);
        alertaProximoJugador.setTitle("ATENCION");
        alertaProximoJugador.setHeaderText("Ahora juega: " + Juego.getInstance().getJugadorActual().getNombreJugador());
        alertaProximoJugador.showAndWait();*/

        Stage stageProximoJugador = new Stage();
        stageProximoJugador.setTitle("Proximo jugador");
        ContenedorProximoJugador contenedorProximoJugador = new ContenedorProximoJugador(stageProximoJugador);
        contenedorProximoJugador.setContenido();
        Scene escenaProximoJugador = new Scene(contenedorProximoJugador, 375, 200);
        stageProximoJugador.setScene(escenaProximoJugador);
        stageProximoJugador.initOwner(this.stage);
        stageProximoJugador.showAndWait();

        if (Juego.getInstance().getJugadorActual().casilleroActual().getNombre().equals("Carcel")) {

            this.informarSalidaDeLaCarcel();

        }


    }

    private void informarSalidaDeLaCarcel() {

        if (Juego.getInstance().getJugadorActual().getEstado().equals("Libre")) {

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.WARNING);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Ya cumpliste tu condena, estas libre!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();


        }

    }

    private void informarCaidaEnImpuestoAlLujo(Jugador jugadorActual) {

        if (jugadorActual.casilleroActual().getNombre().equals("Impuesto Al Lujo")) {

            Alert alertaJugadorCaeEnImpuestoAlLujo = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorCaeEnImpuestoAlLujo.initOwner(stage);
            alertaJugadorCaeEnImpuestoAlLujo.setTitle("ATENCION");
            alertaJugadorCaeEnImpuestoAlLujo.setHeaderText("Caiste en Impuesto Al Lujo!");
            alertaJugadorCaeEnImpuestoAlLujo.setContentText("Tu capital se reduce en un 10% y ahora es de: " + jugadorActual.getCapital().getCantidad());
            alertaJugadorCaeEnImpuestoAlLujo.showAndWait();

        }


    }

    private void informarCaidaEnPropiedad(Jugador jugadorActual, Dinero capitalAntesDeMoverse) {

        Dinero capitalDespuesDeMoverse = jugadorActual.getCapital();

        if (jugadorActual.casilleroActual().esPropiedad()) {

            Alert alertaJugadorCaeEnPropiedad = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorCaeEnPropiedad.initOwner(stage);
            alertaJugadorCaeEnPropiedad.setTitle("ATENCION");

            if (capitalAntesDeMoverse.getCantidad() == capitalDespuesDeMoverse.getCantidad()) {

                alertaJugadorCaeEnPropiedad.setHeaderText("Caiste en la propiedad: " + jugadorActual.casilleroActual().getNombre());
                alertaJugadorCaeEnPropiedad.setContentText("No tenes que afrontar un gasto.");
                alertaJugadorCaeEnPropiedad.showAndWait();


            }

            if (capitalAntesDeMoverse.getCantidad() != capitalDespuesDeMoverse.getCantidad()) {

                alertaJugadorCaeEnPropiedad.setHeaderText("Caiste en la propiedad: " + jugadorActual.casilleroActual().getNombre());
                alertaJugadorCaeEnPropiedad.setContentText("Afrontaste el gasto y ahora tu capital es de: " + jugadorActual.getCapital().getCantidad());
                alertaJugadorCaeEnPropiedad.showAndWait();

            }

        }

    }

    private void informarCaidaEnPolicia(Jugador jugadorActual) {

        if (jugadorActual.fueDetenido()) {

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Policia!");
            alertaJugadorPresoNoSePuedeMover.setContentText("Vayase directo a la carcel!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

        }

    }

    private void informarCaidaEnCarcel(Jugador jugadorActual) {

        if (jugadorActual.casilleroActual().getNombre().equals("Carcel")) {


            if (jugadorActual.getEstado().equals("Preso")) {

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Carcel y ahora estas preso!");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

        }


    }

    private void informarCaidaEnQuini6(Jugador jugadorActual, Dinero capitalAntesDeMoverse) {

        if (jugadorActual.casilleroActual().getNombre().equals("Quini 6")) {

            if (jugadorActual.getCapital().getCantidad() == capitalAntesDeMoverse.getCantidad()) {

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Quini 6 pero ya no podes ganar mas premios.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

            if (jugadorActual.getCapital().getCantidad() == capitalAntesDeMoverse.getCantidad() + 50000) {

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("FELICITACIONES");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Quini 6 y ganaste 50000 pesos!.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

            if (jugadorActual.getCapital().getCantidad() == capitalAntesDeMoverse.getCantidad() + 30000) {

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("FELICITACIONES");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caiste en Quini 6 y ganaste 30000 pesos!.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

        }
    }

}
