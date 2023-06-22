package imd.ufrn.br.visao;

import imd.ufrn.br.modelo.TabuleiroCPU;
import imd.ufrn.br.modelo.TabuleiroPlayer;

public class Testes {
	public static void main(String args[]) {
		TabuleiroCPU tabuleiroPlayer = new TabuleiroCPU();
		TabuleiroPlayer tabuleiroCPU = new TabuleiroPlayer();
		
		tabuleiroPlayer.print();
		System.out.println();
		System.out.println();
		tabuleiroCPU.print();
	}
}