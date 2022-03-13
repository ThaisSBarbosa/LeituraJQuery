package br.edu.cefsa.n1b1;

public class Lexema {
	
	private Long posicao;
	private String token;
	private Tipo tipo;
	
	public Lexema(Long posicao, String token, Tipo tipo) {
		this.posicao=posicao;
		this.token=token;
		this.tipo=tipo;		
	}
	
	public Long getPosicao() {
		return posicao;
	}
	public Tipo getTipo() {
		return tipo;
	}public String getToken() {
		return token;
	}
	
	@Override
	public String toString() {
		return String.format("%-20d  %-20s  %s", this.posicao, this.token, this.tipo);
	}

}