package fiuba.algo3.tp2.algopoly.model;

import org.junit.Assert;
import org.junit.Test;

public class CapitalTest {

    @Test
    public void testEqualsDevuelveTrueAlCompararMismasCantidades() {
        Capital dinero10 = new Capital(10);
        Capital dinero20 = new Capital(20);

        Assert.assertTrue(dinero10.equals(dinero20));
    }

    @Test
    public void testSumaIncrementaEn10LaCantidad() {
        Capital dinero10 = new Capital(10);
        
        dinero10.sumar(new Capital(10));

        Assert.assertTrue(dinero10.equals(dinero10.getCantidad() + 10));
    }
    
    @Test
    public void testSumaDecrementaEn10LaCantidad() {
        Capital dinero10 = new Capital(10);
        
        dinero10.restar(new Capital(10));

        Assert.assertTrue(dinero10.equals(dinero10.getCantidad() - 10));
    }

}
