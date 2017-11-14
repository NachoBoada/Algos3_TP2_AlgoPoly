package fiuba.algo3.tp2.algopoly.model.quini6;

import fiuba.algo3.tp2.algopoly.model.boleta.Premio;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.Capital;
import org.junit.Assert;
import org.junit.Test;

public class BoletoTest {

    @Test
    public void testAlCrearBoletoSuPremioEsPremio1() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        Premio premio = boleto.getPremio();
        
        Assert.assertTrue(premio.getValor().equals(new Capital(50000)));
    }
    
    @Test
    public void testActualizarPremioActualizaApremio2CuandoElActualEsPremio1() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        boleto.actualizarPremio();
        Premio segundoPremio = boleto.getPremio();
        
        Capital valorSegundoPremio = segundoPremio.getValor();
        
        Assert.assertTrue(valorSegundoPremio.equals(new Capital(30000)));
    }
    
    @Test
    public void testActualizarPremioActualizaApremioSinValorCuandoElActualEsPremio2() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        boleto.actualizarPremio();
        boleto.actualizarPremio();
        Premio premioSinValor = boleto.getPremio();
        
        Capital valorPremioSinValor = premioSinValor.getValor();
        
        Assert.assertTrue(valorPremioSinValor.equals(new Capital(30000)));
    }
    
    @Test
    public void testActualizarPremioActualizaApremioSinValorCuandoElActualEsPremioSinValor() {
        BoletaQuini6 boleto = new BoletaQuini6();
        
        boleto.actualizarPremio();
        boleto.actualizarPremio();
        boleto.actualizarPremio();
        Premio premioSinValor = boleto.getPremio();
        
        Capital valorPremioSinValor = premioSinValor.getValor();
        
        Assert.assertTrue(valorPremioSinValor.equals(new Capital(30000)));
    }

}
