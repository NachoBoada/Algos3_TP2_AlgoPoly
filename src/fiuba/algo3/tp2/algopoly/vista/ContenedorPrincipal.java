package fiuba.algo3.tp2.algopoly.vista;

import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
        Label infoJugadorActual = new Label("Info jugador actual");

        this.panelIzquierdo = new VBox(acciones,infoJugadorActual);
        this.panelIzquierdo.setSpacing(500);
        this.panelIzquierdo.setPadding(new Insets(15));

        this.panelIzquierdo.setBackground(new Background (new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));

        this.setLeft(this.panelIzquierdo);

    }

    private void setPanelDerecho() {

        Label jugadoresRestantes = new Label("Jugadores Restantes");
        Label infoDeCasilleroSeleccionado = new Label("Info de casillero seleccionado");

        this.panelDerecho = new VBox(jugadoresRestantes,infoDeCasilleroSeleccionado);
        this.panelDerecho.setSpacing(500);
        this.panelDerecho.setPadding(new Insets(15));

        this.panelDerecho.setBackground(new Background (new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));

        this.setRight(this.panelDerecho);

    }

    private void setCentro() {

        //this.canvasCentral = new Canvas(690,364);
        //Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pruebaCanvas.png");
        //this.canvasCentral.getGraphicsContext2D().drawImage(imagen,0,0);
        //this.panelCentral.get().setSpacing(20);
        //this.panelCentral.get().setPadding(new Insets(25));

        this.setCenter(new TableroVista());

    }


    public BarraDeMenu getBarraDeMenu() {
        return barraDeMenu;
    }
}
