package fiuba.algo3.tp2.algopoly.vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu barraDeMenu;

    public ContenedorPrincipal(Stage stage) {

        this.setBarraDeMenu(stage);
    }

    private void setBarraDeMenu(Stage stage) {

        this.barraDeMenu = new BarraDeMenu(stage);

        this.setTop(barraDeMenu);

    }

    public BarraDeMenu getBarraDeMenu() {
        return barraDeMenu;
    }
}
