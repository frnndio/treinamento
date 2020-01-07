package treinamento2;

import java.time.LocalDate;

public class ApiLocalDate {
	public static void main(String[] args) {
		LocalDate dataDoDiaDeNatal = LocalDate.of(2019, 12, 25);
		LocalDate dataDoDiaDeNatalMaisVinteDias = dataDoDiaDeNatal.plusDays(20L);
		System.out.println(dataDoDiaDeNatalMaisVinteDias);
	}

}
