package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;
import fiuba.algo3.tp2.algopoly.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.xml.bind.annotation.XmlType;
import java.nio.file.Paths;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu barraDeMenu;
    VBox panelIzquierdo;
    VBox panelDerecho;
    StackPane panelCentral;
    Stage stage;
    boolean jugadorComproPropiedad;
    boolean jugadorTieneQueVender;
    private MediaPlayer musica;


    public ContenedorPrincipal(Stage stage) {

        this.jugadorComproPropiedad = false;
        this.stage = stage;
        this.setBarraDeMenu(stage);
        this.setPanelIzquierdo();
        this.setPanelDerecho();
        this.setCentro();

    }

    public void reproducirMusica() {
        String pathMusicaDeFondo = Paths.get("src/fiuba/algo3/tp2/algopoly/vista/sonidos/SonidoJuego.mp3").toAbsolutePath().toUri().toString();
        Media cancionJuego1 = new Media(pathMusicaDeFondo);
        musica = new MediaPlayer(cancionJuego1);

        musica.setAutoPlay(true);
        musica.setCycleCount(MediaPlayer.INDEFINITE);

    }

    private void setBarraDeMenu(Stage stage) {

        this.barraDeMenu = new BarraDeMenu(stage, this);
        this.setTop(barraDeMenu);

    }

    public void setPanelIzquierdo() {

        Label acciones = new Label("ACCIONES DE JUGADOR");
        acciones.setTextFill(Color.web("#0066CC"));
        acciones.setFont(Font.font("Verdana", FontWeight.BOLD, 11));

        this.panelIzquierdo = new VBox();
        this.panelIzquierdo.setSpacing(100);
        this.panelIzquierdo.setPadding(new Insets(10));

        VBox accionesDeJugador = new VBox();
        accionesDeJugador.setSpacing(10);
        accionesDeJugador.setPadding(new Insets(10));
        accionesDeJugador.setAlignment(Pos.CENTER);

        Button botonTirarDadosYMover = new Button("Tirar Dados Y Mover");
        BotonTirarDadosYMoverEventHandler botonTirarDadosYMoverEventHandler = new BotonTirarDadosYMoverEventHandler(this.stage,this);
        botonTirarDadosYMover.setOnAction(botonTirarDadosYMoverEventHandler);
        botonTirarDadosYMover.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonTirarDadosYMover.setStyle("-fx-base: #FF6666;");

        Button botonComprarPropiedad = new Button("Comprar Propiedad");
        BotonComprarPropiedadEventHandler botonComprarPropiedadEventHandler = new BotonComprarPropiedadEventHandler(this.stage,this);
        botonComprarPropiedad.setOnAction(botonComprarPropiedadEventHandler);
        botonComprarPropiedad.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonComprarPropiedad.setStyle("-fx-base: #9999FF;");
        botonComprarPropiedad.setDisable(true);

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        if (jugadorActual.casilleroActual().esPropiedad()){
            botonComprarPropiedad.setDisable(false);
        }

        MenuButton botonVenderPropiedad = new MenuButton("Vender Propiedad");
        botonVenderPropiedad.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonVenderPropiedad.setStyle("-fx-base: #FFCCFF;");

        if (jugadorActual.getPropiedades().isEmpty()){

            botonVenderPropiedad.setDisable(true);

        }

        this.agregarPropiedadesAMenuVenderPropiedades(botonVenderPropiedad);

        Button botonIntercambiarPropiedades = new Button("Intercambiar Propiedades");
        BotonIntercambiarPropiedadesEventHandler botonIntercambiarPropiedadesEventHandler = new BotonIntercambiarPropiedadesEventHandler(this.stage,this);
        botonIntercambiarPropiedades.setOnAction(botonIntercambiarPropiedadesEventHandler);
        botonIntercambiarPropiedades.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonIntercambiarPropiedades.setStyle("-fx-base: #99FF99;");
        botonIntercambiarPropiedades.setDisable(true);
        habilitarBotonDeIntercambiarPropiedad(botonIntercambiarPropiedades);

        Button botonConstruirCasa = new Button("Construir casa");
        BotonConstruirCasaEventHandler botonConstruirCasaEventHandler = new BotonConstruirCasaEventHandler(this.stage,this);
        botonConstruirCasa.setOnAction(botonConstruirCasaEventHandler);
        botonConstruirCasa.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonConstruirCasa.setStyle("-fx-base: #FFCC99;");
        botonConstruirCasa.setDisable(true);
        habilitarBotonDeEdificarEnPropiedad(botonConstruirCasa);

        Button botonConstruirHotel = new Button("Construir hotel");
        BotonConstruirHotelEventHandler botonConstruirHotelEventHandler = new BotonConstruirHotelEventHandler(this.stage,this);
        botonConstruirHotel.setOnAction(botonConstruirHotelEventHandler);
        botonConstruirHotel.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonConstruirHotel.setStyle("-fx-base: #CCFFFF;");
        botonConstruirHotel.setDisable(true);
        habilitarBotonDeEdificarEnPropiedad(botonConstruirHotel);


        if (this.jugadorComproPropiedad){
            botonConstruirHotel.setDisable(true);
            botonConstruirCasa.setDisable(true);
            botonIntercambiarPropiedades.setDisable(true);
            this.jugadorComproPropiedad = false;
        }

        Button botonPagarFianza = new Button("Pagar Fianza");
        BotonPagarFianzaEventHandler botonPagarFianzaEventHandler = new BotonPagarFianzaEventHandler(this.stage,this);
        botonPagarFianza.setOnAction(botonPagarFianzaEventHandler);
        botonPagarFianza.setFont((Font.font("Verdana", FontWeight.BOLD, 12)));
        botonPagarFianza.setStyle("-fx-base: #FFFFCC;");
        botonPagarFianza.setDisable(true);

        if (jugadorActual.casilleroActual().getNombre().equals("Carcel") && jugadorActual.getEstado() != "Libre") {
            botonPagarFianza.setDisable(false);
        }

        accionesDeJugador.getChildren().addAll(acciones,botonTirarDadosYMover,botonComprarPropiedad,botonVenderPropiedad,botonIntercambiarPropiedades,botonConstruirCasa,botonConstruirHotel,botonPagarFianza);

        InformacionJugadorVista informacionJugadorVista= new InformacionJugadorVista();
        panelIzquierdo.getChildren().addAll(accionesDeJugador,informacionJugadorVista);
        this.setLeft(this.panelIzquierdo);

        Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/fondo_paneles2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.panelIzquierdo.setBackground(new Background(imagenDeFondo));

    }

    public void setPanelDerecho() {

        this.panelDerecho = new VBox();
        this.panelDerecho.setSpacing(100);
        this.panelDerecho.setPadding(new Insets(10));


        InformacionCasilleroVista informacionCasilleroVista= new InformacionCasilleroVista();
        JugadoresRestantesVista jugadoresRestantesVista = new JugadoresRestantesVista();
        jugadoresRestantesVista.setContenido();
        this.panelDerecho.getChildren().addAll(informacionCasilleroVista,jugadoresRestantesVista);
        this.setRight(this.panelDerecho);

        Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/fondo_paneles2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.panelDerecho.setBackground(new Background(imagenDeFondo));

    }

    public void setCentro() {

        this.panelCentral = new StackPane();

        Canvas canvas = new Canvas (660, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(255,255,255,0.1));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Canvas canvasImagen = new Canvas(560,400);
        Image imagenCanvas = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/algopolyCentro.png");
        canvasImagen.getGraphicsContext2D().drawImage(imagenCanvas,0,0);

        Image imagen = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/fondo_paneles2.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(200, 200, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        this.panelCentral.setBackground(new Background(imagenDeFondo));


        new JugadoresVista(gc);

        this.panelCentral.getChildren().addAll(new TableroVista(panelDerecho), canvas,canvasImagen);

        this.setCenter(this.panelCentral);
    }


    public BarraDeMenu getBarraDeMenu() {
        return barraDeMenu;
    }

    private void agregarPropiedadesAMenuVenderPropiedades(MenuButton botonPropiedades) {

        Jugador jugadorActual = Juego.getInstance().getJugadorActual();

        for ( Propiedad propiedad : jugadorActual.getPropiedades() ) {


            MenuItem opcionVenderPropiedad = new MenuItem(propiedad.getNombre());
            OpcionVenderPropiedadEventHandler opcionVenderPropiedadEventHandler = new OpcionVenderPropiedadEventHandler(propiedad,this.stage,this);
            opcionVenderPropiedad.setOnAction(opcionVenderPropiedadEventHandler);

            botonPropiedades.getItems().add(opcionVenderPropiedad);

        }
    }


    private void habilitarBotonDeIntercambiarPropiedad(Button boton) {

        Juego juego = Juego.getInstance();
        Jugador jugadorActual = juego.getJugadorActual();

        if (jugadorActual.casilleroActual().esPropiedad()){

            Tablero tablero = Juego.getInstance().getTablero();
            Encasillable casilleroActual = juego.getJugadorActual().casilleroActual();
            Propiedad propiedad;

            try {
                propiedad = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());
            }catch (NullPointerException e) {

                try {
                    propiedad = tablero.obtenerCompaniaPorNombre(casilleroActual.getNombre());
                } catch (NullPointerException x) {return;}
            }

            if (jugadorActual.esPropietarioDe(propiedad)) {
                boton.setDisable(false);
            }
        }

    }

    private void habilitarBotonDeEdificarEnPropiedad(Button boton) {

        Juego juego = Juego.getInstance();
        Jugador jugadorActual = juego.getJugadorActual();

        if (jugadorActual.casilleroActual().esPropiedad()){

            Tablero tablero = Juego.getInstance().getTablero();
            Encasillable casilleroActual = juego.getJugadorActual().casilleroActual();
            Propiedad propiedad;

            try {

                propiedad = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());
            }catch (NullPointerException e){return;}

            if (jugadorActual.esPropietarioDe(propiedad)) {
                boton.setDisable(false);
            }
        }
    }

    public boolean getJugadorTieneQueVender(){

        return jugadorTieneQueVender;


    }

    public void jugadorComproPropiedad() {

        this.jugadorComproPropiedad = true;
    }

    public void jugadorNoComproPropiedad(){

       this.jugadorComproPropiedad = false;

    }

    public void jugadorTieneQueVender() {

        this.jugadorTieneQueVender = true;
    }

    public void setJugadorTieneQueVender(boolean jugadorTieneQueVender) {

        this.jugadorTieneQueVender = jugadorTieneQueVender;
    }

    public void pararMusica() {
        this.musica.stop();
    }
}
