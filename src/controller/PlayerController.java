package controller;

import model.Bubble;
import model.FireBubble;
import model.Game;
//import model.Item;
import model.Player;
import utility.GameConstants;
import utility.HelpMethods;
import view.BubbleView;
import view.PlayerView;
import java.time.Duration;
import gamestates.StateGamePlay;
import static utility.GameConstants.Directions.*;
import static utility.GameConstants.Item.*;

/**
 * Controller del player. Gestisce le azioni del giocatore durante il gioco
 */
public class PlayerController extends AbstractController {

	/**
	 * campo utilizzato per il valore di ribaltamento dello sprite del giocatore
	 */
	private int flipX = 0;
	/**
	 * campo utilizzato per il ribaltamento dello sprite del giocatore
	 */
	private int flipW = 1;

	/**
	 * Restituisce il valore del ribaltamento del giocatore
	 * 
	 * @return il valore del ribaltamento del giocatore
	 */
	public int getFlipX() {
		return flipX;
	}

	/**
	 * Restituisce lo stato di ribaltamento dello sprite del giocatore
	 * 
	 * @return lo stato di ribaltamento dello sprite del giocatore
	 */
	public int getFlipW() {
		return flipW;
	}

	/**
	 * Metodo che consente l'aggiornamento del giocatore
	 */
	@Override
	public void update() {
		this.updatePlayerPos();
		this.getPlayer().notifyUpdate();
	}

	/**
	 * Restituisce il giocatore associato al controller
	 * 
	 * @return il giocatore associato al controller
	 */
	public Player getPlayer() {
		return (Player) this.model;
	}

	/**
	 * Restituisce la view associata al controller
	 * 
	 * @return la view associata al controller
	 */
	public PlayerView getView() {
		return (PlayerView) this.view;
	}

	/**
	 * Ferma l'attacco del giocatore
	 */
	public void stopAttack() {
		this.getPlayer().setAttacking(false);
	}

	/**
	 * Restituisce true se il player ha l'item passato in input, false altrimenti
	 * 
	 * @param item item da verificare
	 * @return true se il player ha l'item passato in input, false altrimenti
	 */
	public boolean hasItem(int item) {
		return this.getPlayer().hasItem(item);
	}

	/**
	 * Metodo che permette al giocatore di sparare bolle
	 */
	public void shoot() {

		Player player = this.getPlayer();

		long currentTime = System.nanoTime();
		long seconds = Duration.ofNanos(currentTime - player.getLastBubbleShot()).toMillis();

		if (seconds > 400 || player.hasItem(CANDY_YELLOW)) {
			player.setAttacking(true);

			StateGamePlay gameState = this.playing;
			Bubble bubble;

			if (player.hasItem(CROSS_RED)) {
				bubble = new FireBubble(player.getX() + player.getWidth() * this.flipW, player.getY(),
						(int) (32 * GameConstants.Tiles.SCALE), (int) (32 * GameConstants.Tiles.SCALE));

			} else {
				bubble = new Bubble(player.getX() + player.getWidth() * this.flipW, player.getY(),
						(int) (32 * GameConstants.Tiles.SCALE), (int) (32 * GameConstants.Tiles.SCALE));
			}

			bubble.setLeft(flipW == -1);
			bubble.setRight(flipW == 1);

			BubbleController bubbleController = new BubbleController();
			BubbleView bubbleView = new BubbleView(bubble, bubbleController);

			bubbleController.setModel(bubble);
			bubbleController.setView(bubbleView);
			bubbleController.setPlaying(gameState);

			player.setLastBubbleShot(System.nanoTime());

			gameState.getBubbleControllers().add(bubbleController);
			if (player.hasItem(RING_RED)) {
				Game.getInstance().updatePoints(100);
			}

			// aggiungere codice per la gestione dell'audio
		}

	}

	/**
	 * Metodo che aggiorna la direzione del giocatore durante il gioco
	 * 
	 * @param direction       la direzione corrente
	 * @param isThisDirection valore booleano che viene impostato in base alla
	 *                        direzione presa
	 */
	public void updateDir(int direction, boolean isThisDirection) {
		Player player = this.getPlayer();

		switch (direction) {
		case LEFT -> player.setLeft(isThisDirection);
		case RIGHT -> player.setRight(isThisDirection);
		}

	}

