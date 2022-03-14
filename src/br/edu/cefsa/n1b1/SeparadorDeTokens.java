package br.edu.cefsa.n1b1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

///Separa o arquivo recebido em tokens.
public class SeparadorDeTokens {

	public static List<String> DivideTokens(String textoCompleto) throws Exception{
		textoCompleto = textoCompleto.replace("\r", "");
		textoCompleto = textoCompleto.replace("\n", "");		
		textoCompleto = textoCompleto.replace("\t", "");
		textoCompleto = textoCompleto.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)", "");

		
		textoCompleto = textoCompleto.replace(",", " , ");
		textoCompleto = textoCompleto.replace(";", " ; ");
		textoCompleto = textoCompleto.replace("{", " { ");
		textoCompleto = textoCompleto.replace("}", " } ");
		textoCompleto = textoCompleto.replace("(", " ( ");
		textoCompleto = textoCompleto.replace(")", " ) ");
		textoCompleto = textoCompleto.replace(":", " : ");
		textoCompleto = textoCompleto.replace("?", " ? ");
		textoCompleto = textoCompleto.replace("[", " [ ");
		textoCompleto = textoCompleto.replace("]", " ] ");
		textoCompleto = textoCompleto.replace("!", " ! ");
		textoCompleto = textoCompleto.replace("&&", " && ");
		textoCompleto = textoCompleto.replace("||", " || ");

		var listComVazios = Arrays.asList(textoCompleto.split("[" + Pattern.quote(" #@_\\/*") + "]+"));

		List<String> listSemVazios = new ArrayList<>();
		for (String item : listComVazios) {
			if (item != "")
				listSemVazios.add(item);
		}
		
		return listSemVazios;
	}
	
}
