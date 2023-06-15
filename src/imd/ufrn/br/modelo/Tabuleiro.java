package imd.ufrn.br.modelo;

import java.util.HashMap;

public class Tabuleiro {
	
	// Baseado na lista de embarcações atual, o tabuleiro (mapa) será atualizado.
	// Note que esta lista não mudará uma vez que o jogo for iniciado.
	private HashMap<Integer, Navio> navios = new HashMap<Integer, Navio>();
	private Bloco[][] mapa = new Bloco[10][10]; // Mapa inicializado com blocos com valores 0, indicando que não há navios no mesmo
												// Use 1 para indicar que um navio em bom estado ocupa este bloco
												// Use 2 para indicar que um navio destruido ocupa este bloco
												// Cada bloco terá uma chave que indica a qual navio o mesmo pertence, tornando
												// a manipulação de estados mais fácil
	
	public Tabuleiro() {
		for (int x = 0; x < 10 ; x++) {
			for (int y = 0; y < 10 ; y++) {
				this.mapa[x][y] = new Bloco();
			}
		}
		
		this.addNavio(new Corveta(0,  new int[]{0, 0}));
	}
	
	public void print() {
		for (int x = 0; x < 10 ; x++) {
			for (int y = 0; y < 10 ; y++) {
				System.out.print(this.mapa[x][y].getEstado());
			}
			System.out.println();
		}
	}
	
	public HashMap<Integer, Navio> getNavios() {
		return navios;
	}
	
	public void setNavios(HashMap<Integer, Navio> navios) {
		this.navios = navios;
	}
	
	public void addNavio(Navio Navio) {
		navios.put(Navio.getTamanho(), Navio);
	}
	
	public Bloco[][] getMapa() {
		return mapa;
	}
	
	public void setMapa(Bloco[][] mapa) {
		this.mapa = mapa;
	}
}