	/**
	 * Metodo che gestisce l'avvenuto contatto con un nemico
	 */
	public void hit() {
		Player player = this.getPlayer();

		if (!player.isHit()) {
			player.setHit(true);
			// inserire il codice per il file audio
		}
	}

	/**
	 * Metodo che gestisce la morte del giocatore
	 */
	public void dead() {
		Game g = Game.getInstance();
		g.setLives(g.getLives() - 1);
		this.playing.reset();
	}

	/**
	 * Gestisce la raccolta di oggetti durante il gioco
	 * 
	 * @param item oggetto raccolto
	 */
//	public void collectItem(Item item) {
//		this.getPlayer().addItem(item.getType());
//	}

	/**
	 * Metodo che gestisce l'aggiornamento della posizione del giocatore nelle varie
	 * casistiche possibili
	 */
	public void updatePlayerPos() {
		Player player = this.getPlayer();
		boolean[][] level = this.playing.getLevelController().getLevelTiles();

		player.setMoving(false);

		if (!HelpMethods.isEntityOnFloor(player, level)) {
			player.setInAir(true);
		}

		if (player.isJump())
			this.jump();

		if (!player.isLeft() && !player.isRight() && !player.isInAir()) {
			return;
		}

		float xSpeed = 0;
		float playerSpeed = player.hasItem(BEER) ? player.getSpeed() + 1 : player.getSpeed();

		if (player.isLeft()) {
			xSpeed -= playerSpeed;
			flipX = player.getWidth();
			flipW = -1;
		}

		if (player.isRight()) {
			xSpeed += playerSpeed;
			flipX = 0;
			flipW = 1;
		}

		if (!player.isInAir()) {
			if (HelpMethods.isEntityOnFloor(player, level))
				player.setInAir(true);
		}

		if (player.isInAir()) {
			boolean canMove = HelpMethods.canMoveHere(player.getX(), player.getY() + player.getAirSpeed(), player.getWidth(),
					player.getHeight(), level);
			if (canMove || player.isJump()) {
				if (player.getY() + player.getAirSpeed() > player.getY()) {
					player.setJump(false);
				}
				if (player.getY() > GameConstants.Game.GAME_HEIGHT) {
					player.setY(0);
				} else {
					player.setY(player.getY() + player.getAirSpeed());
				}
				player.setAirSpeed(player.getAirSpeed() + GameConstants.Game.GRAVITY);
				this.updateXPosition(xSpeed);

			} else {
				if (player.getAirSpeed() > 0)
					this.resetInAir();
				else {
					player.setAirSpeed(GameConstants.Player.FALL_SPEED);
					player.setJump(false);
				}
				this.updateXPosition(xSpeed);
			}
		} else {
			this.updateXPosition(xSpeed);
		}

		player.setMoving(true);

	}

	/**
	 * Metodo che gestisce il salto per player
	 */
	public void jump() {
		Player player = this.getPlayer();

		if (!player.isInAir()) {
			player.setInAir(true);
			player.setAirSpeed(GameConstants.Player.JUMP_SPEED);
			if (player.hasItem(RING_PINK)) {
				Game.getInstance().updatePoints(500);
			}
			// aggiungere codice per file audio
		}

	}

	/**
	 * Metodo che resetta i valori corrispondenti quando il player e' in aria
	 */
	public void resetInAir() {
		this.getPlayer().setInAir(false);
		this.getPlayer().setAirSpeed(0);
	}

	/**
	 * Metodo che aggiorna la posizione orizzontale del giocatore in base alla
	 * velocita'
	 * 
	 * @param speed velocita' del giocatore
	 */
	public void updateXPosition(float speed) {
		Player player = this.getPlayer();

		boolean canMove = HelpMethods.canMoveHere(player.getX() + speed, player.getY(), player.getWidth(),
				player.getHeight(), this.playing.getLevelController().getLevelTiles());
		if (canMove) {
			player.setX(player.getX() + speed);
			if (player.hasItem(RING_CYAN)) {
				Game.getInstance().updatePoints(20);
			}
		}
	}

}
