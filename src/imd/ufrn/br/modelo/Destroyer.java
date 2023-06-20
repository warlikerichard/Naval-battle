package imd.ufrn.br.modelo;

public class Destroyer extends Navio {
	
	public Destroyer(int sentido, int[] posicao) {
		super(5, sentido, posicao);
	}
	
	public Destroyer() {
		super(5, 0);
	}
}