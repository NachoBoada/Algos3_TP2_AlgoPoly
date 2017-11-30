package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruir;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirHotelSiNoSeConstruyeElMaximoNumeroDeCasasException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.NoSePuedeConstruirUnHotelEnUnBarrioSimpleException;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

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

        }catch (JugadorDebeComprarElBarrioParaPoderConstruir e){


            Alert alertaBarrioNoComprado = new Alert(Alert.AlertType.WARNING);
            alertaBarrioNoComprado.initOwner(stage);
            alertaBarrioNoComprado.setTitle("ATENCION");
            alertaBarrioNoComprado.setHeaderText("Tenes que comprar el barrio para poder construir un hotel.");
            alertaBarrioNoComprado.showAndWait();
        }

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();

    }
}
