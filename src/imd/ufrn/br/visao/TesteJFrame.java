package imd.ufrn.br.visao;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TesteJFrame extends JFrame {
	
	public TesteJFrame() {
		setSize(800, 350);
		setTitle("Batalha Naval");
	}
	
	public static void main(String[] args) {
		TesteJFrame screen = new TesteJFrame();
		screen.setVisible(true);
	}
}