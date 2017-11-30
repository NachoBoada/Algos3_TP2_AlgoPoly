package fiuba.algo3.tp2.algopoly.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class InformacionCasilleroVista extends VBox {

    private final Label label;

    InformacionCasilleroVista(){

        setPadding(new Insets(10));
        setSpacing(8);

        Label infoDeCasilleroSeleccionado = new Label("Info de casillero seleccionado");
        label= new Label( );
        getChildren().add( infoDeCasilleroSeleccionado);
        getChildren().add( label);


    }

    public void setContenido(String contenido) {

        label.setText(contenido);

    }
}
