package fiuba.algo3.tp2.algopoly.vista.eventos;


import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;


public class OpcionActivarMusicaEventHandler implements EventHandler<ActionEvent>{

    private final MenuItem opcionActivarMusica;
    private final ContenedorPrincipal contenedorPrincipal;
    private final MenuItem desactivarMusica;

    public OpcionActivarMusicaEventHandler(ContenedorPrincipal contenedorPrincipal, MenuItem opcionActivarMusica, MenuItem opcionDesactivarMusica) {
        this.contenedorPrincipal = contenedorPrincipal;
        this.opcionActivarMusica = opcionActivarMusica;
        this.desactivarMusica = opcionDesactivarMusica;
    }

    @Override
    public void handle(ActionEvent event) {
        this.contenedorPrincipal.reproducirMusica();
        this.opcionActivarMusica.setDisable(true);
        this.desactivarMusica.setDisable(false);
    }
}
