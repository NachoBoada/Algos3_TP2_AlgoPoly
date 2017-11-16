package fiuba.algo3.tp2.algopoly.model;

import fiuba.algo3.tp2.algopoly.model.boleta.Premio;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import org.junit.Assert;
import org.junit.Test;

public class BoletoTest {

    @Test
    public void testAlCrearBoletoSuPremioEsPremio1() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        Premio premio = boleto.getPremio();
        
        Assert.assertTrue(premio.getValor().equals(new Dinero(50000)));
    }
    
    @Test
    public void testActualizarPremioActualizaApremio2CuandoElActualEsPremio1() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        boleto.actualizarPremio();
        Premio segundoPremio = boleto.getPremio();
        
        Dinero valorSegundoPremio = segundoPremio.getValor();
        
        Assert.assertTrue(valorSegundoPremio.equals(new Dinero(30000)));
    }
    
    @Test
    public void testActualizarPremioActualizaApremioSinValorCuandoElActualEsPremio2() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        boleto.actualizarPremio();
        boleto.actualizarPremio();
        Premio premioSinValor = boleto.getPremio();
        
        Dinero valorPremioSinValor = premioSinValor.getValor();
        
        Assert.assertTrue(valorPremioSinValor.equals(new Dinero(0)));
    }
    
    @Test
    public void testActualizarPremioActualizaApremioSinValorCuandoElActualEsPremioSinValor() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        boleto.actualizarPremio();
        boleto.actualizarPremio();
        boleto.actualizarPremio();
        Premio premioSinValor = boleto.getPremio();
        
        Dinero valorPremioSinValor = premioSinValor.getValor();
        
        Assert.assertTrue(valorPremioSinValor.equals(new Dinero(0)));
    }

}
