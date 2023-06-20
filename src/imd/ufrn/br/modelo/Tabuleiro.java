package imd.ufrn.br.modelo;

import java.util.HashMap;

public abstract class Tabuleiro {
	
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
	
	public abstract void print();
	
	public HashMap<Integer, Navio> getNavios() {
		return navios;
	}
	
	public void setNavios(HashMap<Integer, Navio> navios) {
		this.navios = navios;
	}
	
	public void addNavio(Navio navio) {
		navios.put(navio.getTamanho(), navio);
	}
	
	public Bloco[][] getMapa() {
		return mapa;
	}
	
	public void setMapa(Bloco[][] mapa) {
		this.mapa = mapa;
	}
	
	//Metodos de controle

	//Limpa o tabuleiro
	public void limparTabuleiro(){
		for (int x = 0; x < 10 ; x++) {
			for (int y = 0; y < 10 ; y++) {
				this.mapa[x][y] = new Bloco();
			}
		}
	}
	
	//Move um navio para a posição dada.
	public void moverNavio(Integer id, int x, int y) {
		Navio navio = navios.get(id);
		boolean success = true;
		
		
		for(int i=0; i<navio.getTamanho(); i++) {
			if(navio.getSentido() == 1 && navio.getTamanho() + x - 1 < 10) {
				if((mapa[x+i][y].getChave() == 0 || mapa[x+i][y].getChave() == navio.getTamanho())) {
					mapa[x+i][y].setChave(navio.getTamanho());
					mapa[x+i][y].setEstado(2);
					navio.setPosicao(new int[]{x, y});
				}
				else {
					System.out.println("Lugar ocupado!");
					success = false;
					break;
				}
			}
			else if(navio.getSentido() == 0 && navio.getTamanho() + y - 1 < 10){
				if((mapa[x][y+i].getChave() == 0  || mapa[x][y+1].getChave() == navio.getTamanho()) && navio.getTamanho() + y - 1 >= 0) {
					mapa[x][y+i].setChave(navio.getTamanho());
					mapa[x][y+i].setEstado(2);
					navio.setPosicao(new int[]{x, y});
				}
				else {
					System.out.println("Lugar ocupado!");
					success = false;
					break;
				}
			}
			else{
				System.out.println("Fora dos limites");
				success = false;
				break;
			}
		}
		if(success){
			//limparTabuleiro();
			//confirmShips();
		}
	}
	
	//Updates the blocks according to the current ships stored, so the states of the blocks won't just be 0
	public void confirmShips() {
		for(int i : navios.keySet()){
			Navio navio = navios.get(i);
			int[] posicao = navio.getPosicao();

			for(int t=0; t<navio.getTamanho(); t++) {
				if(navio.getSentido() == 0) {
					mapa[posicao[0]][posicao[1]+t].setEstado(2);
					mapa[posicao[0]][posicao[1]+t].setChave(navio.getTamanho());
				}
				else {
					mapa[posicao[0]+t][posicao[1]].setEstado(2);
					mapa[posicao[0]+t][posicao[1]].setChave(navio.getTamanho());
				}
			}
		}
	}
}