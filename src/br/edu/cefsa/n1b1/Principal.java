package br.edu.cefsa.n1b1;

import java.util.List;

public class Principal {

	public static void main(String[] args) throws Exception {
		List<String> prs = PalavraReservada.criaListaPr();
		
		String allString = Utils.leArquivoTexto("jquery.txt");						
		List<String> listaDeTokens = SeparadorDeTokens.DivideTokens(allString);
		List<Lexema> lexemas = AnalisadorDeTokens.AnalisaTokens(listaDeTokens);
		
		
		//String saida = ConstrutorDeSaida.MontaTabela(lexemas);		
		//System.out.println(saida);
		
		ConstrutorDeSaida.gravaDados(lexemas);
		
		//teste
		listaDeTokens.forEach(System.out::println);
	}
}