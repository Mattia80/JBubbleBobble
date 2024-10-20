package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import controller.BubbleController;
//import controller.EnemyController;
import controller.GameManager;
//import controller.ItemController;
import controller.LevelController;
import controller.PlayerController;
//import model.AbstractEnemy;
//import model.Benzo;
//import model.Blubba;
//import model.BonnieBo;
import model.Game;
import model.Level;
import model.Player;
//import model.PowerUp;
import utility.GameConstants;
import utility.HelpMethods;
//import view.EnemyView;
//import view.ItemView;
import view.LevelView;
import view.PlayerView;
import static utility.GameConstants.Enemy.*;
import static utility.GameConstants.Directions.*;

/**
 * Classe che rappresenta lo stato di gioco in corso. Estende la classe
 * AbstractGameState e implementa l'interfaccia StateInterface
 */
public class StateGamePlay extends AbstractGameState implements StateInterface {
	/**
	 * Controller del player
	 */
	private PlayerController playerController;
	/**
	 * Controller del livello
	 */
	private LevelController levelController;
	/**
	 * Lista di controller dei nemici
	 */
//	private ArrayList<EnemyController> enemyControllers;
	/**
	 * Lista dei controller delle bolle
	 */
	private ArrayList<BubbleController> bubbleControllers;
	/**
	 * Lista dei controller dei power up presenti nella partita
	 */
//	private ArrayList<ItemController> itemControllers;

	/**
	 * Costruttore della classe StateGamePlay
	 * 
	 * @param game istanza del gioco
	 */
	public StateGamePlay(GameManager game) {
		super(game);
		this.bubbleControllers = new ArrayList<BubbleController>();
//		this.itemControllers = new ArrayList<ItemController>();
		this.init();
	}

	/**
	 * Restituisce il controller del giocatore
	 * 
	 * @return il controller del giocatore
	 */
	public PlayerController getPlayerController() {
		return this.playerController;
	}

	/**
	 * REstituisce il controller del livello
	 * 
	 * @return il controller del livello
	 */
	public LevelController getLevelController() {
		return this.levelController;
	}

	/**
	 * Restituisce la lista dei controller dei nemici
	 * 
	 * @return la lista dei controller dei nemici
	 */
//	public ArrayList<EnemyController> getEnemyControllers() {
//		return this.enemyControllers;
//	}

	/**
	 * Restituisce la lista dei controller delle bolle
	 * 
	 * @return la lista dei controller delle bolle
	 */
	public ArrayList<BubbleController> getBubbleControllers() {
		return this.bubbleControllers;
	}

	/**
	 * Restituisce la lista dei controller degli oggetti
	 * 
	 * @return la lista dei controller degli oggetti
	 */
//	public ArrayList<ItemController> getItemControllers() {
//		return this.itemControllers;
//	}

	/**
	 * Inizializza lo stato di gioco, il giocatore, il livello, i nemici e i power
	 * up
	 */
	public void init() {
		this.initGame();
		this.initPlayer();
		this.initLevel();
//		this.initEnemies();
//		this.initPowerUp();
	}

	/**
	 * Resetta lo stato di gioco
	 */
	public void reset() {
		Game game = Game.getInstance();

		if (game.getLives() > 0) {
			this.bubbleControllers = new ArrayList<BubbleController>();
//			this.itemControllers = new ArrayList<ItemController>();
			this.initPlayer();
			this.initLevel();
//			this.initEnemies();
//			this.initPowerUp();
		} else {
			GameState.state = GameState.GAMEOVER;
		}
	}

