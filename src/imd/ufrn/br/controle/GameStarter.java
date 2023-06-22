package imd.ufrn.br.controle;

import imd.ufrn.br.modelo.*;

public class GameStarter {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	
	public GameStarter() {
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

	public static void main(String ards[]) {
		GameStarter game = new GameStarter();
		TabuleiroCPU tabuleiroCPU = game.getTabuleiroCPU();
		TabuleiroPlayer tabuleiroPlayer = game.getTabuleiroPlayer();
		
		tabuleiroPlayer.moverNavio(2, 0, 0);
		//tabuleiroCPU.moverNavio(2, 9, 0);
		tabuleiroPlayer.print();
		
		tabuleiroPlayer.moverNavio(2, 1, 0);
		tabuleiroPlayer.print();
		tabuleiroPlayer.moverNavio(2, 2, 1);
		tabuleiroPlayer.print();
		tabuleiroPlayer.moverNavio(2, 3, 2);
		tabuleiroPlayer.print();
		tabuleiroPlayer.moverNavio(2, 3, 3);
		tabuleiroPlayer.print();
	}
}