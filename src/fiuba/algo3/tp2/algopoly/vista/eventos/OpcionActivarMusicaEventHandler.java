package fiuba.algo3.tp2.algopoly.vista.eventos;


import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;


public class OpcionActivarMusicaEventHandler implements EventHandler<ActionEvent>{

    private final MenuItem opcionActivarMusica;
    private final ContenedorPrincipal contenedorPrincipal;

    public OpcionActivarMusicaEventHandler(ContenedorPrincipal contenedorPrincipal, MenuItem opcionActivarMusica) {
        this.contenedorPrincipal = contenedorPrincipal;
        this.opcionActivarMusica = opcionActivarMusica;
    }

    @Override
    public void handle(ActionEvent event) {
        this.contenedorPrincipal.reproducirMusica();
    }
}
