package treinamento2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class ParcelamentoComArrayTest {

	@Test
	public void testarParcelamentoComParcelasIguais() {
		BigDecimal[] parcelas = ParcelamentoComArray.realizaParcelamento(100, 3);

		BigDecimal valorTotalDoParcelamento = BigDecimal.ZERO;
		for (int parcela = 0; parcela < parcelas.length; parcela++) {
			valorTotalDoParcelamento = valorTotalDoParcelamento.add(parcelas[parcela]);
		}

		assertEquals(new BigDecimal("100.00"), valorTotalDoParcelamento);
		assertEquals(3, parcelas.length);
		assertArrayEquals(
				new BigDecimal[] { new BigDecimal("33.34"), new BigDecimal("33.33"), new BigDecimal("33.33") },
				parcelas);

		parcelas = ParcelamentoComArray.realizaParcelamento(200, 5);
		assertArrayEquals(new BigDecimal[] { new BigDecimal("40.00"), new BigDecimal("40.00"), new BigDecimal("40.00"),
				new BigDecimal("40.00"), new BigDecimal("40.00") }, parcelas);
	}
	
	@Test(expected = QuantidadeDeParcelasComValorInvalidoException.class)
	public void testaParcelamentoComQuantidadeDeParcelasInvalida() {
		ParcelamentoComArray.realizaParcelamento(100, -3);
	}
	
	@Test(expected = ValorTotalAParcelarComValorInvalidoException.class)
	public void testaParcelamentoComValorTotalAParcelarInvalido() {
		ParcelamentoComArray.realizaParcelamento(-100, 3);
	}
	
	@Test(expected = ValorTotalAParcelarComValorInvalidoException.class)
	public void testaParcelamentoComValorTotalAParcelarComNumeroCasasDecimaisInvalido() {
		ParcelamentoComArray.realizaParcelamento(100.001, 3);
	}
}
