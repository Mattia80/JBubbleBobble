package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import controller.LevelController;
import model.Game;
import model.Level;
import utility.GameConstants;
import utility.HelpMethods;
import utility.LoadSave;

/**
 * Classe che rappresenta la view del livello. Estende la classe AbstractView
 */
public class LevelView extends AbstractView {

	/**
	 * Matrice di valori booleani che rappresenta la struttura del livello,
	 * costruito come insieme di Tiles
	 */
	private boolean[][] levelTiles;
	/**
	 * Immagine del giocatore
	 */
	private BufferedImage player;
	/**
	 * Immagine del livello
	 */
	private BufferedImage levelImg;

	/**
	 * Costruttore della level view
	 * 
	 * @param level           modello del livello associato alla view
	 * @param levelController controller del livello associato alla view
	 */
	public LevelView(Level level, LevelController levelController) {
		super(level, levelController);
		this.levelTiles = new boolean[GameConstants.Game.GAME_HEIGHT * 2][GameConstants.Game.GAME_WIDTH];
		this.loadImg();
	}

	/**
	 * Metodo privato che carica le sprites del livello e lo sprite del giocatore
	 */
	private void loadImg() {
		this.levelImg = LoadSave.loadSprite(LoadSave.LEVEL_TILES);
		this.player = LoadSave.loadSprite(LoadSave.PLAYER);
	}

	/**
	 * Metodo che restituisce il modello del livello associato alla view
	 * 
	 * @return il modello del livello associato alla view
	 */
	public Level getLevel() {
		return (Level) this.getModel();
	}

	/**
	 * Restituisce una matrice di booleani che ricostruisce la disposizione delle
	 * Tiles del livello
	 * 
	 * @return matrice di booleani che rappresenta le Tiles del livello
	 */
	public boolean[][] getLevelTiles() {
		return this.levelTiles;
	}

	/**
	 * Metodo che renderizza il livello su schermo
	 * 
	 * @param g oggetto di tipo Graphis per disegnare sul JFrame
	 */
	@Override
	public void render(Graphics g) {

		// Mostra il punteggio del gioco
		HelpMethods.writeText(g, String.valueOf(Game.getInstance().getPoints()), GameConstants.Game.GAME_WIDTH / 2, 50,
				false);

		String path = "/levels/level_" + Game.getInstance().getLevel() + ".txt";

		// Viene recuperato il numero del livello e ricostruito il percoso del file di
		// testo che costruisce il livello corrente.
		// Il file viene aperto e viene disegnato: il tile del livello in corrispondenza
		// del carattere 'X', il giocatore in corrispondenza del carattere 'P', le vite
		// del giocatore in corrispondenza del carattere 'R', il livello corrente in
		// corrispondenza del carattere 'L'
		try (InputStream is = LevelView.class.getResourceAsStream(path)) {
			if (is == null) {
				throw new FileNotFoundException(path);
			}
			try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
				String line = in.readLine();
				int lineNumber = 0;
				while (line != null) {
					for (int i = 0; i < line.length(); i++) {
						char c = line.charAt(i);
						if (c == 'X' || c == 'L' || c == 'R' || c == 'P') {
							int x = i * GameConstants.Tiles.TILES_SIZE;
							int y = lineNumber * GameConstants.Tiles.TILES_SIZE;
							g.drawImage(this.levelImg.getSubimage(29, 16 * (Game.getInstance().getLevel() - 1), 16, 16),
									x, y, GameConstants.Tiles.TILES_SIZE, GameConstants.Tiles.TILES_SIZE, null);
							if (c == 'L') {
								HelpMethods.writeText(g, String.valueOf(Game.getInstance().getLevel()), x, y, false);
							}
							if (c == 'R') {
								HelpMethods.writeText(g, String.valueOf(Game.getInstance().getLives()), x, y, false);
							}
							if (c == 'P') {
								g.drawImage(this.player.getSubimage(18, 18, 18, 18), x, y,
										GameConstants.Tiles.TILES_SIZE, GameConstants.Tiles.TILES_SIZE, null);
							}
							this.levelTiles[lineNumber][i] = true;
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

}
