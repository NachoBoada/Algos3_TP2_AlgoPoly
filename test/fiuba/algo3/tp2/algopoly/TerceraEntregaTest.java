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
    public void test01Punto3() {

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador(new Dinero(20000), tablero);
        Jugador jugador2 = new Jugador(new Dinero(100000), tablero);
        Jugador jugador3 = new Jugador(new Dinero(100000), tablero);
        Region cordoba = new Cordoba();
        Barrio cordobaNorte = new CordobaNorte(cordoba);
        Barrio santaFe = new SantaFe();

        jugador1.comprarBarrio(cordobaNorte);
        jugador2.comprarBarrio(santaFe);

        try {

            jugador1.caerEn(santaFe);

        } catch (ElJugadorDebeVenderPropiedadesPorCapitalInsuficienteException e) {

            jugador1.venderBarrio(cordobaNorte);

        }

        jugador2.comprarBarrio(cordobaNorte);
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
        Barrio barrioSimple = new SantaFe();

        jugador.comprarBarrio(barrioSimple);
        jugador.construirHotelEn(barrioSimple);

    }
}
