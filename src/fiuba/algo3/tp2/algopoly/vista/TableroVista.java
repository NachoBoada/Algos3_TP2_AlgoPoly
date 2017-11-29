package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.vista.eventos.BotonAccionCasilleroEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

        this. add(this.crearCasilleroEstandar("SALIDA", 0), 5, 5);
        this.add(this.crearCasilleroEstandar("Quini 6",1), 4, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires\n      SUR",2),3, 5);
        this.add(this.crearCasilleroEstandar("EDESUR",3), 2, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires\n    NORTE",4),1,5);
        this.add(this.crearCasilleroEstandar("CARCEL",5),0,5);
        this.add(this.crearCasilleroEstandar("Cordoba\n   SUR",6), 0, 4);
        this.add(this.crearCasilleroEstandar(" Avance\nDinamico",7), 0, 3);
        this.add(this.crearCasilleroEstandar("SUBTE",8), 0, 2);
        this.add(this.crearCasilleroEstandar("Cordoba\nNORTE",9), 0, 1);
        this.add(this.crearCasilleroEstandar("Impuesto\n  de lujo",10), 0, 0);
        this.add(this.crearCasilleroEstandar("Santa Fe",11), 1, 0);
        this.add(this.crearCasilleroEstandar("AYSA",12), 2, 0);
        this.add(this.crearCasilleroEstandar("  Salta\nNORTE",13), 3, 0);
        this.add(this.crearCasilleroEstandar("Salta\nSUR",14), 4, 0);
        this.add(this.crearCasilleroEstandar("POLICIA",15), 5, 0);
        this.add(this.crearCasilleroEstandar("TREN",16), 5, 1);
        this.add(this.crearCasilleroEstandar("Neuquen",17), 5, 2);
        this.add(this.crearCasilleroEstandar("Retroceso\nDinamico",18), 5, 3);
        this.add(this.crearCasilleroEstandar("Tucuman",19), 5, 4);
    }

    private Button crearCasilleroEstandar(String nombreCasillero, int posicion) {

        Button casillero = new Button(nombreCasillero);


        BotonAccionCasilleroEventHandler botonAccionCasilleroEventHandler= new BotonAccionCasilleroEventHandler(tablero.getEncasillable(posicion), (InformacionCasilleroVista) this.panelDerecho.getChildren().get(0));

        casillero.setFont(Font.font("times new roman", FontPosture.REGULAR, 20));
        casillero.setPrefSize(140, 100);
        casillero.setOnAction( botonAccionCasilleroEventHandler );
        return casillero;
    }
}
