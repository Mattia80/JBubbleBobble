package controller;

import java.awt.Graphics;

import gamestates.GameState;
import gamestates.StateGameOver;
import gamestates.StateGamePlay;
import gamestates.StateMenu;
import gamestates.StateRecord;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import view.GamePanel;
import view.GameWindow;

/**
 * Classe che rappresenta il game engine del gioco stesso: inizializza le classi
 * necessarie, avvia il game loop, gestisce sia gli aggiornamenti verso il model
 * e il refresh a video delle varie view
 */
public class GameManager implements Runnable {
	/**
	 * Campo statico che identifica l'istanza della classe. Implementato per l'uso
	 * del pattern singleton
	 */
	private static GameManager instance;
	/**
	 * Rappresenta il Panel associato all'istanza del gioco
	 */
	private final GamePanel gamePanel;
	/**
	 * Rappresenta il numero di frame (Frame Per Seconds) del gioco
	 */
	private final int FPS = 120;
	/**
	 * Rappresenta il numero di aggiornamenti (Update Per Seconds) del gioco
	 */
	private final int UPS = 200;
	/**
	 * Rappresenta lo stato del menu del gioco
	 */
	private StateMenu menuState;
	/**
	 * Rappresenta lo stato attuale della partita in corso
	 */
	private StateGamePlay gamePlayState;
	/**
	 * Rappresenta lo stato di Game Over
	 */
	private StateGameOver gameOverState;
	/**
	 * Rappresenta lo stato dei punteggi migliori
	 */
	private StateRecord recordsState;

	/**
	 * Costruttore privato della classe Game Implementato come costruttore privato
	 * per l'uso del singleton
	 */
	private GameManager() {
		this.gamePanel = new GamePanel(this);
		this.initClasses();
		new GameWindow(this.gamePanel);
		this.gamePanel.setFocusable(true);
		this.gamePanel.requestFocus();
	}

	/**
	 * Metodo statico che recupera il valore del campo statico instance. Se la
	 * classe non e' mai stata istanziata (instance == null) crea una nuova istanza
	 * della classe. Implementato per l'uso del singleton.
	 * 
	 * @return instanza della classe
	 */
	public static GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

	/**
	 * Restituisce il gamePanel associato al gioco
	 * 
	 * @return il gamePanel associato al gioco
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	/**
	 * Metodo che inizializza le cassi dei rispettivi stati
	 */
	public void initClasses() {
//		this.menuState = new StateMenu(this);
		this.gamePlayState = new StateGamePlay(this);
		this.gameOverState = new StateGameOver(this);
		this.recordsState = new StateRecord(this);
	}

	/**
	 * Inizializza i listeners per gli input del mouse e della tastiera
	 */
	public void initListeners() {
		MouseInputs mouseInputs = new MouseInputs(this);
		this.gamePanel.addKeyListener(new KeyboardInputs(this));
		this.gamePanel.addMouseListener(mouseInputs);
		this.gamePanel.addMouseMotionListener(mouseInputs);
	}

	/**
	 * Metodo che avvia il gioco. Inizializza i vari listeners degli input, avvia il
	 * Thread per il refresh delle view e l'aggiornamento degli oggetti impattati e
	 * riproduce la traccia audio
	 */
	public void startGame() {
		this.initListeners();
		this.startGameLoop();
		// aggiungere il codice per la gestione dell'audio
	}

	/**
	 * Metodo che richiede l'aggiornamento degli oggetti associati allo stato
	 * specifico
	 */
	public void update() {
		switch (GameState.state) {
		case CONTINUE:
			this.gamePlayState.update();
			break;
		case GAMEOVER:
			this.gameOverState.update();
			break;
		case GAMEPLAY:
			this.gamePlayState.update();
			break;
		case MENU:
			this.menuState.update();
			break;
		case RECORDS:
			this.recordsState.update();
			break;		
		}
	}

	/**
	 * Metodo che richiede l'aggiornamento delle view associate allo stato specifico
	 * 
	 * @param g oggetto di tipo Graphis per disegnare sul JFrame
	 */
	public void render(Graphics g) {
		
		switch (GameState.state) {
		case CONTINUE:
			this.gamePlayState.draw(g);
			break;
		case GAMEOVER:
			this.gameOverState.draw(g);
			break;
		case GAMEPLAY:
			this.gamePlayState.draw(g);
			break;
		case MENU:
			this.menuState.draw(g);
			break;
		case RECORDS:
			this.recordsState.draw(g);
			break;
		}		
	}

	/**
	 * Restituisce l'istanza corrente dello stato GamePlay
	 * 
	 * @return istanza corrente dello stato GamePlay
	 */
	public StateGamePlay getGamePlayState() {
		return gamePlayState;
	}

	/**
	 * Imposta l'istanza corrente dello stato GamePlay. Viene chiamato quando viene
	 * inizializzata una nuova partita
	 * 
	 * @param gamePlayState istanza corrente dello stato GamePlay
	 */
	public void setGamePlayState(StateGamePlay gamePlayState) {
		this.gamePlayState = gamePlayState;
	}

	/**
	 * Restituisce l'istanza corrente dello stato GameOver
	 * 
	 * @return istanza corrente dello stato GameOver
	 */
	public StateGameOver getGameOverState() {
		return gameOverState;
	}

	/**
	 * Metodo che inizializza l'istanza dello stato GameOver
	 * 
	 * @param gameOverState istanza dello stato GamoOver
	 */
	public void setGameOverState(StateGameOver gameOverState) {
		this.gameOverState = gameOverState;
	}

	/**
	 * Restituisce l'istanza corrente dello stato Menu
	 * 
	 * @return istanza corrente dello stato Menu
	 */
	public StateMenu getMenuState() {
		return menuState;
	}

	/**
	 * Restituisce l'istanza corrente dello stato Record
	 * 
	 * @return istanza corrente dello stato Record
	 */
	public StateRecord getRecordsState() {
		return recordsState;
	}

	/**
	 * Spiegare il loop!!!
	 */
	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS;
		double timePerUpdate = 1000000000.0 / UPS;

		long previousTime = System.nanoTime();
		long lastCheck = System.currentTimeMillis();

		int frames = 0;
		int updates = 0;
		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				this.update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				this.gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	/**
	 * Metodo che avvia il thread per il game loop
	 */
	private void startGameLoop() {
		Thread thread = new Thread(this);
		thread.start();
	}

}
