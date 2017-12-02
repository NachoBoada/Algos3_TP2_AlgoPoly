package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.casillero.NoSePuedeComprarUnBarrioYaComprado;
import fiuba.algo3.tp2.algopoly.model.casillero.Propiedad;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import fiuba.algo3.tp2.algopoly.model.estado.JugadorPresoNoSePuedeMoverException;
import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {



    @Test
    public void testJuegoPasaCorrectamenteDeTurno(){

        Juego.getInstance().comenzarJuego(2000);
        Jugador primerJugador = Juego.getInstance().getJugadorActual();

        TiroDeDados tiro = primerJugador.tirarDadosParaTests(1,3);

        primerJugador.mover(tiro.resultado());

        Juego.getInstance().turnoProximojugador();

        Jugador segundoJugador = Juego.getInstance().getJugadorActual();


        Assert.assertEquals("Jugador 2",segundoJugador.getNombreJugador());

    }

    @Test (expected = JugadorPresoNoSePuedeMoverException.class)
    public void testJugadorPresoNoPuedeMoverseYPasaTurno(){

        Juego.getInstance().comenzarJuego(100000);

        Jugador jugador = Juego.getInstance().getJugadorActual();
        TiroDeDados tiro = jugador.tirarDadosParaTests(2,3);
        jugador.mover(tiro.resultado());
        Juego.getInstance().turnoProximojugador();

        jugador = Juego.getInstance().getJugadorActual();
        tiro = jugador.tirarDadosParaTests(1,2);
        jugador.mover(tiro.resultado());
        Juego.getInstance().turnoProximojugador();

        jugador = Juego.getInstance().getJugadorActual();
        tiro = jugador.tirarDadosParaTests(1,2);
        jugador.mover(tiro.resultado());
        Juego.getInstance().turnoProximojugador();

        jugador = Juego.getInstance().getJugadorActual();
        tiro = jugador.tirarDadosParaTests(1,2);
        jugador.mover(tiro.resultado());


    }

    @Test
    public void testJugadorCompraPropiedadDeCasilleroActual(){

        Juego.getInstance().comenzarJuego(100000);

        Jugador jugador = Juego.getInstance().getJugadorActual();
        TiroDeDados tiro = jugador.tirarDadosParaTests(1,2);
        jugador.mover(tiro.resultado());
        Juego.getInstance().turnoProximojugador();

        jugador = Juego.getInstance().getJugadorActual();
        tiro = jugador.tirarDadosParaTests(4,2);
        jugador.mover(tiro.resultado());
        Juego.getInstance().turnoProximojugador();

        jugador = Juego.getInstance().getJugadorActual();
        tiro = jugador.tirarDadosParaTests(7,2);
        jugador.mover(tiro.resultado());
        Juego.getInstance().turnoProximojugador();

        jugador = Juego.getInstance().getJugadorActual();
        Encasillable casilleroActual = jugador.casilleroActual();
        Tablero tablero = Juego.getInstance().getTablero();

        Propiedad propiedadAComprar;

        try{

            propiedadAComprar = tablero.obtenerBarrioPorNombre(casilleroActual.getNombre());

        }catch (NullPointerException e){

            propiedadAComprar = tablero.obtenerCompaniaPorNombre(casilleroActual.getNombre());

        }

        jugador.comprarPropiedad(propiedadAComprar);

    }

    @Test (expected = NoSePuedeComprarUnBarrioYaComprado.class)
    public void testNoSePuedeComprarUnBarrioYaComprado(){

        Juego juego = Juego.getInstance();
        juego.comenzarJuego(100000);
        Jugador jugador1 = Juego.getInstance().obtenerJugador("Jugador 1");
        Jugador jugador2 = Juego.getInstance().obtenerJugador("Jugador 2");

        jugador1.comprarPropiedad(juego.getTablero().obtenerBarrioPorNombre("Buenos Aires Norte"));
        jugador2.comprarPropiedad(juego.getTablero().obtenerBarrioPorNombre("Buenos Aires Norte"));


    }

    @Test
    public void test(){

        Juego juego = Juego.getInstance();
        juego.comenzarJuego(100000);
        Jugador jugador1 = juego.obtenerJugador("Jugador 1");

        juego.getJugadorActual().tirarDados();
        juego.turnoProximojugador();

        juego.getJugadorActual().tirarDados();
        juego.turnoProximojugador();


        juego.getJugadorActual().tirarDados();
        juego.turnoProximojugador();

        juego.jugadorPierdeElJuego(juego.obtenerJugador("Jugador 3"));

        juego.getJugadorActual().tirarDados();
        juego.turnoProximojugador();
    }
}
