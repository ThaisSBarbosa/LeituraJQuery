package br.edu.cefsa.n1b1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ConstrutorDeSaida {

	private static final String arquivoSaida = "lexemas.lex";	
	
	public static void gravaDados(List<Lexema> lexemas) throws IOException {

		FileWriter fw = new FileWriter(arquivoSaida, StandardCharsets.UTF_8);
		BufferedWriter escreveArquivo = new BufferedWriter(fw);

		for (Lexema lexema : lexemas) {
			escreveArquivo.write(lexema.toString());
			System.out.println(lexema.toString());
			escreveArquivo.newLine();
			escreveArquivo.flush();
		}
		escreveArquivo.close();
	}
}
