package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.algopoly.model.casillero.barrio.Barrio;

public class BarrioTest {
    @Test
    public void getPrecioDelBarrioDevuelveElPrecioCorrectamente() {
        Dinero precioBarrio = new Dinero(10000);
        Barrio SantaFe = new Barrio(precioBarrio);

        Assert.assertEquals(precioBarrio, SantaFe.getPrecioDelBarrio());
    }

    @Test
    public void modificarPropietarioCambiaElPropietarioDelBarrio() {
        Dinero capitalInicial = new Dinero(100000);
        Dinero precioBarrio = new Dinero(10000);
        Jugador unJugador = new Jugador(capitalInicial);
        Barrio Cordoba = new Barrio(precioBarrio);

        Cordoba.modificarPropietario(unJugador);

        Assert.assertEquals(unJugador, Cordoba.getPropietario());
    }
}
