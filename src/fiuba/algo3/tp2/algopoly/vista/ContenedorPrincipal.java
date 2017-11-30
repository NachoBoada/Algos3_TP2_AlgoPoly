package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.Apropiable;
import fiuba.algo3.tp2.algopoly.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu barraDeMenu;
    VBox panelIzquierdo;
    VBox panelDerecho;
    Stage stage;
    Boolean jugadorComproPropiedad;



    public ContenedorPrincipal(Stage stage) {

        this.jugadorComproPropiedad = false;
        this.stage = stage;
        this.setBarraDeMenu(stage);
        this.setPanelIzquierdo();
        this.setPanelDerecho();
        this.setCentro();



    }

    private void setBarraDeMenu(Stage stage) {

        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);

    }

    public void setPanelIzquierdo() {

        Label acciones = new Label("Acciones de jugador");

        this.panelIzquierdo = new VBox();
        this.panelIzquierdo.setSpacing(10);
        this.panelIzquierdo.setPadding(new Insets(15));

        Button botonTirarDadosYMover = new Button("Tirar Dados Y Mover");
        BotonTirarDadosYMoverEventHandler botonTirarDadosYMoverEventHandler = new BotonTirarDadosYMoverEventHandler(this.stage,this);
        botonTirarDadosYMover.setOnAction(botonTirarDadosYMoverEventHandler);

        Button botonComprarPropiedad = new Button("Comprar Propiedad");
        BotonComprarPropiedadEventHandler botonComprarPropiedadEventHandler = new BotonComprarPropiedadEventHandler(this.stage,this);
        botonComprarPropiedad.setOnAction(botonComprarPropiedadEventHandler);
        botonComprarPropiedad.setDisable(true);

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        if (jugadorActual.casilleroActual().esApropiable()){

            botonComprarPropiedad.setDisable(false);

        }

        MenuButton botonVenderPropiedad = new MenuButton("Vender Propiedad");

        this.agregarPropiedadesAMenuVenderPropiedades(botonVenderPropiedad);

        Button botonConstruirCasa = new Button("Construir casa");
        BotonConstruirCasaEventHandler botonConstruirCasaEventHandler = new BotonConstruirCasaEventHandler(this.stage,this);
        botonConstruirCasa.setOnAction(botonConstruirCasaEventHandler);
        botonConstruirCasa.setDisable(false);

        Button botonConstruirHotel = new Button("Construir hotel");
        BotonConstruirHotelEventHandler botonConstruirHotelEventHandler = new BotonConstruirHotelEventHandler(this.stage,this);
        botonConstruirHotel.setOnAction(botonConstruirHotelEventHandler);
        botonConstruirHotel.setDisable(false);

        if (this.jugadorComproPropiedad){

            botonConstruirCasa.setDisable(true);
            botonConstruirHotel.setDisable(true);
            jugadorComproPropiedad = false;
        }

        try{

            Juego.getInstance().getTablero().obtenerBarrioPorNombre(jugadorActual.casilleroActual().getNombre());

        }catch(NullPointerException e){

            botonConstruirCasa.setDisable(true);
            botonConstruirHotel.setDisable(true);

        }

        Button botonPagarFianza = new Button("Pagar Fianza");
        BotonPagarFianzaEventHandler botonPagarFianzaEventHandler = new BotonPagarFianzaEventHandler(this.stage,this);
        botonPagarFianza.setOnAction(botonPagarFianzaEventHandler);
        botonPagarFianza.setDisable(true);

        if (jugadorActual.casilleroActual().getNombre().equals("Carcel")) {

            botonPagarFianza.setDisable(false);

        }

        this.panelIzquierdo.setBackground(new Background (new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY,Insets.EMPTY)));
        InformacionJugadorVista informacionJugadorVista= new InformacionJugadorVista();
        panelIzquierdo.getChildren().addAll(acciones,botonTirarDadosYMover,botonComprarPropiedad,botonVenderPropiedad,botonConstruirCasa,botonConstruirHotel,botonPagarFianza);
        panelIzquierdo.getChildren().add(informacionJugadorVista);
        this.setLeft(this.panelIzquierdo);

    }



    public void setPanelDerecho() {

        Label jugadoresRestantes = new Label("Jugadores Restantes");

        this.panelDerecho = new VBox();
        this.panelDerecho.setSpacing(100);
        this.panelDerecho.setPadding(new Insets(10));

        this.panelDerecho.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        InformacionCasilleroVista informacionCasilleroVista= new InformacionCasilleroVista();
        this.panelDerecho.getChildren().add(informacionCasilleroVista);
        this.panelDerecho.getChildren().add(jugadoresRestantes);
        this.setRight(this.panelDerecho);

    }

    public void setCentro() {

        //this.canvasCentral = new Canvas(690,364);
        //Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pruebaCanvas.png");
        //this.canvasCentral.getGraphicsContext2D().drawImage(imagen,0,0);
        //this.panelCentral.get().setSpacing(20);
        //this.panelCentral.get().setPadding(new Insets(25));

        this.setCenter(new TableroVista(panelDerecho));

    }


    public BarraDeMenu getBarraDeMenu() {
        return barraDeMenu;
    }

    private void agregarPropiedadesAMenuVenderPropiedades(MenuButton botonVenderPropiedad) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        for ( Apropiable propiedad : jugadorActual.getPropiedades() ) {


            MenuItem opcionVenderPropiedad = new MenuItem(propiedad.getNombre());
            OpcionVenderPropiedadEventHandler opcionVenderPropiedadEventHandler = new OpcionVenderPropiedadEventHandler(propiedad,this);
            opcionVenderPropiedad.setOnAction(opcionVenderPropiedadEventHandler);

            botonVenderPropiedad.getItems().add(opcionVenderPropiedad);

        }
    }

    public void jugadorComproPropiedad() {

        this.jugadorComproPropiedad = true;
    }

    public void jugadorNoComproPropiedad(){

       this.jugadorComproPropiedad = false;

    }
}
