package imd.ufrn.br.modelo;

public class Fragata extends Navio {
	
	public Fragata(int sentido, int[] posicao) {
		super(4, sentido, posicao);
	}
	
	public Fragata() {
		super(5, 0);
	}
}