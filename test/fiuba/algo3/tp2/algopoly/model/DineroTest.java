package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

public class DineroTest {

    @Test
    public void testEqualsDevuelveTrueAlCompararMismasCantidades() {
        Dinero dinero10 = new Dinero(10);
        Dinero dinero20 = new Dinero(20);

        Assert.assertTrue(dinero10.equals(dinero20));
    }

    @Test
    public void testSumaIncrementaEn10LaCantidad() {
        Dinero dinero10 = new Dinero(10);
        
        dinero10.sumar(new Dinero(10));

        Assert.assertTrue(dinero10.equals(dinero10.getCantidad() + 10));
    }
    
    @Test
    public void testSumaDecrementaEn10LaCantidad() {
        Dinero dinero10 = new Dinero(10);
        
        dinero10.restar(new Dinero(10));

        Assert.assertTrue(dinero10.equals(dinero10.getCantidad() - 10));
    }

}
