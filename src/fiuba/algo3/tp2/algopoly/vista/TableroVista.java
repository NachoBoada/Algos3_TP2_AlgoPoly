package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.vista.eventos.BotonAccionCasilleroEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class TableroVista extends GridPane {

    private final Juego juego;
    private final Tablero tablero;
    private final VBox panelDerecho;

    public TableroVista( VBox panelDerecho) {

        juego= Juego.getInstance();
        tablero= juego.getTablero();
        this.panelDerecho= panelDerecho;
        this.setAlignment(Pos.CENTER);

        this. add(this.crearCasillero("Salida", "Casillero0.png"), 5, 5);
        this.add(this.crearCasillero("Quini 6", "Casillero1.png"), 4, 5);
        this.add(this.crearCasillero("Buenos Aires Sur", "Casillero2.png"),3, 5);
        this.add(this.crearCasillero("Edesur", "Casillero3.png"), 2, 5);
        this.add(this.crearCasillero("Buenos Aires Norte", "Casillero4.png"),1,5);
        this.add(this.crearCasillero("Carcel", "Casillero5.png"),0,5);
        this.add(this.crearCasillero("Cordoba Sur", "Casillero6.png"), 0, 4);
        this.add(this.crearCasillero("Avance Dinamico", "Casillero7.png"), 0, 3);
        this.add(this.crearCasillero("Subte", "Casillero8.png"), 0, 2);
        this.add(this.crearCasillero("Cordoba Norte","Casillero9.png"), 0, 1);
        this.add(this.crearCasillero("Impuesto Al Lujo","Casillero10.png"), 0, 0);
        this.add(this.crearCasillero("Santa Fe", "Casillero11.png"), 1, 0);
        this.add(this.crearCasillero("Aysa", "Casillero12.png"), 2, 0);
        this.add(this.crearCasillero("Salta Norte", "Casillero13.png"), 3, 0);
        this.add(this.crearCasillero("Salta Sur", "Casillero14.png"), 4, 0);
        this.add(this.crearCasillero("Policia", "Casillero15.png"), 5, 0);
        this.add(this.crearCasillero("Tren", "Casillero16.png"), 5, 1);
        this.add(this.crearCasillero("Neuquen", "Casillero17.png"), 5, 2);
        this.add(this.crearCasillero("Retroceso Dinamico", "Casillero18.png"), 5, 3);
        this.add(this.crearCasillero("Tucuman", "Casillero19.png"), 5, 4);
    }

     private Button crearCasillero(String nombreCasillero, String imagen ) {

        Encasillable unCasillero= tablero.obtenerCasilleroPorNombre(nombreCasillero);
        Button casillero = new Button();
        casillero.setPrefSize(140, 100);

        InformacionCasilleroVista informacionCasillero=(InformacionCasilleroVista)panelDerecho.getChildren().get(0);
        BotonAccionCasilleroEventHandler botonAccionCasilleroEventHandler= new BotonAccionCasilleroEventHandler(unCasillero, informacionCasillero);

        Image imagenBoton= new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/"+imagen);

        BackgroundSize backgroundSizeBoton = new BackgroundSize( 140, 100, true, true, true, true);
        BackgroundImage imagenDeFondoBoton = new BackgroundImage(imagenBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBoton);
        casillero.setBackground(new Background(imagenDeFondoBoton));
        casillero.setStyle("-fx-border-color: BLACK; -fx-border-width: 0.5px;");


        casillero.setOnAction( botonAccionCasilleroEventHandler );
        return casillero;
    }
}
