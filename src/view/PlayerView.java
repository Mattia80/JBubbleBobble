package view;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import controller.PlayerController;
import model.Player;
import utility.LoadSave;
import static utility.GameConstants.Player.*;

/**
 * Classe che rappresenta la view assegnata al giocatore. implementa
 * l'interfaccia Observer
 */
@SuppressWarnings("deprecation")
public class PlayerView extends AbstractView implements Observer {
	/**
	 * variabile che racchiude le varie animazioni previste per il giocatore
	 */
	private BufferedImage[][] playerAnimations;
	/**
	 * indice dell'animazione in corso
	 */
	private int aniIndex;
	/**
	 * Tick dell'animazione corrente
	 */
	private int aniTick;
	/**
	 * Indice dell'animazione attualmente in corso
	 */
	private int currentAnimation;

	/**
	 * Costruttore della Player view
	 * 
	 * @param player           il giocatore associato alla view
	 * @param playerController il controller associato alla view
	 */
	public PlayerView(Player player, PlayerController playerController) {
		super(player, playerController);
		player.addObserver(this);
		this.loadAnimation();
	}

	/**
	 * Metodo che viene richiamato per disegnare il giocatore
	 * 
	 * @param g oggetto di tipo Graphis per disegnare sul JFrame
	 */
	@Override
	public void render(Graphics g) {
		Player player = this.getPlayer();

		int flipX = this.getPlayerController().getFlipX();
		int flipW = this.getPlayerController().getFlipW();
		g.drawImage(this.playerAnimations[this.currentAnimation][this.aniIndex], (int) player.getX() + flipX,
				(int) player.getY(), player.getWidth() * flipW, player.getHeight(), null);
	}

	/**
	 * Metodo che rileva un aggiornamento dell'object che viene osservato e aggiorna
	 * le animazioni del player
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.updateAniTick();
		this.updateAnimation();
	}

	/**
	 * Metodo che carica tutte le animazioni previste per il giocatore
	 */
	private void loadAnimation() {
		BufferedImage img = LoadSave.loadSprite(LoadSave.PLAYER);

		this.playerAnimations = new BufferedImage[7][6];
		for (int i = 0; i < playerAnimations.length; i++) {
			for (int j = 0; j < playerAnimations[0].length; j++) {
				playerAnimations[i][j] = img.getSubimage(j * 18, i * 18, 18, 18);
			}
		}
	}

	/**
	 * Metodo che aggiorna le animazioni in base all'azione che il giocatore sta
	 * compiendo
	 */
	private void updateAnimation() {
		Player player = this.getPlayer();
		int start = this.currentAnimation;

		if (player.isMoving()) {
			this.currentAnimation = RUN;
		} else {
			this.currentAnimation = IDLE;
		}

		if (player.isInAir()) {
			if (player.getAirSpeed() < 0)
				this.currentAnimation = JUMP;
			else
				this.currentAnimation = FALL;
		}

		if (player.isAttacking()) {
			this.currentAnimation = ATTACK;
		}
		if (player.isHit()) {
			this.currentAnimation = HIT;
		}

		if (start != currentAnimation) {
			this.resetAniTick();
		}

	}

	/**
	 * Metodo che aggiorna il contatore per la gestione della singola animazione
	 */
	private void updateAniTick() {
		this.aniTick++;
		int aniSpeed = 30;
		if (this.aniTick >= aniSpeed) {
			this.aniTick = 0;
			this.aniIndex++;
			if (this.aniIndex >= getNumberOfSprites(this.currentAnimation)) {
				this.aniIndex = 0;
				this.getPlayerController().stopAttack();
				if (this.currentAnimation == HIT)
					this.getPlayerController().dead();
			}
		}

	}

	/**
	 * Metodo che resetta il contatore per la gestione della singola animazione
	 */
	private void resetAniTick() {
		this.aniIndex = 0;
		this.aniTick = 0;
	}

	/**
	 * Restituisce il player associato alla vista
	 * 
	 * @return il player associato alla vista
	 */
	public Player getPlayer() {
		return (Player) (this.model);
	}

	/**
	 * Restituisce il controller associato alla vista
	 * 
	 * @return il controller associato alla vista
	 */
	public PlayerController getPlayerController() {
		return (PlayerController) (this.controller);
	}

}
