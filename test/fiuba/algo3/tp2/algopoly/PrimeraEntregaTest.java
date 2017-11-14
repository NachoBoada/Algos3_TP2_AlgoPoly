package fiuba.algo3.tp2.algopoly;

import fiuba.algo3.tp2.algopoly.model.Capital;
import fiuba.algo3.tp2.algopoly.model.casillero.Quini6;
import org.junit.Assert;
import org.junit.Test;

public class PrimeraEntregaTest {

    @Test
    public void test01JugadorCaeEnQuini6PorPrimeraVezSuCapitalSeIncrementaEn50000() {
        Capital capitalInicial = new Capital(0);
        Jugador jugador = new Jugador(capitalInicial);
        Casillero quini6 = new Quini6();

        jugador.caeEn(quini6);

        Assert.assertEquals(50000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test02JugadorCaeEnQuini6PorSegundaVezSuCapitalSeIncrementaEn30000() {
        Capital capitalInicial = new Capital(0);
        Jugador jugador = new Jugador(capitalInicial);
        Casillero quini6 = new Quini6();

        jugador.caeEn(quini6);
        jugador.caeEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

    @Test
    public void test03JugadorCaeEnQuini6PorTerceraYCuartaVezSuCapitalNoSeIncrementa() {
        Capital capitalInicial = new Capital(0);
        Jugador jugador = new Jugador(capitalInicial);
        Casillero quini6 = new Quini6();

        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);
        jugador.caeEn(quini6);

        Assert.assertEquals(50000 + 30000, jugador.getCapital().getCantidad());
    }

}