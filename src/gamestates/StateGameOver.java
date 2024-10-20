package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import controller.GameManager;
import controller.GameOverController;
import view.GameOverView;

/**
 * Classe che rappresenta lo stato di gioco Game Over. Estende la classe
 * AbstractGameState e implementa l'interfaccia StateInterface
 */
public class StateGameOver extends AbstractGameState implements StateInterface {

	/**
	 * Controller Game Over associato allo stato
	 */
	private GameOverController gameOverController;

	/**
	 * Costruisce un'istanza dello stato Game Over
	 * 
	 * @param game istanza del game associato allo stato corrente
	 */
	public StateGameOver(GameManager game) {
		super(game);
		this.init();
	}

	/**
	 * Inizializza lo stato Game Over, creando il rispettivo controller e la
	 * rispettiva view e le associa 
	 */
	private void init() {
		this.gameOverController = new GameOverController();
		this.gameOverController.setGameOver(this);
		GameOverView gameOverOverView = new GameOverView(this.gameOverController);
		this.gameOverController.setView(gameOverOverView);
	}

	/**
	 * Gestisce l'aggiornameto dello stato di gioco durante la visualizzazione della
	 * schermata Game Over
	 */
	@Override
	public void update() {
	}

	/**
	 * Renderizza la schermata di Game Over su schermo
	 */
	@Override
	public void draw(Graphics g) {
		this.gameOverController.renderView(g);
	}

	/**
	 * Gestisce l'evento di pressione del tasto del mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Gestisce l'evento di rilascio del tasto del mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/**
	 * Gestisce l'evento di movimento del mouse
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * Gestisce l'evento di pressione di un tasto della tastiera
	 */
	@Override
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Gestisce l'evento di rilascio di un tasto della tastiera
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
