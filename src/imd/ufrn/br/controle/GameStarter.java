package imd.ufrn.br.controle;

import java.util.HashMap;
import java.util.Map;

import imd.ufrn.br.modelo.*;

public class GameStarter {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	
	public GameStarter() {
		tabuleiroCPU = new TabuleiroCPU();
		tabuleiroPlayer = new TabuleiroPlayer();
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
	
	//Verifica se um tabuleiro ainda possui algum navio com vida restante
	public boolean verificarVidas(Tabuleiro tabuleiro) {
		boolean lost = true;
		HashMap<Integer, Navio> navios = tabuleiro.getNavios();
		
		for(Map.Entry<Integer, Navio> navio : navios.entrySet()) {
			if (navio.getValue().getVida_restante() > 0) {
				lost = false;
				break;
			}
		}
		
		return lost;
	}

	public static void main(String ards[]) {
		GameStarter game = new GameStarter();
		TabuleiroCPU tabuleiroCPU = game.getTabuleiroCPU();
		TabuleiroPlayer tabuleiroPlayer = game.getTabuleiroPlayer();
		
		tabuleiroPlayer.print();
		System.out.println();
		System.out.println();
		tabuleiroCPU.print();
		
		
//		tabuleiroPlayer.moverNavio(2, 0, 0);
//		//tabuleiroCPU.moverNavio(2, 9, 0);
//		tabuleiroPlayer.print();
		
//		tabuleiroPlayer.moverNavio(2, 1, 0);
//		tabuleiroPlayer.print();
//		tabuleiroPlayer.moverNavio(2, 2, 1);
//		tabuleiroPlayer.print();
//		tabuleiroPlayer.moverNavio(2, 3, 2);
//		tabuleiroPlayer.print();
//		tabuleiroPlayer.moverNavio(2, 3, 3);
//		tabuleiroPlayer.print();
	}
}