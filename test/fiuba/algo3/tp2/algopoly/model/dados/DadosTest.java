package fiuba.algo3.tp2.algopoly.model.dados;

import org.junit.Assert;
import org.junit.Test;

public class DadosTest {

    @Test
    public void testDadosGetInstanceNoDevuelveNulo() {
        Assert.assertNotNull(Dados.getInstance());
    }

    @Test
    public void testDadosTirarDevuelveValorEntreUnoYdoce() {
        final Dados dados = Dados.getInstance();
        final TiroDeDados tiroDeDados = dados.tirar();
        Assert.assertTrue(tiroDeDados.esValido());
    }
    
}
