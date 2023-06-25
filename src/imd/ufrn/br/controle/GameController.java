package imd.ufrn.br.controle;

import java.util.HashMap;
import java.util.Map;

import imd.ufrn.br.modelo.*;

public class GameController {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	
	private GameState state = GameState.MENU;
	
	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}
	
	public GameController() {
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
	
	public void drawBoards() {
		System.out.println();
		this.tabuleiroPlayer.print();
		System.out.println();
		this.tabuleiroCPU.print();
		System.out.println();
		System.out.println();
	}
	
	public void turn(int[] aimPlayer) {
		this.tabuleiroCPU.shot(aimPlayer);
		
		int[] aimCPU = new int[2];
		aimCPU[0] = this.tabuleiroCPU.getRandomNumber(0, 9);
		aimCPU[1] = this.tabuleiroCPU.getRandomNumber(0, 9);
		this.tabuleiroPlayer.shot(aimCPU);
		
		System.out.println("Computador atirou em : " + aimCPU[0] + ", " + aimCPU[1]);
		System.out.println();
		
		drawBoards();
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
	
	/*
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
	*/
	
	/*public static void main(String ards[]) {
		GameStarter game = new GameStarter();
		TabuleiroCPU CPU = game.getTabuleiroCPU();
		TabuleiroPlayer Player = game.getTabuleiroPlayer();
		
		Player.print();
		System.out.println();
		CPU.print();
		System.out.println();
		System.out.println();
		
		int[] aim = new int[2];
		aim[0] = 3;
		aim[1] = 5;
		CPU.shot(aim);
		Player.shot(aim);

		System.out.println("3, 5");
		System.out.println("3, 5");
		System.out.println();
		Player.print();
		System.out.println();
		CPU.print();
		System.out.println();
		System.out.println();

		aim[0] = 6;
		aim[1] = 3;
		CPU.shot(aim);
		aim[0] = 8;
		aim[1] = 5;
		Player.shot(aim);

		System.out.println("6, 3");
		System.out.println("8, 5");
		System.out.println();
		Player.print();
		System.out.println();
		CPU.print();
		System.out.println();
		System.out.println();

		aim[0] = 9;
		aim[1] = 6;
		CPU.shot(aim);
		aim[0] = 4;
		aim[1] = 0;
		Player.shot(aim);

		System.out.println("9, 6");
		System.out.println("4, 0");
		System.out.println();
		Player.print();
		System.out.println();
		CPU.print();
		System.out.println();
		System.out.println();

		aim[0] = 7;
		aim[1] = 9;
		CPU.shot(aim);
		aim[0] = 7;
		aim[1] = 3;
		Player.shot(aim);

		System.out.println("7, 9");
		System.out.println("7, 3");
		System.out.println();
		Player.print();
		System.out.println();
		CPU.print();
		System.out.println();
		System.out.println();
		
		aim[0] = 0;
		for (int x = 0; x < 10; x++) {
			aim[1] = x;
			CPU.shot(aim);
		}
		aim[0] = 1;
		for (int x = 0; x < 10; x++) {
			aim[1] = x;
			CPU.shot(aim);
		}
		aim[0] = 2;
		for (int x = 0; x < 10; x++) {
			aim[1] = x;
			CPU.shot(aim);
		}
		aim[0] = 4;
		for (int x = 0; x < 10; x++) {
			aim[1] = x;
			CPU.shot(aim);
		}
		System.out.println();
		CPU.print();
		System.out.println();
		System.out.println();
	}*/
}