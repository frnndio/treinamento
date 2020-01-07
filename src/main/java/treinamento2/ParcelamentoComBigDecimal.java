package treinamento2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParcelamentoComBigDecimal {
	public static void main(String[] args) {
		double valorTotal = Double.valueOf(args[0]);
		int quantidadeDeParcelas = Integer.valueOf(args[1]);

		System.out.println("Valor total: " + args[0] + ", quantidade de parcelas: " + args[1]);

//		BigDecimal valorTotalEmBigDecimal = BigDecimal.valueOf(valorTotal);
//		valorTotalEmBigDecimal = valorTotalEmBigDecimal.setScale(3, RoundingMode.FLOOR);
//		System.out.println(valorTotalEmBigDecimal);

		BigDecimal valorBigDecimal = BigDecimal.valueOf(valorTotal);
		BigDecimal valorDaParcela = valorBigDecimal.divide(BigDecimal.valueOf(quantidadeDeParcelas), 2, RoundingMode.FLOOR);
		BigDecimal resto = valorBigDecimal.subtract(valorDaParcela.multiply(BigDecimal.valueOf(quantidadeDeParcelas)));
		
		imprimirParcelaNoConsole(1, valorDaParcela.add(resto));
		for(int parcela = 1; parcela < quantidadeDeParcelas; parcela++) {
			imprimirParcelaNoConsole(parcela + 1, valorDaParcela);
		}
	}
	
	private static void imprimirParcelaNoConsole(int numero, BigDecimal valor) {
		System.out.println("Parcela " + numero + ", valor: " + valor);
	}

}
