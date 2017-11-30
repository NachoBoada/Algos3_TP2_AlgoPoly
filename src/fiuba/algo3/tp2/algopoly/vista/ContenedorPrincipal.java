package fiuba.algo3.tp2.algopoly.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu barraDeMenu;
    VBox panelIzquierdo;
    VBox panelDerecho;



    public ContenedorPrincipal(Stage stage) {

        this.setBarraDeMenu(stage);
        this.setPanelIzquierdo();
        this.setPanelDerecho();
        this.setCentro();

    }

    private void setBarraDeMenu(Stage stage) {

        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);

    }

    private void setPanelIzquierdo() {

        Label acciones = new Label("Acciones de jugador");

        this.panelIzquierdo = new VBox();
        this.panelIzquierdo.setSpacing(500);
        this.panelIzquierdo.setPadding(new Insets(15));

        this.panelIzquierdo.setBackground(new Background (new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
        InformacionJugadorVista informacionJugadorVista= new InformacionJugadorVista();
        panelIzquierdo.getChildren().add(acciones);
        panelIzquierdo.getChildren().add(informacionJugadorVista);
        this.setLeft(this.panelIzquierdo);

    }

    private void setPanelDerecho() {

        Label jugadoresRestantes = new Label("Jugadores Restantes");

        this.panelDerecho = new VBox();
        this.panelDerecho.setSpacing(100);
        this.panelDerecho.setPadding(new Insets(10));

        this.panelDerecho.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        InformacionCasilleroVista informacionCasilleroVista= new InformacionCasilleroVista();
        this.panelDerecho.getChildren().add(informacionCasilleroVista);
        this.panelDerecho.getChildren().add(jugadoresRestantes);
        this.setRight(this.panelDerecho);

    }

    private void setCentro() {

        //this.canvasCentral = new Canvas(690,364);
        //Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pruebaCanvas.png");
        //this.canvasCentral.getGraphicsContext2D().drawImage(imagen,0,0);
        //this.panelCentral.get().setSpacing(20);
        //this.panelCentral.get().setPadding(new Insets(25));

        this.setCenter(new TableroVista( panelDerecho));

    }


    public BarraDeMenu getBarraDeMenu() {
        return barraDeMenu;
    }
}
