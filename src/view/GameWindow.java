package view;

import javax.swing.JFrame;

/**
 * Rappresenta il Jframe necessario per visualizzare la schermata di gioco
 */
public class GameWindow {

	public GameWindow(GamePanel gamePanel) {

		JFrame frame = new JFrame();
		frame.add(gamePanel);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JBubbleBobble - v. 1.0");
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

}
