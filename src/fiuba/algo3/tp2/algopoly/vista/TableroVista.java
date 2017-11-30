package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Tablero;
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

        this.add(this.crearCasilleroEstandar("Salida", "casillero6.png"), 5, 5);
        this.add(this.crearCasilleroEstandar("Quini 6", "casillero6.png"), 4, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires Sur", "casillero2.png"),3, 5);
        this.add(this.crearCasilleroEstandar("Edesur", "casillero6.png"), 2, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires Norte", "casillero2.png"),1,5);
        this.add(this.crearCasilleroEstandar("Carcel", "casillero6.png"),0,5);
        this.add(this.crearCasilleroEstandar("Cordoba Sur", "casillero.png"), 0, 4);
        this.add(this.crearCasilleroEstandar("Avance Dinamico", "casillero6.png"), 0, 3);
        this.add(this.crearCasilleroEstandar("Subte", "casillero6.png"), 0, 2);
        this.add(this.crearCasilleroEstandar("Cordoba Norte","casillero.png"), 0, 1);
        this.add(this.crearCasilleroEstandar("Impuesto Al Lujo","casillero6.png"), 0, 0);
        this.add(this.crearCasilleroEstandar("Santa Fe", "casillero1.png"), 1, 0);
        this.add(this.crearCasilleroEstandar("Aysa", "casillero6.png"), 2, 0);
        this.add(this.crearCasilleroEstandar("Salta Norte", "casillero3.png"), 3, 0);
        this.add(this.crearCasilleroEstandar("Salta Sur", "casillero3.png"), 4, 0);
        this.add(this.crearCasilleroEstandar("Policia", "casillero6.png"), 5, 0);
        this.add(this.crearCasilleroEstandar("Tren", "casillero6.png"), 5, 1);
        this.add(this.crearCasilleroEstandar("Neuquen", "casillero4.png"), 5, 2);
        this.add(this.crearCasilleroEstandar("Retroceso Dinamico", "casillero6.png"), 5, 3);
        this.add(this.crearCasilleroEstandar("Tucuman", "casillero5.png"), 5, 4);
    }

    private Button crearCasilleroEstandar(String nombreCasillero, String imagen ) {

        Button casillero = new Button(nombreCasillero);
        casillero.setFont(Font.font("times new roman", FontPosture.REGULAR,15 ));
        casillero.setPrefSize(140, 100);
        InformacionCasilleroVista informacionCasillero=(InformacionCasilleroVista)panelDerecho.getChildren().get(0);
        BotonAccionCasilleroEventHandler botonAccionCasilleroEventHandler= new BotonAccionCasilleroEventHandler(tablero.obtenerCasilleroPorNombre( nombreCasillero), informacionCasillero);


        Image imagenBoton= new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/"+imagen);
        BackgroundSize backgroundSizeBoton = new BackgroundSize(140, 100, true, true, true, true);
        BackgroundImage imagenDeFondoBoton = new BackgroundImage(imagenBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBoton);
        casillero.setBackground(new Background(imagenDeFondoBoton));


        casillero.setOnAction( botonAccionCasilleroEventHandler );
        return casillero;
    }
}
