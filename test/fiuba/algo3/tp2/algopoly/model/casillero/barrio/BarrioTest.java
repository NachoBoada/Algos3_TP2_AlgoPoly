package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.Tablero;
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

        Assert.assertEquals(precioBarrio.getCantidad(), santaFe.getPrecio().getCantidad(),DELTA);
    }

    @Test
    public void modificarPropietarioCambiaElPropietarioDelBarrio() {

        Tablero tablero = new Tablero();
        Dinero capitalInicial = new Dinero(100000);
        Jugador unJugador = new Jugador(capitalInicial,tablero,"Jugador 1");
        Barrio santaFe = tablero.obtenerBarrioPorNombre("Santa Fe");

        santaFe.modificarPropietario(unJugador);

        Assert.assertEquals(unJugador, santaFe.getPropietario());
    }
}
