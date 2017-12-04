package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class OpcionVenderPropiedadEventHandler implements EventHandler<ActionEvent>{

    private Stage stage;
    private Propiedad propiedad;
    private ContenedorPrincipal contenedorPrincipal;



    public OpcionVenderPropiedadEventHandler(Propiedad propiedad, Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.propiedad = propiedad;
        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }


    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        jugadorActual.venderPropiedad(this.propiedad);

        this.informarVentaRealizada(jugadorActual);

        if (this.contenedorPrincipal.getJugadorTieneQueVender()){

            jugadorActual.caerEn(jugadorActual.casilleroActual());
            Juego.getInstance().turnoProximojugador();
            this.contenedorPrincipal.setJugadorTieneQueVender(false);

        }

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

    }

    private void informarVentaRealizada(Jugador jugadorActual) {

        String pathCajaRegistradora = Paths.get("src/fiuba/algo3/tp2/algopoly/vista/sonidos/sonidoCajaRegistradora.mp3").toAbsolutePath().toUri().toString();
        Media cajaRegistradora = new Media(pathCajaRegistradora);
        MediaPlayer sonidoCaja = new MediaPlayer(cajaRegistradora);
        sonidoCaja.setAutoPlay(true);

        Alert alertaCompraRealizada = new Alert(Alert.AlertType.INFORMATION);
        alertaCompraRealizada.initOwner(this.stage);
        alertaCompraRealizada.setTitle("VENTA");
        alertaCompraRealizada.setHeaderText("Venta realizada!");
        alertaCompraRealizada.setContentText("Ahora tu capital es de: " + jugadorActual.getCapital().getCantidad());
        alertaCompraRealizada.showAndWait();

    }
}
