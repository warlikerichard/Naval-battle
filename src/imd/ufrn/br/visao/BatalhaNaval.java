/*
 * ESTA CLASSE PROVAVELMENTE SERÁ CHAMADA DE CLASSE DE CONTROLE, ENQUANTO QUE A GAMESTARTER ATUAL
 * SERÁ CONVERTIDA EM CLASSE DE VISÃO.
 * ISTO PODE OCORRER POIS, APENAS APÓS IMPLEMENTAR ESTA CLASSE, PERCEBI QUE ELA FAZ MUITO MAIS SENTIDO COMO
 * UMA CLASSE DE CONTROLE (COM FUNÇÃO MAIN), ENQUANTO QUE UMA CLASSE DE VISÃO PODE FICAR RESPONSÁVEL APENAS 
 * PELAS FUNÇÕES QUE IRÃO MOSTRAR AS TELAS.
 * */

package imd.ufrn.br.visao;

import imd.ufrn.br.controle.GameController;
import imd.ufrn.br.controle.GameState;
import imd.ufrn.br.modelo.TabuleiroPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BatalhaNaval {
	
	public static void main(String ards[]) {
		Scanner scan = new Scanner(System.in);
		GameController game = new GameController();
		TabuleiroPlayer tabuleiroPlayer = new TabuleiroPlayer();
		
		String lastCommand;
		
		while(game.getState() != GameState.EXIT_GAME) {
			switch(game.getState()) {
			case MENU:
				printMenu(tabuleiroPlayer);
				lastCommand = scan.nextLine();
				if(lastCommand.equals("2")) {
					printControles();
					//printMenu(tabuleiroPlayer);
				}
				else if(lastCommand.equals("1")) {
					game.setState(GameState.SHIP_SELECTION);
				}
				else if(lastCommand.equals("3")) {
					game.setState(GameState.EXIT_GAME);
				}
				else {
					System.out.println("Comando inválido!");
				}
				break;
			case SHIP_SELECTION:
				
				break;
			case PLAYING:
				
				break;
			case WIN:
				File ship = new File("src/imd/ufrn/br/visao/victory.txt");
				
				try {
		            Scanner scanner = new Scanner(ship);

		            while (scanner.hasNextLine()) {
		                String line = scanner.nextLine();
		                System.out.println(line);
		            }
		            scanner.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
				System.out.println("Pressione Enter para voltar ao menu.");
				scan.nextLine();
				game.setState(GameState.MENU);
				
				break;
			case GAME_OVER:
				System.out.println("Pressione Enter para voltar ao menu.");
				scan.nextLine();
				game.setState(GameState.MENU);
				break;
			case EXIT_GAME:
				
				break;
			}
		}
		
		System.out.println("Obrigado por jogar!");
		scan.close();
	}
	
	public static void printMenu(TabuleiroPlayer tabuleiro) {
		System.out.println("================================ BATALHA NAVAL ===============================\n");
		//tabuleiro.print();
		File ship = new File("src/imd/ufrn/br/visao/ship.txt");
		
		try {
            Scanner scanner = new Scanner(ship);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		System.out.println();
		System.out.println("1- Iniciar\t2- Controles\t3- Sair");
		System.out.println();
	}
	
	
	public static void printControles() {
		File controls = new File("src/imd/ufrn/br/controle/controls.txt");
		
		try {
            Scanner scanner = new Scanner(controls);
            Scanner read = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            
            System.out.println("Pressione enter para voltar.");
            read.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
