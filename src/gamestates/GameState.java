package gamestates;

/**
 * Enum che rappresenta gli stati del gioco: MENU -> menu principale, GAMEPLAY
 * -> gioco in corso, CONTINUE -> ripresa del gioco, RECORDS -> visualizzazione
 * dei punteggi migliori, GAMEOVER -> fine del gioco
 */
public enum GameState {

	MENU, GAMEPLAY, CONTINUE, RECORDS, GAMEOVER;

	/**
	 * Variabile che indica lo stato attuale del gioco. Viene inizializzata di
	 * default a MENU.
	 */
	public static GameState state = GAMEPLAY;

}
