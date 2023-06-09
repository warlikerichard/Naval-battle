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
		
		addNavio(randomizePosition(new Destroyer()));
		addNavio(randomizePosition(new Fragata()));
		addNavio(randomizePosition(new Submarino()));
		addNavio(randomizePosition(new Corveta()));
	}
	
	public abstract void print();
	
	public HashMap<Integer, Navio> getNavios() {
		return this.navios;
	}
	
	public void setNavios(HashMap<Integer, Navio> navios) {
		this.navios = navios;
	}
	
	public void addNavio(Navio navio) {
		this.navios.put(navio.getTamanho(), navio);
	}
	
	public Bloco[][] getMapa() {
		return this.mapa;
	}
	
	public void setMapa(Bloco[][] mapa) {
		this.mapa = mapa;
	}
	
	public void setBlocoEstado(int x, int y, int estado) {
		this.mapa[x][y].setEstado(estado);
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
	
	//Verifica e aplica um tiro em um Bloco
	public String shot(int[] aim) {
		try {
			if (this.mapa[aim[0]][aim[1]].getEstado() == 0) {
				this.mapa[aim[0]][aim[1]].setEstado(1);
				return "Água/Miss";
				
			} else if (this.mapa[aim[0]][aim[1]].getEstado() == 2) {
				this.navios.get(this.mapa[aim[0]][aim[1]].getChave()).wasShot();
				if (this.navios.get(this.mapa[aim[0]][aim[1]].getChave()).getVida_restante() == 0) {
					Navio navio = this.navios.get(this.mapa[aim[0]][aim[1]].getChave());
					if (navio.getSentido() == 0) {
						for (int x = navio.getPosicao()[0];x < navio.getPosicao()[1] + navio.getTamanho() -1;x++) {
							this.mapa[navio.getPosicao()[1]][x].setEstado(4);
						}
					} else {
						for (int x = navio.getPosicao()[1];x < navio.getPosicao()[0] + navio.getTamanho() -1;x++) {
							this.mapa[x][navio.getPosicao()[0]].setEstado(4);
						}
					}
					
					return "Navio afundado";
					
				} else {
					this.mapa[aim[0]][aim[1]].setEstado(3);
					return "Acerto/Hit";
					
				}
			} else {
				return "Bloco já atingido";
				
			}
		} catch (Exception e) {
			return "Error: try again";
		}
	}
	
	//Move um navio para a posição dada.
	public void moverNavio(Integer id, int x, int y) {
		Navio navio = navios.get(id);
		boolean success = true;
		
		for(int i=0; i < navio.getTamanho(); i++) {
			if(navio.getSentido() == 1 && navio.getTamanho() + x - 1 < 10) {
				if(mapa[x+i][y].getChave() == 0 || mapa[x+i][y].getChave() == navio.getTamanho()) {
					mapa[x+i][y].setChave(navio.getTamanho());
					mapa[x+i][y].setEstado(2);
				}
				else {
					System.out.println("Lugar ocupado!");
					success = false;
					break;
				}
			}
			else if(navio.getSentido() == 0 && navio.getTamanho() + y - 1 < 10){
				if(mapa[x][y+i].getChave() == 0  || mapa[x][y+i].getChave() == navio.getTamanho()) {
					mapa[x][y+i].setChave(navio.getTamanho());
					mapa[x][y+i].setEstado(2);
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
			navio.setPosicao(new int[]{x, y});
			navio.setActive();
			limparTabuleiro();
			confirmShips();
		}
	}
	
	public void moverNavio(Integer id, int x, int y, int dir) {
		Navio navio = navios.get(id);
		boolean success = true;
		
		for(int i=0; i < navio.getTamanho(); i++) {
			if(dir == 1 && navio.getTamanho() + x - 1 < 10) {
				if(mapa[x+i][y].getChave() == 0 || mapa[x+i][y].getChave() == navio.getTamanho()) {
					mapa[x+i][y].setChave(navio.getTamanho());
					mapa[x+i][y].setEstado(2);
				}
				else {
					System.out.println("Lugar ocupado!");
					success = false;
					break;
				}
			}
			else if(dir == 0 && navio.getTamanho() + y - 1 < 10){
				if(mapa[x][y+i].getChave() == 0  || mapa[x][y+i].getChave() == navio.getTamanho()) {
					mapa[x][y+i].setChave(navio.getTamanho());
					mapa[x][y+i].setEstado(2);
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
			navio.setSentido(dir);
			navio.setPosicao(new int[]{x, y});
			navio.setActive();
			limparTabuleiro();
			confirmShips();
		}
	}
	//Updates the blocks according to the current ships stored, so the states of the blocks won't just be 0
	public void confirmShips() {
		for(int i : navios.keySet()){
			Navio navio = navios.get(i);
			int[] posicao = navio.getPosicao();

			if (navio.isActive()) {
				for (int t = 0; t < navio.getTamanho(); t++) {
					if (navio.getSentido() == 0) {
						mapa[posicao[0]][posicao[1] + t].setEstado(2);
						mapa[posicao[0]][posicao[1] + t].setChave(navio.getTamanho());
					} else {
						mapa[posicao[0] + t][posicao[1]].setEstado(2);
						mapa[posicao[0] + t][posicao[1]].setChave(navio.getTamanho());
					}
				} 
			}
		}
	}
	
	//Starts the ships in random positions
	public Navio randomizePosition(Navio ship) {
		boolean canBePlaced = true;
		int val1 = getRandomNumber(0, 9);
		int val2 = getRandomNumber(0, 10-ship.getTamanho());
		ship.setSentido(getRandomNumber(0, 2));
		int[] shipPos = new int[2];
		
		if (ship.getSentido() == 0) {
			shipPos[0] = val1;
			shipPos[1] = val2;
			ship.setPosicao(shipPos);
		} else {
			shipPos[0] = val2;
			shipPos[1] = val1;
			ship.setPosicao(shipPos);
		}
		
		for (int x = 0; x < ship.getTamanho(); x++) {
			val1 = ship.getPosicao()[0];
			val2 = ship.getPosicao()[1];
			if (ship.getSentido() == 0) {
				val2+=x;
			} else {
				val1+=x;
			}
			
			if (this.mapa[val1][val2].getChave() != 0) {
				canBePlaced = false;
				break;
			}
		}
		
		if (canBePlaced) {
			for(int x = 0; x < ship.getTamanho(); x++) {
				if (ship.getSentido() == 0) {
					this.mapa[ship.getPosicao()[0]][ship.getPosicao()[1] + x].setChave(ship.getTamanho());
					this.mapa[ship.getPosicao()[0]][ship.getPosicao()[1] + x].setEstado(2);
				} else {
					this.mapa[ship.getPosicao()[0] + x][ship.getPosicao()[1]].setChave(ship.getTamanho());
					this.mapa[ship.getPosicao()[0] + x][ship.getPosicao()[1]].setEstado(2);
				}
			}
			
			//print();
			//System.out.println();
			//System.out.println();
			
			return ship;
		} else {
			return randomizePosition(ship);
		}
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
}