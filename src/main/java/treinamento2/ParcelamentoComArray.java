package treinamento2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParcelamentoComArray {

//	int[] idades = {11, 22, 33, 44, 55};
//	int[] valores = new int[10];
//	Integer[] valoresInteger = {};
	
	private static double valorTotal = 0;
	private static int quantidadeDeParcelas = 0;
	private static BigDecimal[] parcelas = {};
	
	
	public static void main(String[] args) {
		valorTotal = Double.valueOf(args[0]);
		quantidadeDeParcelas = Integer.valueOf(args[1]);
		parcelas = new BigDecimal[quantidadeDeParcelas];
		
		System.out.println("Valor total: " + args[0] + ", quantidade de parcelas: " + args[1]);

//		BigDecimal valorTotalEmBigDecimal = BigDecimal.valueOf(valorTotal);
//		valorTotalEmBigDecimal = valorTotalEmBigDecimal.setScale(3, RoundingMode.FLOOR);
//		System.out.println(valorTotalEmBigDecimal);
		
		parcelas = realizaParcelamento(valorTotal, quantidadeDeParcelas);
		imprimeParcelasNoConsole();
	}


	public static BigDecimal[] realizaParcelamento(double valorTotal, int quantidadeDeParcelas) {
		validaParametrosRealizacaoParcelamento(valorTotal, quantidadeDeParcelas);
		BigDecimal valorBigDecimal = BigDecimal.valueOf(valorTotal);
		BigDecimal valorDaParcela = valorBigDecimal.divide(BigDecimal.valueOf(quantidadeDeParcelas), 2, RoundingMode.FLOOR);
		BigDecimal resto = valorBigDecimal.subtract(valorDaParcela.multiply(BigDecimal.valueOf(quantidadeDeParcelas)));
		BigDecimal[] parcelamento = new BigDecimal[quantidadeDeParcelas];
		parcelamento[0] = valorDaParcela.add(resto);
		for(int parcela = 1; parcela < quantidadeDeParcelas; parcela++) {
			parcelamento[parcela] = valorDaParcela;
		}
		return parcelamento;
	}


	private static void validaParametrosRealizacaoParcelamento(double valorTotal, int quantidadeDeParcelas) {
		if(quantidadeDeParcelas <= 0) {
			throw new QuantidadeDeParcelasComValorInvalidoException("Quantidade de parcelas deve ser maior que 0.");
		}
		if(valorTotal <= 0) {
			throw new ValorTotalAParcelarComValorInvalidoException();
		}
		if(BigDecimal.valueOf(valorTotal).scale() > 2) {
			throw new ValorTotalAParcelarComValorInvalidoException();
		}
	}
	
	private static void imprimeParcelasNoConsole() {
		for(int parcela = 0; parcela < parcelas.length; parcela++) {
			imprimirParcelaNoConsole(parcela + 1, parcelas[parcela]);
		}
	}

	
	private static void imprimirParcelaNoConsole(int numero, BigDecimal valor) {
		System.out.println("Parcela " + numero + ", valor: " + valor);
	}
	
	
	
	
}
