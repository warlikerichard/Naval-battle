package imd.ufrn.br.visao;

import imd.ufrn.br.modelo.Tabuleiro;
import imd.ufrn.br.modelo.TabuleiroCPU;
import imd.ufrn.br.modelo.TabuleiroPlayer;

public class Testes {
	public static void main(String args[]) {
		Tabuleiro tabuleiroPlayer = new TabuleiroPlayer();
		Tabuleiro tabuleiroCPU = new TabuleiroCPU();
		
		tabuleiroPlayer.print();
		System.out.println();
		System.out.println();
		tabuleiroCPU.print();
	}
}