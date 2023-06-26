package imd.ufrn.br.modelo;

public class TabuleiroCPU extends Tabuleiro {
	
	int[] hit;
	
	public TabuleiroCPU() {
		super();
		hit = new int[2];
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
	
	public int[] aim(Bloco[][] mapa) {
		int[] aimCPU = new int[2];
		/*
		if (mapa[this.hit[0]][this.hit[1]].getEstado() == 3) {
			if (this.hit[0] != 0 && this.hit[0] != 9 && this.hit[1] != 0 && this.hit[1] != 9) {
				int up = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int down = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				
			}
		} else {
			for (int x = 0; x < 10 ; x++) {
				for (int y = 0; y < 10 ; y++) {
					if (mapa[x][y].getEstado() == 3) {
						hit[0] = x;
						hit[1] = y;
						
						return aim(mapa);
					}
				}
			}
			*/
			aimCPU[0] = getRandomNumber(0, 9);
			aimCPU[1] = getRandomNumber(0, 9);
		//}
		
		return aimCPU;
	}
}