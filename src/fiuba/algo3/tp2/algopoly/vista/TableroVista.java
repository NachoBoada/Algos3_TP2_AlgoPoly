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

    private Tablero tablero;
    private Juego juego;
    private VBox panelDerecho;

    public TableroVista(VBox panelDerecho) {

        juego= Juego.getInstance();
        tablero= juego.getTablero();
        this.panelDerecho= panelDerecho;
        this.setAlignment(Pos.CENTER);

        this. add(this.crearCasilleroEstandar("SALIDA", 0, "casillero6.png"), 5, 5);
        this.add(this.crearCasilleroEstandar("Quini 6",1, "casillero6.png"), 4, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires\n      SUR",2, "casillero2.png"),3, 5);
        this.add(this.crearCasilleroEstandar("EDESUR",3, "casillero6.png"), 2, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires\n    NORTE",4, "casillero2.png"),1,5);
        this.add(this.crearCasilleroEstandar("CARCEL",5, "casillero6.png"),0,5);
        this.add(this.crearCasilleroEstandar("Cordoba\n   SUR",6, "casillero.png"), 0, 4);
        this.add(this.crearCasilleroEstandar(" Avance\nDinamico",7, "casillero6.png"), 0, 3);
        this.add(this.crearCasilleroEstandar("SUBTE",8, "casillero6.png"), 0, 2);
        this.add(this.crearCasilleroEstandar("Cordoba\nNORTE",9,"casillero.png"), 0, 1);
        this.add(this.crearCasilleroEstandar("Impuesto\n  de lujo",10,"casillero6.png"), 0, 0);
        this.add(this.crearCasilleroEstandar("Santa Fe",11, "casillero1.png"), 1, 0);
        this.add(this.crearCasilleroEstandar("AYSA",12, "casillero6.png"), 2, 0);
        this.add(this.crearCasilleroEstandar("  Salta\nNORTE",13, "casillero3.png"), 3, 0);
        this.add(this.crearCasilleroEstandar("Salta\nSUR",14, "casillero3.png"), 4, 0);
        this.add(this.crearCasilleroEstandar("POLICIA",15, "casillero6.png"), 5, 0);
        this.add(this.crearCasilleroEstandar("TREN",16, "casillero6.png"), 5, 1);
        this.add(this.crearCasilleroEstandar("Neuquen",17, "casillero4.png"), 5, 2);
        this.add(this.crearCasilleroEstandar("Retroceso\nDinamico",18, "casillero6.png"), 5, 3);
        this.add(this.crearCasilleroEstandar("Tucuman",19, "casillero5.png"), 5, 4);
    }

    private Button crearCasilleroEstandar(String nombreCasillero, int posicion, String imagen ) {

        Button casillero = new Button(nombreCasillero);
        casillero.setFont(Font.font("times new roman", FontPosture.REGULAR, 20));
        casillero.setPrefSize(140, 100);
        InformacionCasilleroVista informacionCasillero=(InformacionCasilleroVista)panelDerecho.getChildren().get(0);
        BotonAccionCasilleroEventHandler botonAccionCasilleroEventHandler= new BotonAccionCasilleroEventHandler(tablero.getEncasillable(posicion), informacionCasillero);


        Image imagenBoton= new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/"+imagen);
        BackgroundSize backgroundSizeBoton = new BackgroundSize(140, 100, true, true, true, true);
        BackgroundImage imagenDeFondoBoton = new BackgroundImage(imagenBoton, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSizeBoton);
        casillero.setBackground(new Background(imagenDeFondoBoton));


        casillero.setOnAction( botonAccionCasilleroEventHandler );
        return casillero;
    }
}
