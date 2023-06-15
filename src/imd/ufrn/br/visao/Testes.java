package imd.ufrn.br.visao;

import imd.ufrn.br.modelo.Tabuleiro;

public class Testes {
	public static void main(String args[]) {
		Tabuleiro tabuleiroPlayer = new Tabuleiro();
		Tabuleiro tabuleiroCPU = new Tabuleiro();
		
		System.out.println(tabuleiroPlayer.getMapa()[0][0]);
	}
}
