package imd.ufrn.br.controle;

import imd.ufrn.br.modelo.*;

public class GameStarter {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	
	private int gameState = 0;  // 0: Menu
	   							// 1: Seleção de navios
    							// 2: Jogo iniciado
    							// 4: Jogo vencido
    							// 5: Game over
	
	public GameStarter() {
		tabuleiroCPU = new TabuleiroCPU();
		tabuleiroPlayer = new TabuleiroPlayer();
	}
	
	public void randomizeBoard() {
		
	}
	
	public TabuleiroCPU getTabuleiroCPU() {
		return tabuleiroCPU;
	}

	public void setTabuleiroCPU(TabuleiroCPU tabuleiroCPU) {
		this.tabuleiroCPU = tabuleiroCPU;
	}

	public TabuleiroPlayer getTabuleiroPlayer() {
		return tabuleiroPlayer;
	}

	public void setTabuleiroPlayer(TabuleiroPlayer tabuleiroPlayer) {
		this.tabuleiroPlayer = tabuleiroPlayer;
	}

}