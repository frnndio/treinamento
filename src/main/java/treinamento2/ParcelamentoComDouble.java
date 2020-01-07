package treinamento2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ParcelamentoComDouble {
	private static final String FORMATO_DECIMAL = "#0.00";

	public static void main(String[] args) {

		double valorTotal = Double.valueOf(args[0]);
		int quantidadeDeParcelas = Integer.valueOf(args[1]);

		System.out.println("Valor total: " + args[0] + ", quantidade de parcelas: " + args[1]);
//		System.out.println("Valor das parcelas: " + calculaValorDaParcela(valorTtotal, quantidadeDeParcelas));

		double valorDaParcela = calculaValorDaParcelaFormatado(valorTotal, quantidadeDeParcelas);
		double valorFaltando = valorTotal - (valorDaParcela * quantidadeDeParcelas);

		for (int parcela = 0; parcela < quantidadeDeParcelas; parcela++) {
			double valorCalculadoDaParcela = calculaValorDaParcelaFormatado(valorTotal, quantidadeDeParcelas);

			if (parcela == quantidadeDeParcelas - 1) {
				valorCalculadoDaParcela += valorFaltando;
			}

			System.out.println("Parcela " + parcela + ": " + valorCalculadoDaParcela);
		}
	}

	private static double calculaValorDaParcelaFormatado(double valorTotal, int quantidadeDeParcelas) {
		return Double.valueOf(formataValorDaParcela(calculaValorDaParcela(valorTotal, quantidadeDeParcelas)));
	}

	private static double calculaValorDaParcela(double valorTotal, int quantidadeDeParcelas) {
		return valorTotal / quantidadeDeParcelas;
	}

	private static String formataValorDaParcela(double valor) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat formatador = (DecimalFormat) nf;
		formatador.applyPattern(FORMATO_DECIMAL);
		return formatador.format(valor);
	}

}