	/**
	 * Inizializza il giocatore nel livello di gioco. Il metodo percorre il file di
	 * configurazione del livello e in corrispondenza del carattere 'S' crea il
	 * giocatore, il relativo controller e la rispettiva view
	 */
	private void initPlayer() {
		String path = "/levels/level_" + Game.getInstance().getLevel() + ".txt";

		try (InputStream is = LevelView.class.getResourceAsStream(path)) {
			if (is == null) {
				throw new FileNotFoundException(path);
			}
			try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
				String line = in.readLine();
				int lineNumber = 0;
				while (line != null) {
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == 'S') {
							this.playerController = new PlayerController();
							Player player = new Player(i * GameConstants.Tiles.TILES_SIZE,
									lineNumber * GameConstants.Tiles.TILES_SIZE, (int) (32 * GameConstants.Tiles.SCALE),
									(int) (32 * GameConstants.Tiles.SCALE));
							PlayerView playerView = new PlayerView(player, this.playerController);
							this.playerController.setModel(player);
							this.playerController.setView(playerView);
							this.playerController.setPlaying(this);
							break;
						}
					}
					lineNumber++;
					line = in.readLine();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Inizializza il livello e associa i rispettivi controller e view
	 */
	private void initLevel() {
		this.levelController = new LevelController();
		Level level = new Level();
		LevelView levelView = new LevelView(level, levelController);
		this.levelController.setModel(level);
		this.levelController.setView(levelView);
		this.levelController.setPlaying(this);
	}

	/**
	 * Crea una nuova istanza di gioco principale
	 */
	@SuppressWarnings("unused")
	private void initGame() {
		Game game = Game.newInstance();
	}

	/**
	 * Inizializza i nemici previsti per il livello attuale e associa loro i
	 * rispettivi controller. Ogni controller viene aggiunto alla lista
	 */
//	private void initEnemies() {
//		this.enemyControllers = new ArrayList<EnemyController>();
//		String path = "/levels/level_" + Game.getInstance().getLevel() + ".txt";
//
//		try (InputStream is = LevelView.class.getResourceAsStream(path)) {
//			if (is == null) {
//				throw new FileNotFoundException(path);
//			}
//			try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
//				String line = in.readLine();
//				int lineNumber = 0;
//
//				while (line != null) {
//					for (int i = 0; i < line.length(); i++) {
//						if (!HelpMethods.isNumeric(line.substring(i, i + 1))) {
//							continue;
//						}
//
//						int enemyType = Integer.parseInt(line.substring(i, i + 1));
//						this.createEnemy(enemyType, i, lineNumber);
//					}
//					lineNumber++;
//					line = in.readLine();
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * Crea il nemico in base all'enemy type passato in input
	 * 
	 * @param enemyType tipo di nemico
	 * @param row       posizione x del nemico
	 * @param column    posizione y del nemico
	 */
//	private void createEnemy(int enemyType, int row, int column) {
//		AbstractEnemy model = null;
//
//		int x = row * GameConstants.Tiles.TILES_SIZE;
//		int y = column * GameConstants.Tiles.TILES_SIZE;
//
//		switch (enemyType) {
//			case BENZO -> model = new Benzo(x, y);
//			case BLUBBA -> model = new Blubba(x, y);
//			case BONNIEBO -> model = new BonnieBo(x, y);
//		}
//
//		EnemyController enemyController = new EnemyController();
//		EnemyView enemyView = new EnemyView(model, enemyController);
//		enemyController.setModel(model);
//		enemyController.setView(enemyView);
//		enemyController.setPlaying(this);
//		this.enemyControllers.add(enemyController);
//		this.levelController.updateNumberOfEnemiesByOne();
//	}

	/**
	 * Inizializza i power up previsti per il livello attuale e associa loro i
	 * rispettivi controller. Ogni controller viene aggiunto alla lista
	 */
//	private void initPowerUp() {
//		boolean spawned = false;
//		int totPercentage = 0;
//		Map<Integer, Integer> powerUps = GameConstants.Item.powerUpChances;
//		for (int percentage : powerUps.values()) {
//			totPercentage += percentage;
//		}
//
//		String path = "/levels/level_" + Game.getInstance().getLevel() + ".txt";
//
//		try (InputStream is = LevelView.class.getResourceAsStream(path)) {
//			if (is == null) {
//				throw new FileNotFoundException(path);
//			}
//
//			try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
//				String line = in.readLine();
//				int lineNumber = 0;
//
//				while (line != null) {
//					if (spawned)
//						break;
//					for (int i = 0; i < line.length(); i++) {
//						if (line.charAt(i) == 'I') {
//							Random random = new Random();
//							int randomNum = random.nextInt(totPercentage) + 1;
//							for (Map.Entry<Integer, Integer> entry : powerUps.entrySet()) {
//								totPercentage += entry.getValue();
//								if (randomNum <= totPercentage
//										&& randomNum < GameConstants.Item.GENERATE_POWER_UP_THRESHOLD) {
//									this.createPowerUp(entry.getKey(), i, lineNumber);
//									spawned = true;
//									break;
//								}
//							}
//							if (spawned)
//								break;
//						}
//					}
//
//					lineNumber++;
//					line = in.readLine();
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Crea un power up in base al powerUpType passato in input
	 * 
	 * @param powerUpType tipo di power up da creare
	 * @param row         posizione x del power up
	 * @param column      posizione y del power up
	 */
//	private void createPowerUp(int powerUpType, int row, int column) {
//		int x = row * GameConstants.Tiles.TILES_SIZE;
//		int y = column * GameConstants.Tiles.TILES_SIZE;
//
//		PowerUp powerUp = new PowerUp(x, y, powerUpType);
//		ItemController powerUpController = new ItemController();
//		ItemView itemView = new ItemView(powerUp, powerUpController);
//
//		powerUpController.setModel(powerUp);
//		powerUpController.setView(itemView);
//		powerUpController.setPlaying(this);
//		this.itemControllers.add(powerUpController);
//
//	}

	/**
	 * Gestisce l'evento della pressione del tasto del mouse, per gestire l'attacco
	 * da parte del giocatore
	 * 
	 * @param e evento di click del mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			this.playerController.shoot();
	}

	/**
	 * Gestisce l'evento di rilascio del tasto del mouse
	 * 
	 * @param e evento di rilascio del tasto del mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Gestisce l'evento di movimento del mouse
	 * 
	 * @param e evento di movimento del mouse
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	/**
	 * Gestisce l'evento di pressione di alcuni tasti sulla tastiera
	 * 
	 * @param e evento di pressione di alcuni tasti sulla tastiera.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_D:
			this.playerController.updateDir(RIGHT, true);
			break;
		case KeyEvent.VK_A:
			this.playerController.updateDir(LEFT, true);
			break;
		case KeyEvent.VK_SPACE:
			this.playerController.jump();
			break;
		}
	}

	/**
	 * Gestisce l'evento di rilascio di alcuni tasti sulla tastiera
	 * 
	 * @param e evento di rilascio di alcuni tasti sulla tastiera.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			this.playerController.updateDir(LEFT, false);
			break;
		case KeyEvent.VK_D:
			this.playerController.updateDir(RIGHT, false);
			break;
		case KeyEvent.VK_SPACE:
			this.playerController.getPlayer().setJump(false);
			break;
		}
	}

	/**
	 * Renderizza il gioco, mandando ai vari controller la richiesta di
	 * reindirizzare le rispettive view
	 * 
	 * @param g oggetto di tipo Graphics necessario per disegnare sul JFrame
	 */
	@Override
	public void draw(Graphics g) {
		this.levelController.renderView(g);

//		for (EnemyController enemyController : this.enemyControllers) {
//			enemyController.renderView(g);
//		}

		this.playerController.renderView(g);

		for (BubbleController bubbleController : this.bubbleControllers) {
			bubbleController.renderView(g);
		}

//		for (ItemController itemController : this.itemControllers) {
//			itemController.renderView(g);
//		}
	}

	/**
	 * Aggiorna lo stato di gioco, inviando ai vari controller la richiesta di
	 * aggiornare i rispettivi model
	 */
	@Override
	public void update() {
		this.levelController.update();
		this.playerController.update();

//		for (EnemyController enemyController : this.enemyControllers) {
//			enemyController.update();
//		}

		for (BubbleController bubbleController : this.bubbleControllers) {
			bubbleController.update();
		}

//		for (ItemController itemController : this.itemControllers) {
//			itemController.update();
//		}
	}

}
