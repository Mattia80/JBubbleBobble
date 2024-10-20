package controller;

import gamestates.StateGameOver;

/**
 * Controller per il game over. Estende la classe AbstractController e
 * implementa l'interfaccia ControllerInterface
 */
public class GameOverController extends AbstractController implements ControllerInterface {

	/**
	 * Lo stato di game over associato al controller
	 */
	private StateGameOver gameOver;

	/**
	 * Restituisce lo stato di GameOver associato al controller
	 * 
	 * @return lo stato di GameOver associato al controller
	 */
	public StateGameOver getGameOver() {
		return gameOver;
	}

	/**
	 * Imposta lo stato di GameOver associato al controller
	 * 
	 * @param gameOver lo stato di GameOver associato al controller
	 */
	public void setGameOver(StateGameOver gameOver) {
		this.gameOver = gameOver;
	}
	
	/**
	 * Aggiorna lo stato GameOver
	 */
	@Override
	public void update() {

	}
}
