package imd.ufrn.br.modelo;

public class TabuleiroPlayer extends Tabuleiro {
	
	public TabuleiroPlayer() {
		super();
	}
	
	public void print() {
		for (int y = 0; y < 10 ; y++) {
			for (int x = 0; x < 10 ; x++) {
				System.out.print(getMapa()[x][y].getEstado());
			}
			System.out.println();
		}
		System.out.println();
	}
}