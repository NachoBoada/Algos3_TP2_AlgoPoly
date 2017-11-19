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
        final int valorTiro = dados.tirar();
        Assert.assertTrue(valorTiro >= 1 && valorTiro <= 12);
    }

}
