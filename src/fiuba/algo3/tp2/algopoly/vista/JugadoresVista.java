package fiuba.algo3.tp2.algopoly.vista;

import fiuba.algo3.tp2.algopoly.model.Juego;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class JugadoresVista  {

    private HashMap<Integer, Integer> posicionX;
    private HashMap<Integer, Integer> posicionY;
    private static final int diametro = 10;

    private LinkedList<Jugador> jugadores;


    public JugadoresVista(GraphicsContext gc) {

        this.posicionX = getHashMapPosicionesX();
        this.posicionY = getHashMapPosicionesY();

        this.jugadores = Juego.getInstance().getJugadores();

        ListIterator<Jugador> iterador = jugadores.listIterator();

        while (iterador.hasNext()) {

            Integer pos = iterador.next().getPosicionActual();
            gc.setFill(Color.MEDIUMBLUE);
            gc.fillOval(posicionX.get(pos), posicionY.get(pos), diametro, diametro);
        }

    }



    private HashMap getHashMapPosicionesX () {

        HashMap<Integer,Integer> mapaPosiciones = new HashMap<>();

        mapaPosiciones.put(0,635);
        mapaPosiciones.put(1,540);
        mapaPosiciones.put(2,400);
        mapaPosiciones.put(3,260);
        mapaPosiciones.put(4,120);
        mapaPosiciones.put(5,25);
        mapaPosiciones.put(6,25);
        mapaPosiciones.put(7,25);
        mapaPosiciones.put(8,25);
        mapaPosiciones.put(9,25);
        mapaPosiciones.put(10,25);
        mapaPosiciones.put(11,120);
        mapaPosiciones.put(12,260);
        mapaPosiciones.put(13,400);
        mapaPosiciones.put(14,540);
        mapaPosiciones.put(15,635);
        mapaPosiciones.put(16,635);
        mapaPosiciones.put(17,635);
        mapaPosiciones.put(18,635);
        mapaPosiciones.put(19,635);



        return mapaPosiciones;
    }

    private HashMap getHashMapPosicionesY() {

        HashMap<Integer,Integer> mapaPosiciones = new HashMap<>();

        mapaPosiciones.put(0,475);
        mapaPosiciones.put(1,475);
        mapaPosiciones.put(2,475);
        mapaPosiciones.put(3,475);
        mapaPosiciones.put(4,475);
        mapaPosiciones.put(5,475);
        mapaPosiciones.put(6,400);
        mapaPosiciones.put(7,300);
        mapaPosiciones.put(8,200);
        mapaPosiciones.put(9,100);
        mapaPosiciones.put(10,25);
        mapaPosiciones.put(11,25);
        mapaPosiciones.put(12,25);
        mapaPosiciones.put(13,25);
        mapaPosiciones.put(14,25);
        mapaPosiciones.put(15,25);
        mapaPosiciones.put(16,100);
        mapaPosiciones.put(17,200);
        mapaPosiciones.put(18,300);
        mapaPosiciones.put(19,400);



        return mapaPosiciones;
    }

}
