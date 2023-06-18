package imd.ufrn.br.controle;
import imd.ufrn.br.modelo.*;


public class GameStarter {
	private TabuleiroCPU tabuleiroCPU = new TabuleiroCPU();
	private TabuleiroPlayer tabuleiroPlayer = new TabuleiroPlayer();
	
	public GameStarter() {
		tabuleiroCPU.addNavio(new Corveta(0, new int[]{0, 0}));
		tabuleiroCPU.addNavio(new Fragata(0, new int[]{0, 1}));
		tabuleiroCPU.addNavio(new Submarino(0, new int[]{0, 2}));
		tabuleiroCPU.addNavio(new Destroyer(0, new int[]{0, 3}));
		
		tabuleiroPlayer.addNavio(new Corveta(0, new int[]{0, 0}));
		tabuleiroPlayer.addNavio(new Fragata(0, new int[]{0, 1}));
		tabuleiroPlayer.addNavio(new Submarino(0, new int[]{0, 2}));
		tabuleiroPlayer.addNavio(new Destroyer(0, new int[]{0, 3}));
		
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

	public static void main(String ards[]) {
		GameStarter game = new GameStarter();
		TabuleiroCPU tabuleiroCPU = game.getTabuleiroCPU()
		TabuleiroPlayer tabuleiroPlayer = game.getTabuleiroPlayer();
		
		//Fazer função confirmShips em Tabuleiro para poder usar o print e verificar se está tudo certo
		
	}
}
