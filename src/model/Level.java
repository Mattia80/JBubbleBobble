package model;

/**
 * Classe che rappresenta il modello di un livello del gioco
 */
public class Level extends AbstractModel {

	/**
	 * Il numero di nemici presenti nel livello
	 */
	private int enemies;
	/**
	 * Il numero di nemici uccisi durante il gioco
	 */
	private int enemiesKilled;
	/**
	 * Identifica il tempo in cui il livello e' stato completato
	 */
	private long clearedAt;
	/**
	 * Indica se il livello corrente e' terminato (ovvero sono stati uccisi tutti i
	 * nemici presenti)
	 */
	private boolean cleared;

	/**
	 * Restituisce il numero totale dei nemici presenti nel livello
	 * 
	 * @return il numero totale dei nemici presenti nel livello
	 */
	public int getEnemies() {
		return enemies;
	}

	/**
	 * Imposta il numero totale dei nemici presenti nel livello
	 * 
	 * @param enemies il numero totale dei nemici presenti nel livellos
	 */
	public void setEnemies(int enemies) {
		this.enemies = enemies;
	}

	/**
	 * Restituisce il numero di nemici uccisi
	 * 
	 * @return il numero di nemici uccisi
	 */
	public int getEnemiesKilled() {
		return enemiesKilled;
	}

	/**
	 * Imposta il numero di nemici uccisi
	 * 
	 * @param enemiesKilled il numero di nemici uccisi
	 */
	public void setEnemiesKilled(int enemiesKilled) {
		this.enemiesKilled = enemiesKilled;
	}

	/**
	 * REstituisce il tempo in cui il livello e' stato completato
	 * 
	 * @return il tempo in cui il livello e' stato completato
	 */
	public long getClearedAt() {
		return clearedAt;
	}

	/**
	 * Imposta il tempo in cui il livello e' stato completato
	 * 
	 * @param clearedAt il tempo in cui il livello e' stato completato
	 */
	public void setClearedAt(long clearedAt) {
		this.clearedAt = clearedAt;
	}

	/**
	 * Restituisce true se il livello e' stato completato, false altrimenti
	 * 
	 * @return true se il livello e' stato completato, false altrimenti
	 */
	public boolean isCleared() {
		return cleared;
	}

	/**
	 * Imposta true se il livello e' stato completato, false altrimenti
	 * 
	 * @param cleared true se il livello e' stato completato, false altrimenti
	 */
	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

}
