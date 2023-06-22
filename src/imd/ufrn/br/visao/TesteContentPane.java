package imd.ufrn.br.visao;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TesteContentPane extends JFrame {

    private JPanel gameBoard;
    private JLabel[][] boardCells;
    private JLabel selectedShip;

    public TesteContentPane() {
        initializeWindow();
        initializeBoard();
    }

    private void initializeWindow() {
        setTitle("Ship Battle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 350);
        setLocationRelativeTo(null); // Centers the window on the screen
    }

    private void initializeBoard() {
        gameBoard = new JPanel(new GridLayout(10, 10));
        boardCells = new JLabel[10][10];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JLabel cell = new JLabel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                // Add a mouse listener to handle dragging ships
                cell.addMouseListener(new ShipDragListener());

                boardCells[row][col] = cell;
                gameBoard.add(cell);
            }
        }

        add(gameBoard);
    }

    private class ShipDragListener extends MouseAdapter {
        private Point offset;

        @Override
        public void mousePressed(MouseEvent e) {
            JLabel cell = (JLabel) e.getSource();

            // Check if the selected cell contains a ship
            if (!cell.getText().isEmpty()) {
                selectedShip = cell;
                offset = e.getPoint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (selectedShip != null) {
                int cellWidth = gameBoard.getWidth() / 10;
                int cellHeight = gameBoard.getHeight() / 10;

                // Calculate the new position based on the drag offset
                int newX = e.getX() - offset.x + selectedShip.getX();
                int newY = e.getY() - offset.y + selectedShip.getY();

                // Adjust the position to keep the ship within the board bounds
                newX = Math.max(0, Math.min(newX, gameBoard.getWidth() - selectedShip.getWidth()));
                newY = Math.max(0, Math.min(newY, gameBoard.getHeight() - selectedShip.getHeight()));

                // Snap the position to the nearest cell
                int snappedX = Math.round((float) newX / cellWidth) * cellWidth;
                int snappedY = Math.round((float) newY / cellHeight) * cellHeight;

                selectedShip.setLocation(snappedX, snappedY);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            selectedShip = null;
        }
    }

    public static void main(String[] args) {
    	TesteContentPane game = new TesteContentPane();
        game.setVisible(true);
    }
}