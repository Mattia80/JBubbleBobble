package view;

import java.awt.Graphics;

import controller.AbstractController;
import model.AbstractModel;

/**
 * Interfaccia per le classi View. Definisce i metodi comuni alle varie classi
 * che si occuperanno della gestione delle varie view del gioco
 */
public interface ViewInterface {

	/**
	 * Metodo che permette di ottenere il modello associato alla vista
	 * 
	 * @return il modello associato alla vista
	 */
	AbstractModel getModel();

	/**
	 * Imposta il modello da associare alla vista
	 * 
	 * @param model il modello da associare alla vista
	 */
	void setModel(AbstractModel model);

	/**
	 * Metodo che permette di ottenere il controller associato alla vista
	 * 
	 * @return il controller associato alla vista
	 */
	AbstractController getController();

	/**
	 * Imposta il controller da associare alla vista
	 * 
	 * @param controller il controller da associare alla vista
	 */
	void setController(AbstractController controller);

	/**
	 * Metodo che effettua il rendering visuale della vista
	 * 
	 * @param g oggetto Graphics per poter disegnare nel JFrame
	 */
	void render(Graphics g);

}
