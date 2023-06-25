package imd.ufrn.br.modelo;

public abstract class Navio {
	private int tamanho;
	private int sentido = 0; // 0 para horizontal, 1 para vertical.
	private int[] posicao = new int[2];
	private int vidas_restantes; // Iniciará valendo o tamanho da embarcação. Quando embarcação for atingida, a quantidade
							     // de vidas restantes diminuirá em 1. Ao chegar em 0, o tabuleiro saberá que navio foi destruído.
	private boolean isActive = true;
	public Navio(int tamanho, int sentido, int[] posicao) {
		this.tamanho = tamanho;
		this.vidas_restantes = tamanho;
		this.sentido = sentido;
		this.posicao = posicao;
	}

	public Navio(int t, int s) {
		tamanho = t;
		vidas_restantes = t;
		sentido = s;
	}

	public int getVida_restante() {
		return vidas_restantes;
	}

	public void setVida_restante(int vida_restante) {
		this.vidas_restantes = vida_restante;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getSentido() {
		return sentido;
	}
	
	public void setSentido(int sentido) {
		this.sentido = sentido;
	}
	
	public int[] getPosicao() {
		return posicao;
	}
	
	public void setPosicao(int[] posicao) {
		this.posicao = posicao;
	}
	
	public void setActive() {
		isActive = true;
	}
	
	public boolean isActive() {
		return isActive;
	}
}