package gamestates;

import controller.GameManager;

/**
 * Classe che rappresente uno stato astratto del gioco
 */
public abstract class AbstractGameState implements StateInterface {
	/**
	 * L'instanza del game associato a questo stato
	 */
	protected GameManager game;

	/**
	 * Construttore della classe AbstractGameState. La classe viene costruita con
	 * una istanza del game
	 * 
	 * @param game instanza del game
	 */
	public AbstractGameState(GameManager game) {
		this.game = game;
	}

	/**
	 * Restituisce il game associato allo stato
	 * 
	 * @return il game associato allo stato
	 */
	public GameManager getGame() {
		return game;
	}

	/**
	 * Imposta il game associato allo stato
	 * 
	 * @param game il game da associare allo stato
	 */
	public void setGame(GameManager game) {
		this.game = game;
	}

}
