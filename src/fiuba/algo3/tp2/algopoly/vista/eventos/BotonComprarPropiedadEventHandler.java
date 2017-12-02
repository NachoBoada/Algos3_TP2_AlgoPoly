package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnBarrioYaComprado;
import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnaCompaniaYaComprada;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonComprarPropiedadEventHandler implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

    public BotonComprarPropiedadEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;

    }


    @Override
    public void handle(ActionEvent event) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();
        Encasillable casilleroActual = jugadorActual.casilleroActual();
        Tablero tablero = Juego.getInstance().getTablero();

        Propiedad propiedadAComprar;

        try {

            propiedadAComprar = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());

        }catch (NullPointerException e){

            propiedadAComprar = tablero.obtenerCompaniaPorNombre(casilleroActual.getNombre());

        }

        try{

            jugadorActual.comprarPropiedad(propiedadAComprar);

            this.informarCompraRealizada(jugadorActual);

        }catch (NoSePuedeComprarUnBarrioYaComprado e){

            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("Este barrio ya esta comprado, no se puede comprar.");
            alertaBarrioNoComprado.showAndWait();

        }catch (NoSePuedeComprarUnaCompaniaYaComprada e){

            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("Esta compania ya esta comprada, no se puede comprar.");
            alertaBarrioNoComprado.showAndWait();

        }catch (CapitalInsuficienteException e){

            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("Tu dinero es insuficiente para comprar esta propiedad.");
            alertaBarrioNoComprado.showAndWait();

        }

        this.contenedorPrincipal.jugadorComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

    }

    private void informarCompraRealizada(Jugador jugadorActual) {

        Alert alertaCompraRealizada = new Alert(Alert.AlertType.INFORMATION);
        alertaCompraRealizada.initOwner(stage);
        alertaCompraRealizada.setTitle("COMPRA");
        alertaCompraRealizada.setHeaderText("Compra realizada. Ahora tu capital es de: " + jugadorActual.getCapital().getCantidad());
        alertaCompraRealizada.showAndWait();

    }
}
