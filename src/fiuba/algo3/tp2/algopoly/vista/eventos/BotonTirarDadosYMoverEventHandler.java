package fiuba.algo3.tp2.algopoly.vista.eventos;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.AvanceDinamico;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorDados;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
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

        /*Alert alertaTiroDeDados = new Alert(Alert.AlertType.INFORMATION);
        alertaTiroDeDados.initOwner(stage);
        alertaTiroDeDados.setTitle("Tiro de dados");*/

        /*if (!jugadorActual.saltearTurno()){
            alertaTiroDeDados.setHeaderText("Ambos dados arrojaron el mismo numero y suman: " + tiro.resultado() + "\n" +
                    "Tenes turno doble!");
        }else {
            alertaTiroDeDados.setHeaderText("El resultado de la tirada de dados es: " + tiro.resultado());
        }

        alertaTiroDeDados.showAndWait();*/

        Stage stageDados = new Stage();
        stageDados.setTitle("Tiro de Dados");
        ContenedorDados contenedorDados = new ContenedorDados(stageDados);
        contenedorDados.setContenido(tiro);
        Scene escenaTiroDeDados = new Scene(contenedorDados,350,350);
        stageDados.setScene(escenaTiroDeDados);
        stageDados.showAndWait();

        try {

            Dinero capitalAntesDeMoverse = new Dinero(jugadorActual.getCapital().getCantidad());

            jugadorActual.mover(tiro.resultado());

            //jugadorActual.caerEn(Juego.getInstance().getTablero().obtenerCasilleroPorNombre("Carcel"));

            this.informarCaidaEnQuini6(jugadorActual,capitalAntesDeMoverse);

            this.informarCaidaEnCarcel(jugadorActual);

            this.informarCaidaEnPropiedad(jugadorActual,capitalAntesDeMoverse);

            this.informarCaidaEnImpuestoAlLujo(jugadorActual);

            //this.informarCaidaEnPolicia(jugadorActual);


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

                this.informarTurnoProximoJugador();

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

    private void informarTurnoProximoJugador() {

        Alert alertaProximoJugador = new Alert(Alert.AlertType.INFORMATION);
        alertaProximoJugador.initOwner(this.stage);
        alertaProximoJugador.setTitle("ATENCION");
        alertaProximoJugador.setHeaderText("Ahora juega: " + Juego.getInstance().getJugadorActual().getNombreJugador());
        alertaProximoJugador.showAndWait();

    }

    private void informarCaidaEnImpuestoAlLujo(Jugador jugadorActual) {

        if (jugadorActual.casilleroActual().getNombre().equals("Impuesto Al Lujo")){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en Impuesto Al Lujo y tu capital se reduce en un 10 %.");
            alertaJugadorPresoNoSePuedeMover.showAndWait();


        }


    }

    private void informarCaidaEnPropiedad(Jugador jugadorActual, Dinero capitalAntesDeMoverse) {

        Dinero capitalDespuesDeMoverse = jugadorActual.getCapital();

        if ( jugadorActual.casilleroActual().esPropiedad() ){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");

            if (capitalAntesDeMoverse.getCantidad() == capitalDespuesDeMoverse.getCantidad()) {

                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en la propiedad: " + jugadorActual.casilleroActual().getNombre() + "\n" + "pero no tenes que afrontar un gasto.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();


            }

            if (capitalAntesDeMoverse.getCantidad() != capitalDespuesDeMoverse.getCantidad()) {

                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en la propiedad: " + jugadorActual.casilleroActual().getNombre() + "\n" + "y tenes que afrontar el gasto.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();


            }

        }

    }

    private void informarCaidaEnPolicia(Jugador jugadorActual) {

        if (jugadorActual.casilleroActual().getNombre().equals("Policia")){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en Policia y te encierra en la Carcel!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();

        }

    }

    private void informarCaidaEnCarcel(Jugador jugadorActual) {

        if (jugadorActual.casilleroActual().getNombre().equals("Carcel")){

            Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
            alertaJugadorPresoNoSePuedeMover.initOwner(stage);
            alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
            alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en Carcel y ahora estas preso!");
            alertaJugadorPresoNoSePuedeMover.showAndWait();


        }



    }

    private void informarCaidaEnQuini6(Jugador jugadorActual, Dinero capitalAntesDeMoverse) {

        if (jugadorActual.casilleroActual().getNombre().equals("Quini 6")){

            if (jugadorActual.getCapital().getCantidad() == capitalAntesDeMoverse.getCantidad() ){

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("ATENCION");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en Quini 6 pero ya no podes ganar mas premios.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

            if (jugadorActual.getCapital().getCantidad() == capitalAntesDeMoverse.getCantidad() + 50000 ){

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("FELICITACIONES");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en Quini 6 y ganas 50000 pesos!.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

            if (jugadorActual.getCapital().getCantidad() == capitalAntesDeMoverse.getCantidad() + 30000 ){

                Alert alertaJugadorPresoNoSePuedeMover = new Alert(Alert.AlertType.INFORMATION);
                alertaJugadorPresoNoSePuedeMover.initOwner(stage);
                alertaJugadorPresoNoSePuedeMover.setTitle("FELICITACIONES");
                alertaJugadorPresoNoSePuedeMover.setHeaderText("Caes en Quini 6 y ganas 30000 pesos!.");
                alertaJugadorPresoNoSePuedeMover.showAndWait();

            }

        }
    }

}
