package fiuba.algo3.tp2.algopoly.vista;


import fiuba.algo3.tp2.algopoly.vista.eventos.OpcionActivarMusicaEventHandler;
import fiuba.algo3.tp2.algopoly.vista.eventos.OpcionDesactivarMusicaEventHandler;
import fiuba.algo3.tp2.algopoly.vista.eventos.OpcionPantallaCompletaEventHandler;
import fiuba.algo3.tp2.algopoly.vista.eventos.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu (Stage stage, ContenedorPrincipal contenedorPrincipal) {

        Menu menuJuego = new Menu("Juego");
        Menu menuSonido = new Menu("Sonido");
        Menu menuVer = new Menu("Ver");

        MenuItem opcionNuevoJuego = new MenuItem("Nuevo Juego");
        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionActivarMusica = new MenuItem("Activar musica");
        MenuItem opcionDesactivarMusica = new MenuItem("Desactivar musica");

        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirEventHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaEventHandler = new OpcionPantallaCompletaEventHandler(stage,opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaEventHandler);

        opcionPantallaCompleta.setDisable(true);
        opcionActivarMusica.setDisable(true);

        OpcionActivarMusicaEventHandler opcionActivarMusicaEventHandler = new OpcionActivarMusicaEventHandler(contenedorPrincipal, opcionActivarMusica, opcionDesactivarMusica);
        opcionActivarMusica.setOnAction(opcionActivarMusicaEventHandler);

        OpcionDesactivarMusicaEventHandler opcionDesactivarMusicaEventHandler = new OpcionDesactivarMusicaEventHandler(contenedorPrincipal, opcionDesactivarMusica, opcionActivarMusica);
        opcionDesactivarMusica.setOnAction(opcionDesactivarMusicaEventHandler);

        menuJuego.getItems().addAll(opcionNuevoJuego,new SeparatorMenuItem(),opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuSonido.getItems().addAll(opcionActivarMusica,new SeparatorMenuItem(),opcionDesactivarMusica);

        this.getMenus().addAll(menuJuego,menuVer,menuSonido);

    }


    public void aplicacionMaximizada() {

        this.opcionPantallaCompleta.setDisable(false);

    }
}
