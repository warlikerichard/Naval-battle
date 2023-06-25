package imd.ufrn.br.modelo;

public class TabuleiroCPU extends Tabuleiro {
	
	public TabuleiroCPU() {
		super();
	}
	
	public void print() {
		for (int y = 0; y < 10 ; y++) {
			for (int x = 0; x < 10 ; x++) {
				System.out.print(getMapa()[x][y].getEstado() == 2 ? 0 : getMapa()[x][y].getEstado());
			}
			System.out.println();
		}
		System.out.println();
	}
}