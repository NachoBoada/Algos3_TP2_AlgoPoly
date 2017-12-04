package fiuba.algo3.tp2.algopoly.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class InformacionCasilleroVista extends VBox {

    private final Label label;

    InformacionCasilleroVista(){

        setPadding(new Insets(10));
        setSpacing(8);
        this.setAlignment(Pos.CENTER);

        Label infoDeCasilleroSeleccionado = new Label("      INFORMACION DE\nCASILLERO SELECCIONADO");
        infoDeCasilleroSeleccionado.setTextFill(Color.web("#0066CC"));
        infoDeCasilleroSeleccionado.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        label= new Label( );
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 11));
        getChildren().add( infoDeCasilleroSeleccionado);
        getChildren().add( label);


    }

    public void setContenido(String contenido) {

        label.setText(contenido);

    }
}
