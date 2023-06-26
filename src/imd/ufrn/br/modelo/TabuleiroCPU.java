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
				System.out.print(getMapa()[x][y].getEstado() == 2 ? 0 : getMapa()[x][y].getEstado());
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int[] aim(Bloco[][] mapa) {
		int[] aimCPU = new int[2];
		
		if (mapa[this.hit[0]][this.hit[1]].getEstado() == 3) {
			if (this.hit[0] != 0 && this.hit[0] != 9 && this.hit[1] != 0 && this.hit[1] != 9) {
				int up = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int down = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				if ((up == 0 || up == 2) && (down == 0 || down == 2)
						&& (left == 0 || left == 2) && (right == 0 || right == 2)) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				} else if (up == 3 || down == 3) {
					aimCPU[0] = this.hit[0];
					if (up == 3 && down == 3) {
						try {
							for (int x = this.hit[1];;x++) {
								if (mapa[this.hit[0]][x].getEstado() != 3) {
									aimCPU[1] = x;
									break;
								}
							}
						} catch (Exception e) {
							for (int x = this.hit[1];;x--) {
								if (mapa[this.hit[0]][x].getEstado() != 3) {
									aimCPU[1] = x;
									break;
								}
							}
						}
					} else if (down == 0 || down == 2) {
						aimCPU[1] = this.hit[0] + 1;
					} else if (up == 0 || up == 2) {
						aimCPU[1] = this.hit[0] - 1;
					} else if (down == 1 || down == 5) {
						this.hit[1]--;
						aim(mapa);
					} else if (up == 1 || up == 5) {
						this.hit[1]++;
						aim(mapa);
					}
				} else if (left == 3 || right == 3) {
					aimCPU[1] = this.hit[1];
					if (left == 3 && right == 3) {
						try {
							for (int x = this.hit[0];;x++) {
								if (mapa[x][this.hit[1]].getEstado() != 3) {
									aimCPU[0] = x;
									break;
								}
							}
						} catch (Exception e) {
							for (int x = this.hit[0];;x--) {
								if (mapa[x][this.hit[1]].getEstado() != 3) {
									aimCPU[0] = x;
									break;
								}
							}
						}
					} else if (right == 0 || right == 2) {
						aimCPU[0] = this.hit[0] + 1;
					} else if (left == 0 || left == 2) {
						aimCPU[0] = this.hit[0] - 1;
					} else if (right == 1 || right == 5) {
						this.hit[0]--;
						aim(mapa);
					} else if (left == 1 || left == 5) {
						this.hit[0]++;
						aim(mapa);
					}
				} else if (((up == 1 || up == 5) || (down == 1 || down == 5))
						&& (left == 0 || left == 2) && (right == 0 || right == 2)) {
					aimCPU[0] = this.hit[0] - 1;
					aimCPU[1] = this.hit[1];
				} else if ((up == 0 || up == 2) && (down == 0 || down == 2)
						&& ((left == 1 || left == 5) || (right == 1 || right == 5))) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				}
			} else if (this.hit[0] == 0 && this.hit[1] == 0) {
				int down = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				if (down == 0 || down == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] + 1;
				} else if (right == 0 || right == 2) {
					aimCPU[0] = this.hit[0] + 1;
					aimCPU[1] = this.hit[1];
				}
			} else if (this.hit[0] == 0 && this.hit[1] == 9) {
				int up = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				if (up == 0 || up == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				} else if (right == 0 || right == 2) {
					aimCPU[0] = this.hit[0] + 1;
					aimCPU[1] = this.hit[1];
				}
			} else if (this.hit[0] == 9 && this.hit[1] == 0) {
				int down = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				
				if (down == 0 || down == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] + 1;
				} else if (left == 0 || left == 2) {
					aimCPU[0] = this.hit[0] - 1;
					aimCPU[1] = this.hit[1];
				}
			} else if (this.hit[0] == 9 && this.hit[1] == 9) {
				int up = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				
				if (up == 0 || up == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				} else if (left == 0 || left == 2) {
					aimCPU[0] = this.hit[0] - 1;
					aimCPU[1] = this.hit[1];
				}
			} else if (this.hit[0] == 0) {
				int down = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				if (left == 0 || left == 2) {
					aimCPU[0] = this.hit[0] - 1;
					aimCPU[1] = this.hit[1];
				} else if (right == 0 || right == 2) {
					aimCPU[0] = this.hit[0] + 1;
					aimCPU[1] = this.hit[1];
				} else if (down == 0 || down == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] + 1;
				}
			} else if (this.hit[0] == 1) {
				int up = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				if (left == 0 || left == 2) {
					aimCPU[0] = this.hit[0] - 1;
					aimCPU[1] = this.hit[1];
				} else if (right == 0 || right == 2) {
					aimCPU[0] = this.hit[0] + 1;
					aimCPU[1] = this.hit[1];
				} else if (up == 0 || up == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				}
			} else if (this.hit[1] == 0) {
				int up = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int down = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int right = mapa[this.hit[0] + 1][this.hit[1]].getEstado();
				
				if (up == 0 || up == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				} else if (down == 0 || down == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] + 1;
				} else if (right == 0 || right == 2) {
					aimCPU[0] = this.hit[0] + 1;
					aimCPU[1] = this.hit[1];
				}
			} else if (this.hit[1] == 1) {
				int up = mapa[this.hit[0]][this.hit[1] - 1].getEstado();
				int down = mapa[this.hit[0]][this.hit[1] + 1].getEstado();
				int left = mapa[this.hit[0] - 1][this.hit[1]].getEstado();
				
				if (up == 0 || up == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] - 1;
				} else if (down == 0 || down == 2) {
					aimCPU[0] = this.hit[0];
					aimCPU[1] = this.hit[1] + 1;
				} else if (left == 0 || left == 2) {
					aimCPU[0] = this.hit[0] - 1;
					aimCPU[1] = this.hit[1];
				}
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
			
			aimCPU[0] = getRandomNumber(0, 9);
			aimCPU[1] = getRandomNumber(0, 9);
		}
		
		return aimCPU;
	}
}