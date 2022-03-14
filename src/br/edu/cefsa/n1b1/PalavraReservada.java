package br.edu.cefsa.n1b1;

import java.util.ArrayList;
import java.util.List;

public class PalavraReservada {

	private static final String arquivoPR = "palavras reservadas js.txt";

	public static List<String> criaListaPr() throws Exception {
		List<String>prs = new ArrayList<String>();

		String[] lista_pr = Utils.leArquivoTexto(arquivoPR).split(",");
		for (String string : lista_pr) {
			prs.add(string);
		}

		return prs;
	}
	
	private PalavraReservada () {
		
	}
}
