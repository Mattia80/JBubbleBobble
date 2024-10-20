package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import controller.GameManager;
//import controller.ScoresBoardController;
//import view.ScoreView;

/**
 * Classe che rappresenta lo stato relativo alla classifica dei punteggi
 * migliori. Estende la classe AbstractGameState e implementa l'interfaccia
 * StateInterface
 */
public class StateRecord extends AbstractGameState implements StateInterface {
	
	/**
	 * Controller della calssifica associata allo stato corrente
	 */
//	private ScoresBoardController scoresBoardController;
	/**
	 * Costruttore dello stato della leaderboard
	 * @param game istanza di gioco corrente
	 */
	public StateRecord(GameManager game) {
		super(game);
		this.init();
	}
	/**
	 * Inizializza lo stato Scores Board, creando il rispettivo controller e la
	 * rispettiva view e le associa
	 */
	private void init() {	
//		this.scoresBoardController = new ScoresBoardController();
//		this.scoresBoardController.setView(new ScoreView());
	}
	/**
	 * Gestisce l'aggiornameto dello stato di gioco durante la visualizzazione della
	 * schermata della classifica dei punteggi
	 */
	@Override
	public void update() {
//		this.scoresBoardController.update();
	}
	/**
	 * Renderizza la schermata dei punteggi su schermo
	 */
	@Override
	public void draw(Graphics g) {
//		this.scoresBoardController.renderView(g);
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
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE -> GameState.state = GameState.MENU;
		}
	}
	/**
	 * Gestisce l'evento di rilascio di un tasto della tastiera
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
