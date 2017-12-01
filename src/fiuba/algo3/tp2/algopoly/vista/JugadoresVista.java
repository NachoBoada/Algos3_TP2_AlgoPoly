package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class JugadoresVista  {

    private HashMap<Integer, Double> posicionX;
    private HashMap<Integer, Double> posicionY;
    private double anchoImagen = 40;
    private double altoImagen = 30;
    private Image pieza1;
    private Image pieza2;
    private Image pieza3;

    private LinkedList<Jugador> jugadores;


    public JugadoresVista(GraphicsContext gc) {

        this.pieza1 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_sombrero.png");
        this.pieza2 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_auto.png");
        this.pieza3 = new Image("file:src/fiuba/algo3/tp2/algopoly/vista/imagenes/pieza_zapato.png");

        this.posicionX = getHashMapPosicionesX();
        this.posicionY = getHashMapPosicionesY();

        this.jugadores = Juego.getInstance().getJugadores();
        ListIterator<Jugador> iterador = jugadores.listIterator();

        while (iterador.hasNext()) {
            Jugador jugador = iterador.next();
            Integer pos = jugador.getPosicionActual();

            if (jugador.getNombreJugador().equals("Jugador 1")) {
                gc.drawImage(pieza1, posicionX.get(pos), posicionY.get(pos));
            }

            if (jugador.getNombreJugador().equals("Jugador 2")) {
                gc.drawImage(pieza2, posicionX.get(pos), posicionY.get(pos));
            }

            if (jugador.getNombreJugador().equals("Jugador 3")) {
                gc.drawImage(pieza3, posicionX.get(pos), posicionY.get(pos));
            }
        }
    }



    private HashMap getHashMapPosicionesX () {

        HashMap<Integer,Double> mapaPosiciones = new HashMap<>();

        mapaPosiciones.put(0,610.0);
        mapaPosiciones.put(1,540.0);
        mapaPosiciones.put(2,400.0);
        mapaPosiciones.put(3,260.0);
        mapaPosiciones.put(4,120.0);
        mapaPosiciones.put(5,50-anchoImagen);
        mapaPosiciones.put(6,50-anchoImagen);
        mapaPosiciones.put(7,50-anchoImagen);
        mapaPosiciones.put(8,50-anchoImagen);
        mapaPosiciones.put(9,50-anchoImagen);
        mapaPosiciones.put(10,50-anchoImagen);
        mapaPosiciones.put(11,120.0);
        mapaPosiciones.put(12,260.0);
        mapaPosiciones.put(13,400.0);
        mapaPosiciones.put(14,540.0);
        mapaPosiciones.put(15,610.0);
        mapaPosiciones.put(16,610.0);
        mapaPosiciones.put(17,610.0);
        mapaPosiciones.put(18,610.0);
        mapaPosiciones.put(19,610.0);

        return mapaPosiciones;
    }

    private HashMap getHashMapPosicionesY() {

        HashMap<Integer,Double> mapaPosiciones = new HashMap<>();

        mapaPosiciones.put(0,450.0);
        mapaPosiciones.put(1,450.0);
        mapaPosiciones.put(2,450.0);
        mapaPosiciones.put(3,450.0);
        mapaPosiciones.put(4,450.0);
        mapaPosiciones.put(5,450.0);
        mapaPosiciones.put(6,400.0);
        mapaPosiciones.put(7,300.0);
        mapaPosiciones.put(8,200.0);
        mapaPosiciones.put(9,100.0);
        mapaPosiciones.put(10,50-altoImagen);
        mapaPosiciones.put(11,50-altoImagen);
        mapaPosiciones.put(12,50-altoImagen);
        mapaPosiciones.put(13,50-altoImagen);
        mapaPosiciones.put(14,50-altoImagen);
        mapaPosiciones.put(15,50-altoImagen);
        mapaPosiciones.put(16,100.0);
        mapaPosiciones.put(17,200.0);
        mapaPosiciones.put(18,300.0);
        mapaPosiciones.put(19,400.0);

        return mapaPosiciones;
    }
}
