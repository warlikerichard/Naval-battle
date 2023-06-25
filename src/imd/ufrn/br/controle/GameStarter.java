package imd.ufrn.br.controle;

import imd.ufrn.br.modelo.*;

public class GameStarter {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	
	
	
	private GameState state = GameState.MENU;
	
	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}
	
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