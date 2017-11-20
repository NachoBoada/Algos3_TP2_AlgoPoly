package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.casillero.barrio.BarrioSimple;
import fiuba.algo3.tp2.algopoly.model.casillero.barrio.SantaFe;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;

public class BarrioTest {

    private static final double DELTA = 1e-15;

    @Test
    public void getPrecioDelBarrioDevuelveElPrecioCorrectamente() {

        SantaFe santaFe = new SantaFe();
        Dinero precioBarrio = new Dinero(15000);

        Assert.assertEquals(precioBarrio.getCantidad(), santaFe.getPrecioDelBarrio().getCantidad(),DELTA);
    }

    @Test
    public void modificarPropietarioCambiaElPropietarioDelBarrio() {

        Dinero capitalInicial = new Dinero(100000);
        Jugador unJugador = new Jugador(capitalInicial);
        Barrio santaFe = new SantaFe();

        santaFe.modificarPropietario(unJugador);

        Assert.assertEquals(unJugador, santaFe.getPropietario());
    }
}
