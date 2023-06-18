package imd.ufrn.br.modelo;

import java.util.HashMap;

public class Tabuleiro {
	
	// Baseado na lista de embarcações atual, o tabuleiro (mapa) será atualizado.
	// Note que esta lista não mudará uma vez que o jogo for iniciado.
	private HashMap<Integer, Navio> navios = new HashMap<Integer, Navio>();
	private Bloco[][] mapa = new Bloco[10][10];
	
	public Tabuleiro() {
		for (int x = 0; x < 10 ; x++) {
			for (int y = 0; y < 10 ; y++) {
				this.mapa[x][y] = new Bloco();
			}
		}
	}
	
	public void print() {
		for (int x = 0; x < 10 ; x++) {
			for (int y = 0; y < 10 ; y++) {
				System.out.print(this.mapa[x][y].getEstado() == 2 ? "*" : this.mapa[x][y].getEstado());
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
	
	//Updates the blocks according to the current ships stored, so the states of the blocks won't just be 0
	public void confirmShips() {
		
	}
}