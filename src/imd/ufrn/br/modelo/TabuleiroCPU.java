package imd.ufrn.br.modelo;

public class TabuleiroCPU extends Tabuleiro {
	
	public TabuleiroCPU() {
		super();
	}
	
	public void print() {
		for (int y = 0; y < 10 ; y++) {
			for (int x = 0; x < 10 ; x++) {
				String state = String.valueOf(String.valueOf(getMapa()[x][y].getEstado()));
				
				System.out.print(state.equals("1") ? "X " : state.equals("2") ? "0 " : state.equals("3") ? "* " : state.equals("4") ? "- " : "0 ");
			}
			System.out.println();
		}
		System.out.println();
	}
}