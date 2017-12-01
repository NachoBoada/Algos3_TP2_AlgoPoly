package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorDebeComprarElBarrioParaPoderConstruir;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class BotonConstruirCasaEventHandler implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedorPrincipal;
    Stage stage;

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

        }catch (JugadorDebeComprarElBarrioParaPoderConstruir e){

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

        }

        this.contenedorPrincipal.jugadorNoComproPropiedad();

        this.contenedorPrincipal.setPanelIzquierdo();
        this.contenedorPrincipal.setPanelDerecho();
        this.contenedorPrincipal.setCentro();



    }
}
