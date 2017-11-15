package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.casillero.Quini6;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test03JugadorCaeEnQuini6PorTerceraYCuartaVezSuCapitalNoSeIncrementa() {
        Dinero capitalInicial = new Dinero(0);
        Jugador jugador = new Jugador(capitalInicial);
        Quini6 quini6 = new Quini6();

        jugador.caerEn(quini6);
        jugador.caerEn(quini6);
        jugador.caerEn(quini6);
        jugador.caerEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

}
