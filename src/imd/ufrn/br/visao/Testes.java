package imd.ufrn.br.visao;

import imd.ufrn.br.controle.GameStarter;

public class Testes {
	
	public static void main(String args[]) {
		GameStarter game = new GameStarter();
		
		printBoard(game);
	}
	
	private static void printBoard(GameStarter game) {
		game.getTabuleiroPlayer().print();
		System.out.println();
		System.out.println();
		game.getTabuleiroCPU().print();
	}
}