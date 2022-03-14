package br.edu.cefsa.n1b1;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorDeTokens {

	private static List<String> palavrasReservadas;

	/// Controi um lexema para cada token.
	public static List<Lexema> AnalisaTokens(List<String> tokens) throws Exception {

		palavrasReservadas = PalavraReservada.criaListaPr();
		List<Lexema> lexemas = new ArrayList<>();

		Long contador = (long) 0;
		for (int i = 0; i < tokens.size(); i++) {

			String proxToken = (i == tokens.size() - 1) ? null : tokens.get(i + 1);
			Tipo tipo = retornaTipo(tokens.get(i), proxToken);

			Lexema lexema = new Lexema(contador, tokens.get(i), tipo);
			lexemas.add(lexema);

			contador = contador + tokens.get(i).length();
		}

		return lexemas;
	}

	private static Tipo retornaTipo(String token, String proximoToken) {

		Tipo tipo = null;

		if (token.matches("[^\\W\\d_]|[^a-záàâãéèêíïóôõöúçñ]+")) {
			tipo = Tipo.OPERADOR;
		}
		if (token.matches("\"([^\"]+)\"")) {
			tipo = Tipo.STRING;
		}
		if (token.matches("[a-zA-Záàâãéèêíïóôõöúçñ]+")) {			

			if (proximoToken != null) {
				if (token.startsWith("\"") || token.endsWith("\"") ||
						proximoToken.startsWith("\"") || proximoToken.endsWith("\"")) {
					tipo = Tipo.STRING;
				}
				if (token.length() == 1 && (proximoToken.startsWith("'") || proximoToken.endsWith("'"))) {
					tipo = tipo.CHAR;
				}
				if (proximoToken.startsWith("(") || proximoToken.startsWith(" (")) {
					tipo = Tipo.METODO;
				}
			}
			if (token.matches("(^([a-zA-Z$]{1}|[a-zA-Z0-9$]+)[a-zA-Z0-9_$]{0,}$)")) {
				tipo = Tipo.VARIAVEL;
			}
			if (palavrasReservadas.contains(token)) {
				tipo = Tipo.PALAVRARESERVADA;
			}
		}

		if (token == "true" || token == "false") {
			tipo = Tipo.BOOLEAN;
		}

		if (token.matches("\\d*.\\d+")) {
			tipo = tipo.DOUBLE;

			if (floatOrNull(token) >= -340282347 * Math.pow(10, 38)
					&& floatOrNull(token) <= 340282347 * Math.pow(10, 38)) {
				tipo = tipo.FLOAT;
			}

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
		} else if (token.indexOf(".") > -1) {
			tipo = Tipo.OBJETO;
		}

		return tipo;
	}

	private static Float floatOrNull(String value) {
		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return 0F;
		}
	}

}
