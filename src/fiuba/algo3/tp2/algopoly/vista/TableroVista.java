package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioDividido;
import fiuba.algo3.tp2.algopoly.vista.eventos.BotonAccionCasilleroEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class TableroVista extends GridPane {

    private final Juego juego;
    private final Tablero tablero;
    private final VBox panelDerecho;

    public TableroVista(VBox panelDerecho) {

        juego = Juego.getInstance();
        tablero = juego.getTablero();
        this.panelDerecho = panelDerecho;
        this.setAlignment(Pos.CENTER);

        this.add(this.crearCasilleroEstandar("Salida", "Casillero0"), 5, 5);
        this.add(this.crearCasilleroEstandar("Quini 6", "Casillero1"), 4, 5);
        this.add(this.crearCasilleroBarrio("Buenos Aires Sur", "Casillero2"), 3, 5);
        this.add(this.crearCasilleroEstandar("Edesur", "Casillero3"), 2, 5);
        this.add(this.crearCasilleroBarrio("Buenos Aires Norte", "Casillero4"), 1, 5);
        this.add(this.crearCasilleroEstandar("Carcel", "Casillero5"), 0, 5);
        this.add(this.crearCasilleroBarrio("Cordoba Sur", "Casillero6"), 0, 4);
        this.add(this.crearCasilleroEstandar("Avance Dinamico", "Casillero7"), 0, 3);
        this.add(this.crearCasilleroEstandar("Subte", "Casillero8"), 0, 2);
        this.add(this.crearCasilleroBarrio("Cordoba Norte", "Casillero9"), 0, 1);
        this.add(this.crearCasilleroEstandar("Impuesto Al Lujo", "Casillero10"), 0, 0);
        this.add(this.crearCasilleroBarrio("Santa Fe", "Casillero11"), 1, 0);
        this.add(this.crearCasilleroEstandar("Aysa", "Casillero12"), 2, 0);
        this.add(this.crearCasilleroBarrio("Salta Norte", "Casillero13"), 3, 0);
        this.add(this.crearCasilleroBarrio("Salta Sur", "Casillero14"), 4, 0);
        this.add(this.crearCasilleroEstandar("Policia", "Casillero15"), 5, 0);
        this.add(this.crearCasilleroEstandar("Tren", "Casillero16"), 5, 1);
        this.add(this.crearCasilleroBarrio("Neuquen", "Casillero17"), 5, 2);
        this.add(this.crearCasilleroEstandar("Retroceso Dinamico", "Casillero18"), 5, 3);
        this.add(this.crearCasilleroBarrio("Tucuman", "Casillero19"), 5, 4);
    }

    private Button crearCasilleroEstandar(String nombreCasillero, String numeracionCasillero) {

        Encasillable unCasillero = tablero.obtenerCasilleroPorNombre(nombreCasillero);
        Button casillero = new Button();
        casillero.setPrefSize(140, 100);

        InnerShadow efecto = new InnerShadow();
        casillero.setEffect(efecto);

        InformacionCasilleroVista informacionCasillero = (InformacionCasilleroVista) panelDerecho.getChildren().get(0);
        BotonAccionCasilleroEventHandler botonAccionCasilleroEventHandler = new BotonAccionCasilleroEventHandler(unCasillero, informacionCasillero);

        Image imagenBoton = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/" + numeracionCasillero + ".png");

        BackgroundSize backgroundSizeBoton = new BackgroundSize(140, 100, true, true, true, true);
        BackgroundImage imagenDeFondoBoton = new BackgroundImage(imagenBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBoton);
        casillero.setBackground(new Background(imagenDeFondoBoton));
        casillero.setStyle("-fx-border-color: BLACK; -fx-border-width: 0.5px;");


        casillero.setOnAction(botonAccionCasilleroEventHandler);
        return casillero;
    }

    private Button crearCasilleroBarrio(String nombreCasillero, String numeracionCasillero) {

        Encasillable casillero = tablero.obtenerCasilleroPorNombre(nombreCasillero);
        Barrio barrio = tablero.obtenerBarrioPorNombre(casillero.getNombre());

        if (barrio.obtenerCantidadEdificaciones() == 1 && barrio.getCantidadHoteles() == 0) {
            return crearCasilleroEstandar(nombreCasillero, numeracionCasillero + "ConUnaCasa");
        } else if ((barrio.obtenerCantidadEdificaciones() == 2)) {
            return crearCasilleroEstandar(nombreCasillero, numeracionCasillero + "ConDosCasas");
        }

        if (barrio.obtenerCantidadEdificaciones() == 1 && barrio.getCantidadHoteles() == 1) {
            return crearCasilleroEstandar(nombreCasillero, numeracionCasillero + "ConHotel");
        } else return crearCasilleroEstandar(nombreCasillero, numeracionCasillero);
    }
}

