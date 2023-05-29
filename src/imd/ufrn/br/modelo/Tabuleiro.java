package imd.ufrn.br.modelo;

import java.util.HashMap;

public class Tabuleiro {
	
	// Baseado na lista de embarcações atual, o tabuleiro (mapa) será atualizado.
	// Note que esta lista não mudará uma vez que o jogo for iniciado.
	private HashMap<Integer, Embarcacao> embarcacoes = new HashMap<Integer, Embarcacao>();
	private Bloco[][] mapa = new Bloco[10][10]; // Mapa inicializado com blocos com valores 0, indicando que não há navios no mesmo
												// Use 1 para indicar que um navio em bom estado ocupa este bloco
												// Use 2 para indicar que um navio destruido ocupa este bloco
												// Cada bloco terá uma chave que indica a qual navio o mesmo pertence, tornando
												// a manipulação de estados mais fácil
	
	public HashMap<Integer, Embarcacao> getEmbarcacoes() {
		return embarcacoes;
	}
	public void setEmbarcacoes(HashMap<Integer, Embarcacao> embarcacoes) {
		this.embarcacoes = embarcacoes;
	}
	public Bloco[][] getMapa() {
		return mapa;
	}
	public void setMapa(Bloco[][] mapa) {
		this.mapa = mapa;
	}
	
	public void addEmbarcacao(Embarcacao embarcacao) {
		embarcacoes.put(embarcacao.getTamanho(), embarcacao);
	}
}
