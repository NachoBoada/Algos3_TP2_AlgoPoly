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

        this. add(this.crearCasilleroEstandar("Salida", "casillero5.png"), 5, 5);
        this.add(this.crearCasilleroEstandar("Quini 6", "casillero.png"), 4, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires Sur", "casillero4.png"),3, 5);
        this.add(this.crearCasilleroEstandar("Edesur", "casillero7.png"), 2, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires Norte", "casillero4.png"),1,5);
        this.add(this.crearCasilleroEstandar("Carcel", "casillero11.png"),0,5);
        this.add(this.crearCasilleroEstandar("Cordoba Sur", "casillero2.png"), 0, 4);
        this.add(this.crearCasilleroEstandar("Avance Dinamico", "casillero.png"), 0, 3);
        this.add(this.crearCasilleroEstandar("Subte", "casillero7.png"), 0, 2);
        this.add(this.crearCasilleroEstandar("Cordoba Norte","casillero2.png"), 0, 1);
        this.add(this.crearCasilleroEstandar("Impuesto Al Lujo","casillero.png"), 0, 0);
        this.add(this.crearCasilleroEstandar("Santa Fe", "casillero8.png"), 1, 0);
        this.add(this.crearCasilleroEstandar("Aysa", "casillero7.png"), 2, 0);
        this.add(this.crearCasilleroEstandar("Salta Norte", "casillero6.png"), 3, 0);
        this.add(this.crearCasilleroEstandar("Salta Sur", "casillero6.png"), 4, 0);
        this.add(this.crearCasilleroEstandar("Policia", "casillero9.png"), 5, 0);
        this.add(this.crearCasilleroEstandar("Tren", "casillero7.png"), 5, 1);
        this.add(this.crearCasilleroEstandar("Neuquen", "casillero10.png"), 5, 2);
        this.add(this.crearCasilleroEstandar("Retroceso Dinamico", "casillero.png"), 5, 3);
        this.add(this.crearCasilleroEstandar("Tucuman", "casillero3.png"), 5, 4);
    }

    private Button crearCasilleroEstandar(String nombreCasillero, String imagen ) {

        Encasillable unCasillero= tablero.obtenerCasilleroPorNombre(nombreCasillero);
        Button casillero = new Button(nombreCasillero + "\n"+ "    "+ unCasillero.getPosicion());

        casillero.setFont(Font.font("times new roman", FontPosture.REGULAR,15 ));
        casillero.setPrefSize(140, 100);
        InformacionCasilleroVista informacionCasillero=(InformacionCasilleroVista)panelDerecho.getChildren().get(0);
        BotonAccionCasilleroEventHandler botonAccionCasilleroEventHandler= new BotonAccionCasilleroEventHandler(unCasillero, informacionCasillero);


        Image imagenBoton= new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/"+imagen);
        BackgroundSize backgroundSizeBoton = new BackgroundSize(140, 100, true, true, true, true);
        BackgroundImage imagenDeFondoBoton = new BackgroundImage(imagenBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBoton);
        casillero.setBackground(new Background(imagenDeFondoBoton));


        casillero.setOnAction( botonAccionCasilleroEventHandler );
        return casillero;
    }
}
