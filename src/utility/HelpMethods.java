package utility;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.AbstractEntity;
import static utility.GameConstants.UserInterface.DEFAULT_FONT_SIZE;;

/**
 * Classe che racchiude metodi statici di utilità pre le varie componenti del
 * gioco
 */
public class HelpMethods {
	/**
	 * Metodo che verifica se un determinato Tile e' solido, ovvero, non e' vuoto
	 * 
	 * @param x          coordinata x del Tile
	 * @param y          coordinata y del Tile
	 * @param levelTiles matrice che rappresenta la dispozione dei Tiles nel livello
	 *                   corrente
	 * @return true se il Tiles e' solido, false altrimenti
	 */
	private static boolean isSolid(float x, float y, boolean[][] levelTiles) {
		boolean result = false;
		if (y < 0) {
			return result;
		}
		if (x < 0 || x >= GameConstants.Game.GAME_WIDTH) {
			result = true;
		} else {
			float xIndex = x / GameConstants.Tiles.TILES_SIZE;
			float yIndex = y / GameConstants.Tiles.TILES_SIZE;

			boolean check = levelTiles[(int) yIndex][(int) xIndex];

			if (check) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * Metodo che verifica se sia possibile muoversi verso un determinato punto
	 * 
	 * @param x          coordinata x dell'oggetto che si sta muovendo
	 * @param y          coordinata y dell'oggetto che si sta muovendo
	 * @param width      larghezza dell'oggetto che si sta muovendo
	 * @param height     altezza dell'oggetto che si sta muovendo
	 * @param levelTiles matrice che rappresenta la dispozione dei Tiles nel livello
	 *                   corrente
	 * @return true se l'oggetto che si sta muovendo puo' raggiungere la posizione
	 */
	public static boolean canMoveHere(float x, float y, int width, int height, boolean[][] levelTiles) {
		if (!isSolid(x, y, levelTiles))
			if (!isSolid(x + width, y + height - 4, levelTiles))
				if (!isSolid(x + width, y, levelTiles))
					if (!isSolid(x, y + height - 4, levelTiles))
						return true;

		return false;
	}

	/**
	 * Metodo statico per determinare se il giorcatore o un nemico sono su una
	 * superficie solida
	 * 
	 * @param entity     entita' da esaminare
	 * @param levelTiles matrice di booleani che rappresnetano il livello corrente
	 * @return true se l'entita' è su una superficie solida, false altrimenti
	 */
	public static boolean isEntityOnFloor(AbstractEntity entity, boolean[][] levelTiles) {
		boolean result = true;
		if (!isSolid(entity.getX(), entity.getY() + entity.getHeight() + 1, levelTiles)) {
			if (!isSolid(entity.getX() + entity.getWidth(), entity.getY() + entity.getHeight() + 1, levelTiles)) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * Metodo statico per scrivere il testo sul menu e nelle schermate di gioco
	 * 
	 * @param g        oggetto di tipo Graphics
	 * @param text     testo da visualizzare
	 * @param x        coordinata x del testo
	 * @param y        coordinata y del testo
	 * @param centered booleano che indica se il testo deve essere centrato
	 */
	public static void writeText(Graphics g, String text, int x, int y, boolean centered) {
		writeText(g, text, x, y, DEFAULT_FONT_SIZE, centered);
	}

	/**
	 * Metodo statico per scrivere il testo sul menu e nelle schermate di gioco
	 * 
	 * @param g        oggetto di tipo Graphics
	 * @param text     testo da visualizzare
	 * @param x        coordinata x del testo
	 * @param y        coordinata y del testo
	 * @param fontSize dimensione del testo
	 * @param centered booleano che indica se il testo deve essere centrato
	 */
	public static void writeText(Graphics g, String text, int x, int y, int fontSize, boolean centered) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
		Font font = g2.getFont().deriveFont(Font.BOLD, fontSize);
		g2.setFont(font);
		if (centered) {
			FontMetrics fm = g2.getFontMetrics(font);
			int textWidth = fm.stringWidth(text);
			x -= textWidth / 2;
		}
		g2.drawString(text, x, y);
	}

	/**
	 * Metodo statico che ritorna true se il valore e' numerico
	 * 
	 * @param str stringa da controllare
	 * @return true se il valore e' numerico, false altrimenti
	 */
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Metodo statico che ritorna true se due entita' si stanno scontrando, false
	 * altrimenti
	 * 
	 * @param e1 entita' 1
	 * @param e2 entita' 2
	 * @return true se due entita' si stanno scontrando, false altrimenti
	 */
	public static boolean areEntitiesTouching(AbstractEntity e1, AbstractEntity e2) {
		// Ottieni le coordinate e le dimensioni dei rettangoli delle due entità
		float x1 = e1.getX();
		float y1 = e1.getY();
		int width1 = e1.getWidth();
		int height1 = e1.getHeight();

		float x2 = e2.getX();
		float y2 = e2.getY();
		int width2 = e2.getWidth();
		int height2 = e2.getHeight();

		// Verifica se i rettangoli si sovrappongono lungo l'asse x
		boolean overlapX = x1 < x2 + width2 && x1 + width1 > x2;

		// Verifica se i rettangoli si sovrappongono lungo l'asse y
		boolean overlapY = y1 < y2 + height2 && y1 + height1 > y2;

		// Se c'è sovrapposizione sia lungo l'asse x che lungo l'asse y, allora le
		// entità si stanno toccando
		return overlapX && overlapY;
	}

}
