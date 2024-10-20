package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.GameManager;
import utility.GameConstants;

/**
 * Classe che rappresenta il Panel che sara' contenuto nel JFrame e su cui
 * verra' disegnato il gioco effettivo
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	/**
	 * Istanza di Game
	 */
	private final GameManager game;

	/**
	 * Costruttore della classe GamePanel
	 * 
	 * @param game istanza del Game
	 */
	public GamePanel(GameManager game) {
		this.game = game;
		this.setSize();
		this.setBackground(Color.BLACK);
	}

	/**
	 * Metodo privato che consente di impostare le misure del panel, impostandolecon
	 * i valori GAME_WIDTH e GAME_HEIGHT presenti nel package utility ->
	 * GameConstant -> Game
	 */
	private void setSize() {
		Dimension dimension = new Dimension(GameConstants.Game.GAME_WIDTH, GameConstants.Game.GAME_HEIGHT);
		this.setMinimumSize(dimension);
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);

	}

	/**
	 * Metodo per disegnare effettivamente sul Panel.
	 * 
	 * @param g: oggetto di tipo Graphis per disegnare sul JFrame
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.game.render(g);
	}

}
