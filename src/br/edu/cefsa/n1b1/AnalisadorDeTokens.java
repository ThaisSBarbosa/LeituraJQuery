package br.edu.cefsa.n1b1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisadorDeTokens {
	
	private static List<String> palavrasReservadas = new ArrayList<>();
	
	public AnalisadorDeTokens() throws Exception {
		palavrasReservadas = retornaListaDePalavrasReservadas();
	}
	
	///Retorna um lexema para cada token.
	public static List<Lexema> AnalisaTokens(List<String> tokens) throws Exception{

		List<Lexema> lexemas = new ArrayList<>();
		
		Long contador = (long) 0;
		for (int i=0; i<tokens.size(); i++) {			

			Tipo tipo = retornaTipo(tokens.get(i));			
			Lexema lexema = new Lexema(contador, tokens.get(i), tipo);
			lexemas.add(lexema);
			
			contador = contador +  tokens.get(i).length();
		}		
		
		return lexemas;
	}

	private static Tipo retornaTipo(String token) {

		Tipo tipo = null;
		
		if (palavrasReservadas.contains(token))
			tipo = Tipo.PALAVRARESERVADA;
		
		return tipo;
	}
	
	private static List<String> retornaListaDePalavrasReservadas() throws Exception {

		String palavrasReservadas = Utils.leArquivoTexto("palavras reservadas js.txt");
		List<String> listPalavrasReservadas = Arrays.asList(palavrasReservadas.split(","));
		
		return null;
	}
	
	
}
