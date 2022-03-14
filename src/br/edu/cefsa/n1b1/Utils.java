package br.edu.cefsa.n1b1;

import java.io.File;
import java.util.Scanner;

public class Utils {
	
	public static String leArquivoTexto(String pathArquivo) throws Exception {
		Scanner scanner = new Scanner(new File(pathArquivo));
		String allString = "";
		
		while (scanner.hasNextLine()) {
			
			String line = scanner.nextLine();
			
			if (!line.trim().startsWith("//")) {
                allString += line;
            }
			
		}
		return allString;
	}
}
