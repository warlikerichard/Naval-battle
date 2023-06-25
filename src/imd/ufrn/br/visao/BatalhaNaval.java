/*
 * ESTA CLASSE PROVAVELMENTE SERÁ CHAMADA DE CLASSE DE CONTROLE, ENQUANTO QUE A GAMESTARTER ATUAL
 * SERÁ CONVERTIDA EM CLASSE DE VISÃO.
 * ISTO PODE OCORRER POIS, APENAS APÓS IMPLEMENTAR ESTA CLASSE, PERCEBI QUE ELA FAZ MUITO MAIS SENTIDO COMO
 * UMA CLASSE DE CONTROLE (COM FUNÇÃO MAIN), ENQUANTO QUE UMA CLASSE DE VISÃO PODE FICAR RESPONSÁVEL APENAS 
 * PELAS FUNÇÕES QUE IRÃO MOSTRAR AS TELAS.
 * */

package imd.ufrn.br.visao;

import imd.ufrn.br.controle.GameStarter;
import imd.ufrn.br.modelo.TabuleiroCPU;
import imd.ufrn.br.modelo.TabuleiroPlayer;
import imd.ufrn.br.controle.GameState;
import java.util.Scanner;

public class BatalhaNaval {
	
	public static void main(String ards[]) {
		Scanner scan = new Scanner(System.in);
		GameStarter game = new GameStarter();
		TabuleiroCPU tabuleiroCPU = game.getTabuleiroCPU();
		TabuleiroPlayer tabuleiroPlayer = game.getTabuleiroPlayer();
		
		String lastCommand;
		
		while(game.getState() != GameState.EXIT_GAME) {
			switch(game.getState()) {
			case MENU:
				game.printMenu();
				lastCommand = scan.nextLine();
				if(lastCommand.equals("2")) {
					game.printControles();
				}
				break;
			case SHIP_SELECTION:
				
				break;
			case PLAYING:
				
				break;
			case WIN:
				
				break;
			case GAME_OVER:
				
				break;
			case EXIT_GAME:
				
				break;
			}
		}
	}
}
