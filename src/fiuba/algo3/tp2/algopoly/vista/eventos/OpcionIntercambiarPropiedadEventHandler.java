package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class OpcionIntercambiarPropiedadEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Propiedad propiedadAObtener;
    private Propiedad propiedadADar;

    public OpcionIntercambiarPropiedadEventHandler (Stage stage, Propiedad propiedad) {
        this.stage = stage;
        this.propiedadAObtener = propiedad;
    }

    @Override
    public void handle(ActionEvent event) {

        Juego juego = Juego.getInstance();
        Tablero tablero = Juego.getInstance().getTablero();
        Encasillable casilleroActual = juego.getJugadorActual().casilleroActual();

        try {
            propiedadADar = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());

        }catch (NullPointerException e){
            propiedadADar = tablero.obtenerCompaniaPorNombre(casilleroActual.getNombre());
        }

        juego.getJugadorActual().intercambiarPropiedadPor(propiedadADar, propiedadAObtener);


        Alert alertaCompraRealizada = new Alert(Alert.AlertType.INFORMATION);
        alertaCompraRealizada.initOwner(stage);
        alertaCompraRealizada.setTitle("INTERCAMBIO");
        alertaCompraRealizada.setHeaderText("Las propiedades fueron intercambiadas con éxito");
        alertaCompraRealizada.showAndWait();
    }
}
