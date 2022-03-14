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
		
		if (token == "true" || token == "false")
			tipo = Tipo.BOOLEAN;
		
		
		if (token.matches("(\\d)*.(\\d)*")) {
			tipo = tipo.DOUBLE;
			
//			if (Float.valueOf(token) >= -340282347 * Math.pow(10, 38) && Float.valueOf(token) <= 340282347 * Math.pow(10, 38)) {
//				tipo = tipo.FLOAT;
//			}
			
			if (token.matches("[0-9]+")) {
				tipo = tipo.LONG;
				
				if (Integer.valueOf(token) >= -2147483648 && Integer.valueOf(token) <= 2147483647) {
					tipo = tipo.INT;
				}
				
				if (Integer.valueOf(token) >= -32.768 && Integer.valueOf(token) <= 32.767) {
					tipo = tipo.SHORT;
				}
				
				if (Integer.valueOf(token) >= -128 && Integer.valueOf(token) <= 127) {
					tipo = tipo.BYTE;
				}			
			}
		}

		
		
		return tipo;
	}
	
	private static List<String> retornaListaDePalavrasReservadas() throws Exception {

		String palavrasReservadas = Utils.leArquivoTexto("palavras reservadas js.txt");
		List<String> listPalavrasReservadas = Arrays.asList(palavrasReservadas.split(","));
		
		return null;
	}
	
	
}
