package controller;

import java.time.Duration;

import gamestates.GameState;
import model.Game;
import model.Level;
import view.LevelView;

/**
 * Controller del livello generico del gioco. Estende la classe
 * AbstractController
 */
public class LevelController extends AbstractController {

	/**
	 * Restituisce il modello del livello associato al controller
	 * 
	 * @return il modello del livello associato al controller
	 */
	public Level getLevel() {
		return (Level) this.model;
	}

	/**
	 * Restituisce la view del livello associata al controller
	 * 
	 * @return la view del livello associata al controller
	 */
	public LevelView getLevelView() {
		return (LevelView) this.view;
	}

	/**
	 * Restituisce una matrice di valori booleani che rappresenta la disposizione
	 * dei vari Tiles che compongono il livello
	 * 
	 * @return matirce di booleani che rappresenta il livello
	 */
	public boolean[][] getLevelTiles() {
		return this.getLevelView().getLevelTiles();
	}

	/**
	 * Metodo che aumenta di 1 il numero di nemici nel livello attuale
	 */
	public void updateNumberOfEnemiesByOne() {
		Level level = this.getLevel();
		level.setEnemies(level.getEnemies() + 1);
	}

	/**
	 * Metodo che aumenta di 1 il numero di nemici sconfitti nel livello attuale
	 */
	public void updateNumberOfEnemiesKilledByOne() {
		Level level = this.getLevel();
		level.setEnemiesKilled(level.getEnemiesKilled() + 1);
		if (level.getEnemiesKilled() == level.getEnemies()) {
			level.setClearedAt(System.nanoTime());
			level.setCleared(true);
		}
	}

	/**
	 * Aggiorna lo stato del livello e verifica se il livello e' stato completato
	 * dal giocatore. Verifica inoltre se il giocatore ha completato tutti i livelli
	 * disponibili.
	 */
	@Override
	public void update() {
		Level level = this.getLevel();
		if (level.isCleared()) {
			Game game = Game.getInstance();
			if (game.getLevel() != 8) {
				long currentTime = System.nanoTime();
				long seconds = Duration.ofNanos(currentTime - level.getClearedAt()).toSeconds();
				if (seconds >= 5) {
					game.setLevel(game.getLevel() + 1);
					this.playing.reset();
				}
			} else {
				GameState.state = GameState.GAMEOVER;
			}
		}
	}

}
