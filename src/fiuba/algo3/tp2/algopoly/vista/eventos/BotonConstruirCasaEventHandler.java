package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruirException;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.NoSePermiteConstruirMasDeDosCasasEnBarrioDivididoException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;

public class BotonConstruirCasaEventHandler implements EventHandler<ActionEvent>{

    private ContenedorPrincipal contenedorPrincipal;
    private Stage stage;

    public BotonConstruirCasaEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }


    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();
        Encasillable casilleroActual = jugadorActual.casilleroActual();
        Tablero tablero = Juego.getInstance().getTablero();
        Barrio barrio = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());

        try{

            jugadorActual.construirCasaEn(barrio);

            this.informarConstruccionRealizada(jugadorActual);

        }catch (JugadorDebeComprarElBarrioParaPoderConstruirException e){

            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("Tenes que comprar el barrio para poder construir una casa.");
            alertaBarrioNoComprado.showAndWait();

        }catch (JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException e){

            Alert alertaBarriosNoComprados = new Alert(Alert.AlertType.WARNING);
            alertaBarriosNoComprados.initOwner(stage);
            alertaBarriosNoComprados.setTitle("ATENCION");
            alertaBarriosNoComprados.setHeaderText("Tenes que comprar los dos barrios de la region para poder construir una casa.");
            alertaBarriosNoComprados.showAndWait();

        }catch (CapitalInsuficienteException e){

            Alert alertaCapitalInsuficienteParaConstruirCasa = new Alert(Alert.AlertType.WARNING);
            alertaCapitalInsuficienteParaConstruirCasa.initOwner(stage);
            alertaCapitalInsuficienteParaConstruirCasa.setTitle("ATENCION");
            alertaCapitalInsuficienteParaConstruirCasa.setHeaderText("No tenes dinero suficiente para construir una casa.");
            alertaCapitalInsuficienteParaConstruirCasa.showAndWait();

        }catch (NoSePermiteConstruirMasDeUnaCasaEnBarrioSimpleException e) {

            Alert alertaBarrioCompletoDeHoteles = new Alert(Alert.AlertType.WARNING);
            alertaBarrioCompletoDeHoteles.initOwner(stage);
            alertaBarrioCompletoDeHoteles.setTitle("ATENCION");
            alertaBarrioCompletoDeHoteles.setHeaderText("Esta propiedad ya tiene capacidad maxima de casas");
            alertaBarrioCompletoDeHoteles.showAndWait();
        }catch (NoSePermiteConstruirMasDeDosCasasEnBarrioDivididoException e) {

            Alert alertaBarrioCompletoDeHoteles = new Alert(Alert.AlertType.WARNING);
            alertaBarrioCompletoDeHoteles.initOwner(stage);
            alertaBarrioCompletoDeHoteles.setTitle("ATENCION");
            alertaBarrioCompletoDeHoteles.setHeaderText("Esta propiedad ya tiene capacidad maxima de casas");
            alertaBarrioCompletoDeHoteles.setContentText("Puede intentar construir un Hotel aqui");
            alertaBarrioCompletoDeHoteles.showAndWait();
        }

        this.contenedorPrincipal.jugadorNoComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();



    }

    private void informarConstruccionRealizada(Jugador jugador) {

        String pathCajaRegistradora = Paths.get("src/fiuba/algo3/tp2/algopoly/vista/sonidos/sonidoCajaRegistradora.mp3").toAbsolutePath().toUri().toString();
        Media cajaRegistradora = new Media(pathCajaRegistradora);
        MediaPlayer sonidoCaja = new MediaPlayer(cajaRegistradora);
        sonidoCaja.setAutoPlay(true);

        String pathSonidoConstruccion = Paths.get("src/fiuba/algo3/tp2/algopoly/vista/sonidos/sonidoConstruccion.mp3").toAbsolutePath().toUri().toString();
        Media construccion = new Media(pathSonidoConstruccion);
        MediaPlayer sonidoConstruccion = new MediaPlayer(construccion);
        sonidoConstruccion.setAutoPlay(true);
        Duration duracionInicio = new Duration(3000);
        Duration duracionFin = new Duration(5000);
        sonidoConstruccion.setStartTime(duracionInicio);
        sonidoConstruccion.setStopTime(duracionFin);

        Alert alertaConstruccionRealizada = new Alert(Alert.AlertType.INFORMATION);
        alertaConstruccionRealizada.initOwner(stage);
        alertaConstruccionRealizada.setTitle("Construccion");
        alertaConstruccionRealizada.setHeaderText("La construccion de la casa fue realizada.");
        alertaConstruccionRealizada.setContentText("Ahora tu capital es de: " + jugador.getCapital().getCantidad());
        alertaConstruccionRealizada.showAndWait();
    }
}
