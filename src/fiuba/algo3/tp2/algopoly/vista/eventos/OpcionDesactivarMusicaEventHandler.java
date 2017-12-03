package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class OpcionDesactivarMusicaEventHandler implements EventHandler<ActionEvent> {

    private final MenuItem opcionDesactivarMusica;
    private final ContenedorPrincipal contenedorPrincipal;
    private final MenuItem opcionActivarMusica;

    public OpcionDesactivarMusicaEventHandler(ContenedorPrincipal contenedorPrincipal, MenuItem opcionDesactivarMusica, MenuItem opcionActivarMusica) {
        this.contenedorPrincipal = contenedorPrincipal;
        this.opcionDesactivarMusica = opcionDesactivarMusica;
        this.opcionActivarMusica = opcionActivarMusica;
    }

    @Override
    public void handle(ActionEvent event) {
        this.contenedorPrincipal.pararMusica();
        this.opcionDesactivarMusica.setDisable(true);
        this.opcionActivarMusica.setDisable(false);
    }
}
