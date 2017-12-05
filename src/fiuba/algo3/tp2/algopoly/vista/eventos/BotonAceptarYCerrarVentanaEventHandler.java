package fiuba.algo3.tp2.algopoly.vista.eventos;


import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonAceptarYCerrarVentanaEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;


    public BotonAceptarYCerrarVentanaEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal){

        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;

    }

    @Override
    public void handle(ActionEvent event) {

        this.stage.close();

        if (! this.contenedorPrincipal.getJugadorTieneQueVender()){

            this.contenedorPrincipal.habilitarTirarYMover();

        }



    }
}
