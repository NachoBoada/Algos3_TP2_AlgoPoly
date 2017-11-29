package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.*;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.*;
import fiuba.algo3.tp2.algopoly.model.dados.TiroDeDados;
import org.junit.Assert;
import org.junit.Test;

public class TerceraEntregaTest {

    private static final double DELTA = 1e-15;

    @Test
    public void test01JugadorTiraDadosAmbosConIgualValorEntoncesPuedeVolverATirar() {
        Juego juego = Juego.getInstance();
        juego.comenzarJuego();

        Jugador primerJugador = juego.getJugadorActual();
        TiroDeDados tiroDeDados = primerJugador.tirarDadosParaTests(2, 2);
        juego.turnoProximojugador();

        Assert.assertTrue(tiroDeDados.esDuplicado());
        Assert.assertEquals(primerJugador, juego.getJugadorActual());
    }

    @Test
    public void test02JugadorTiraDadosAmbosConIgualValorEnDosOportunidadesEntoncesSalteaElSegundoTiroYavanzaElTurno() {
        Juego juego = Juego.getInstance();
        juego.comenzarJuego();

        Jugador primerJugador = juego.getJugadorActual();

        TiroDeDados primerTiroDeDados = primerJugador.tirarDadosParaTests(2, 2);
        juego.turnoProximojugador();
        Assert.assertTrue(primerTiroDeDados.esDuplicado());
        Assert.assertEquals(primerJugador, juego.getJugadorActual());

        TiroDeDados segundoTiroDeDados = primerJugador.tirarDadosParaTests(2, 2);
        juego.turnoProximojugador();
        Assert.assertTrue(segundoTiroDeDados.esDuplicado());
        Jugador segundoJugador = juego.getJugadorActual();
        Assert.assertNotEquals(primerJugador, segundoJugador);
    }

    @Test
    public void testPunto3() {

        /* Un jugador no cuenta con efectivo y cae en un área que genera gasto.
        Se verifica que un tercer jugador cae en el área que entregó el primer jugador
         y el cobro del dinero se acredita en la cuenta del jugador que ostenta la titularidad por un monto igual al área sin construcción.
        */

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador(new Dinero(20000), tablero);
        Jugador jugador2 = new Jugador(new Dinero(100000), tablero);
        Jugador jugador3 = new Jugador(new Dinero(100000), tablero);
        Barrio cordobaNorte = tablero.obtenerBarrioPorNombre("Cordoba Norte");
        Barrio santaFe = tablero.obtenerBarrioPorNombre("Santa Fe");

        jugador1.comprarPropiedad(cordobaNorte);
        jugador2.comprarPropiedad(santaFe);

        try {

            jugador1.caerEn(santaFe);

        } catch (ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException e) {

            jugador1.venderPropiedad(cordobaNorte);

        }

        jugador2.comprarPropiedad(cordobaNorte);
        jugador3.caerEn(cordobaNorte);

        Assert.assertEquals(100000 - 15000 - 20000 + 1300, jugador2.getCapital().getCantidad(), DELTA);
    }

    @Test
    public void test04JugadorCambiaSuPosicionActualAlaIndicadaPorLosDadosLuegoDeTirar() {
        Juego juego = Juego.getInstance();
        juego.comenzarJuego();

        Jugador primerJugador = juego.getJugadorActual();
        int posicionActual = primerJugador.posicionActual();

        TiroDeDados tiroDeDados = primerJugador.tirarDadosParaTests(1, 1);
        primerJugador.mover(tiroDeDados.resultado());

        Assert.assertEquals(primerJugador.posicionActual(), posicionActual + 2);

    }

    @Test(expected = NoSePuedeConstruirUnHotelEnUnBarrioSimpleException.class)
    public void testPunto5() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(new Dinero(100000), tablero);
        Barrio barrioSimple = tablero.obtenerBarrioPorNombre("Santa Fe");

        jugador.comprarPropiedad(barrioSimple);
        jugador.construirHotelEn(barrioSimple);

    }

}
