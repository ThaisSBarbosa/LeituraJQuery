package br.edu.cefsa.n1b1;

import java.util.Arrays;
import java.util.List;

public class PalavraReservada {

	private static final String arquivoPR = "palavras reservadas js.txt";

	public static List<String> criaListaPr() throws Exception {
		String palavrasReservadas = Utils.leArquivoTexto(arquivoPR);
		List<String> listPalavrasReservadas = Arrays.asList(palavrasReservadas.split(","));
		return listPalavrasReservadas;
	}
}
