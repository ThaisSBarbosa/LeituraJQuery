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

		textoCompleto = textoCompleto.replace("+", " + ");
		textoCompleto = textoCompleto.replace("-", " - ");
		//textoCompleto = textoCompleto.replace("\"", " \" ");
		
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
		
		// teste pega strings com aspas
		List<String> listStringsCompletas = new ArrayList<>();
		//listStringsCompletas = listSemVazios;
		int index = 0;
		while (index<listSemVazios.size())
		{
			String texto = listSemVazios.get(index);
			
			if ((texto.startsWith("\"") && texto.endsWith("\"") && texto.length()>1 )  || !texto.startsWith("\"")) {

				listStringsCompletas.add(texto);
				index++;
			} else if (texto.startsWith("\""))
			{
				int procuraProximo=index+1;
				boolean achou=false;
				while (! achou) {
					if (listSemVazios.get(procuraProximo).endsWith("\"")) {
						texto= texto.replace(texto, texto+" "+listSemVazios.get(procuraProximo));
						listStringsCompletas.add(texto);
						achou=true;
						index=procuraProximo+1;
					} else {
						texto=texto.replace(texto, texto+" "+listSemVazios.get(procuraProximo));
						procuraProximo++;
					}
				}
			} 
			
		}
		// return listSemVazios;
		return listStringsCompletas;
	}
	
	private String mudaString(String antiga, String nova){
	    return antiga+" "+nova;
	}
	
}
