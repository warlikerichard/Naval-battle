package imd.ufrn.br.controle;
import imd.ufrn.br.modelo.*;


public class GameStarter {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	
	public GameStarter() {
		tabuleiroPlayer = new TabuleiroPlayer();
		tabuleiroCPU = new TabuleiroCPU();
		
		tabuleiroCPU.addNavio(new Corveta());
		tabuleiroCPU.addNavio(new Fragata());
		tabuleiroCPU.addNavio(new Submarino());
		tabuleiroCPU.addNavio(new Destroyer());
		
		tabuleiroPlayer.addNavio(new Corveta());
		tabuleiroPlayer.addNavio(new Fragata());
		tabuleiroPlayer.addNavio(new Submarino());
		tabuleiroPlayer.addNavio(new Destroyer());
		
		// Now we use the method rearranjarNavios from the class Tabuleiro.
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