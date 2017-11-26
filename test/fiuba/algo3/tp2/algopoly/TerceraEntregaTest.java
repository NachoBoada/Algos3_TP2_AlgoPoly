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
        /*Un jugador arroja los dados y ambos tienen el mismo valor. Verificar que puede volver a jugar.*/
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
        /*Un jugador arroja los dados y ambos tienen el mismo valor. Verificar que puede volver a jugar.*/
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

    @Test(expected = NoSePuedeConstruirUnHotelEnUnBarrioSimpleException.class)
    public void testPunto5() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(new Dinero(100000), tablero);
        Barrio barrioSimple = new SantaFe();

        jugador.comprarBarrio(barrioSimple);
        jugador.construirHotelEn(barrioSimple);

    }
}
