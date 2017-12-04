package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruirException;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirHotelSiNoSeConstruyeElMaximoNumeroDeCasasException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.NoSePermiteConstruirMasDeUnHotelEnBarrioDivididoException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.NoSePuedeConstruirUnHotelEnUnBarrioSimpleException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.nio.file.Paths;

public class BotonConstruirHotelEventHandler implements EventHandler<ActionEvent>{


    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

    public BotonConstruirHotelEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent event) {

        Jugador jugador = Juego.getInstance().getJugadorActual();
        Encasillable casilleroActual = jugador.casilleroActual();
        Tablero tablero = Juego.getInstance().getTablero();
        Barrio barrio = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());

        try{

            jugador.construirHotelEn(barrio);

            this.informarConstruccionRealizada(jugador);

        }catch (NoSePuedeConstruirUnHotelEnUnBarrioSimpleException e){

            Alert alertaBarrioSimpleNoAceptaHotel = new Alert(Alert.AlertType.WARNING);
            alertaBarrioSimpleNoAceptaHotel.initOwner(stage);
            alertaBarrioSimpleNoAceptaHotel.setTitle("ATENCION");
            alertaBarrioSimpleNoAceptaHotel.setHeaderText("No se puede construir un hotel en este barrio.");
            alertaBarrioSimpleNoAceptaHotel.showAndWait();

        }catch (JugadorNoPuedeConstruirHotelSiNoSeConstruyeElMaximoNumeroDeCasasException e){

            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("No se puede contruir un hotel si no construis el maximo numero de casas en cada barrio de la region.");
            alertaBarrioNoComprado.showAndWait();

        }catch (JugadorDebeComprarElBarrioParaPoderConstruirException e){


            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("Tenes que comprar el barrio para poder construir un hotel.");
            alertaBarrioNoComprado.showAndWait();

        }catch (CapitalInsuficienteException e){

            Alert alertaCapitalInsuficienteParaConstruirHotel = new Alert(Alert.AlertType.WARNING);
            alertaCapitalInsuficienteParaConstruirHotel.initOwner(stage);
            alertaCapitalInsuficienteParaConstruirHotel.setTitle("ATENCION");
            alertaCapitalInsuficienteParaConstruirHotel.setHeaderText("No tenes dinero suficiente para construir el hotel.");
            alertaCapitalInsuficienteParaConstruirHotel.showAndWait();

        }catch (NoSePermiteConstruirMasDeUnHotelEnBarrioDivididoException e) {

            Alert alertaBarrioCompletoDeHoteles = new Alert(Alert.AlertType.WARNING);
            alertaBarrioCompletoDeHoteles.initOwner(stage);
            alertaBarrioCompletoDeHoteles.setTitle("ATENCION");
            alertaBarrioCompletoDeHoteles.setHeaderText("Esta propiedad ya tiene capacidad maxima de hoteles");
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
        alertaConstruccionRealizada.setHeaderText("La construccion del hotel fue realizada.");
        alertaConstruccionRealizada.setContentText("Ahora tu capital es de: " + jugador.getCapital().getCantidad());
        alertaConstruccionRealizada.showAndWait();
    }
}
