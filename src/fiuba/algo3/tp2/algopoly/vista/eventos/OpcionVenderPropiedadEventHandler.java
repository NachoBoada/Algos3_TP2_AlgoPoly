package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

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

        Alert alertaCompraRealizada = new Alert(Alert.AlertType.INFORMATION);
        alertaCompraRealizada.initOwner(this.stage);
        alertaCompraRealizada.setTitle("VENTA");
        alertaCompraRealizada.setHeaderText("Venta realizada!");
        alertaCompraRealizada.setContentText("Ahora tu capital es de: " + jugadorActual.getCapital().getCantidad());
        alertaCompraRealizada.showAndWait();

    }
}
