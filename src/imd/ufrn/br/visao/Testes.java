package imd.ufrn.br.visao;

import imd.ufrn.br.modelo.Tabuleiro;

public class Testes {
	public static void main(String args[]) {
		Tabuleiro tabuleiroPlayer = new Tabuleiro();
		Tabuleiro tabuleiroCPU = new Tabuleiro();
		
		tabuleiroPlayer.print();
		System.out.println();
		System.out.println();
		tabuleiroCPU.print();
	}
}