package fiuba.algo3.tp2.algopoly.vista.eventos;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import fiuba.algo3.tp2.algopoly.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BotonVenderPropiedadEventHandler implements EventHandler<ActionEvent>{

    ContenedorPrincipal contenedorPrincipal;
    Stage stage;
    MenuButton botonVenderPropiedad;

    public BotonVenderPropiedadEventHandler(Stage stage, ContenedorPrincipal contenedorPrincipal, MenuButton botonVenderPropiedad){

        this.contenedorPrincipal = contenedorPrincipal;
        this.stage = stage;
        this.botonVenderPropiedad = botonVenderPropiedad;

    }


    @Override
    public void handle(ActionEvent event) {

        System.out.println("Funciona");



    }
}
