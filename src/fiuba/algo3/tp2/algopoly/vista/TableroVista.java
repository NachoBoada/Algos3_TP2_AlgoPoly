package fiuba.algo3.tp2.algopoly.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class TableroVista extends GridPane {

    public TableroVista() {

        this.setAlignment(Pos.CENTER);

        this. add(this.crearCasilleroEstandar("SALIDA"), 5, 5);
        this.add(this.crearCasilleroEstandar("Quini 6"), 4, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires\n      SUR"),3, 5);
        this.add(this.crearCasilleroEstandar("EDESUR"), 2, 5);
        this.add(this.crearCasilleroEstandar("Buenos Aires\n    NORTE"),1,5);
        this.add(this.crearCasilleroEstandar("CARCEL"),0,5);
        this.add(this.crearCasilleroEstandar("Cordoba\n   SUR"), 0, 4);
        this.add(this.crearCasilleroEstandar(" Avance\nDinamico"), 0, 3);
        this.add(this.crearCasilleroEstandar("SUBTE"), 0, 2);
        this.add(this.crearCasilleroEstandar("Cordoba\nNORTE"), 0, 1);
        this.add(this.crearCasilleroEstandar("Impuesto\n  de lujo"), 0, 0);
        this.add(this.crearCasilleroEstandar("Santa Fe"), 1, 0);
        this.add(this.crearCasilleroEstandar("AYSA"), 2, 0);
        this.add(this.crearCasilleroEstandar("  Salta\nNORTE"), 3, 0);
        this.add(this.crearCasilleroEstandar("Salta\nSUR"), 4, 0);
        this.add(this.crearCasilleroEstandar("POLICIA"), 5, 0);
        this.add(this.crearCasilleroEstandar("TREN"), 5, 1);
        this.add(this.crearCasilleroEstandar("Neuquen"), 5, 2);
        this.add(this.crearCasilleroEstandar("Retroceso\nDinamico"), 5, 3);
        this.add(this.crearCasilleroEstandar("Tucuman"), 5, 4);
    }

    private Button crearCasilleroEstandar(String nombreCasillero) {

        Button casillero = new Button(nombreCasillero);

        casillero.setFont(Font.font("times new roman", FontPosture.REGULAR, 20));
        casillero.setPrefSize(140, 100);

        return casillero;
    }
}
