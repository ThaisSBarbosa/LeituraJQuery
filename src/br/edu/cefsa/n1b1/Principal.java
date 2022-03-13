package br.edu.cefsa.n1b1;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		String allString = leArquivoJQuery();						
		List<String> listaDeTokens = SeparadorDeTokens.DivideTokens(allString);
		List<Lexema> lexemas = AnalisadorDeTokens.AnalisaTokens(listaDeTokens);
		String saida = ConstrutorDeSaida.MontaTabela(lexemas);
		
		System.out.println(saida);
		
		//teste
		//listaDeTokens.forEach(System.out::println);
	}

	private static String leArquivoJQuery() throws Exception {
		Scanner scanner = new Scanner(new File("jquery.txt"));
		String allString = "";
		while (scanner.hasNextLine()) {
			allString += scanner.nextLine();
		}
		return allString;
	}
}