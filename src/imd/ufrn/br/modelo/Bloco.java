package imd.ufrn.br.modelo;

public class Bloco {
	private int estado = 0; // 0 - agua; 1 - missed; 2 - navio; 3 - acerto; 4 - afundado;
	private int chave = 0; // Chave que referencia a embarcação que ocupa este bloco. A chave usada será o tamanho da embarcação.
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public int getChave() {
		return chave;
	}
	
	public void setChave(int chave) {
		this.chave = chave;
	}
}