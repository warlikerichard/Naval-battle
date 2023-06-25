package imd.ufrn.br.controle;
import imd.ufrn.br.modelo.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameStarter {
	private TabuleiroCPU tabuleiroCPU;
	private TabuleiroPlayer tabuleiroPlayer;
	private File controls = new File("src/imd/ufrn/br/controle/controls.txt");
	
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
	
	public void printMenu() {
		System.out.println("================== BATALHA NAVAL =================\n");
		tabuleiroPlayer.print();
		System.out.println("1- Iniciar\t2- Controles\t3- Sair");
		System.out.println();
		
	}
	
	public void printControles() {
		try {
            Scanner scanner = new Scanner(controls);
            Scanner read = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            
            System.out.println("Pressione enter para voltar.");
            read.nextLine();
            read.close();
            scanner.close();
            
            printMenu();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

}