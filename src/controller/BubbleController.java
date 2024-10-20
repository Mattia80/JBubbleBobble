package controller;

import model.Bubble;
import model.FireBubble;
import utility.GameConstants;
import utility.HelpMethods;

import static utility.GameConstants.Item.*;

/**
 * Classe che rappresenta il controller delle bolle presenti nel gioco
 */
public class BubbleController extends AbstractController implements ControllerInterface {
	/**
	 * Restituisce il modello di bolla associato al controller
	 * 
	 * @return
	 */
	public Bubble getBubble() {
		return (Bubble) this.model;
	}

	/**
	 * Rimuove la bolla
	 */
	public void removeBubble() {
		Bubble bubble = this.getBubble();
		bubble.setWidth(0);
		bubble.setHeight(0);
	}

	/**
	 * Metodo che aggiorna la posizione della bolla in base ai power up raccolti dal
	 * giocatore e ne coordina il movimento
	 */
	private void updateBubblePos() {
		Bubble bubble = this.getBubble();
		boolean[][] level = this.playing.getLevelController().getLevelTiles();

		if (!bubble.isPopped()) {
			if (!bubble.isFlying() || bubble instanceof FireBubble) {
				int bubbleRoute = this.playing.getPlayerController().hasItem(CANDY_PINK)
						? GameConstants.Tiles.TILES_SIZE * 6
						: GameConstants.Tiles.TILES_SIZE * 4;
				if (Math.abs(bubble.getX() - bubble.getShotX()) >= bubbleRoute) {
					if (bubble instanceof FireBubble) {
						bubble.setPopped(true);
					} else {
						bubble.setFlying(true);
					}
				} else {
					int bonus;
					float newX;
					if (bubble.isLeft()) {
						newX = bubble.getX() - bubble.getSpeed();
						bonus = -1;
					} else {
						newX = bubble.getX() + bubble.getSpeed();
						bonus = 1;
					}
					if (this.playing.getPlayerController().hasItem(CANDY_BLUE)) {
						newX += bonus;
					}

					if (HelpMethods.canMoveHere(newX, bubble.getY(), bubble.getWidth(), bubble.getHeight(), level)) {
						bubble.setX(newX);
					} else {
						bubble.setPopped(true);
					}

				}
			} else {
				float flyingSpeed = GameConstants.Bubble.FLYING_SPEED;
				float newY = bubble.getY() - flyingSpeed;
				if (HelpMethods.canMoveHere(bubble.getX(), newY, bubble.getWidth(), bubble.getHeight(), level))
					bubble.setY(newY);
				else {
					bubble.setPopped(true);
				}
			}
		}
	}
	/**
	 * Aggiorna lo stato delle varie bolle
	 */
	@Override
	public void update() {
		this.updateBubblePos();
		this.getBubble().notifyUpdate();
	}
}
