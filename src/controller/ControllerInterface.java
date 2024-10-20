package controller;

import java.awt.Graphics;

import model.AbstractModel;
import view.AbstractView;

/**
 * Interfaccia per le classi del Controller. Definisce i metodi comuni per le
 * varie classi che si occuperanno delle funzioni di controller
 */
public interface ControllerInterface {
	/**
	 * Metodo che permette di ottenere il modello associato al controller
	 * 
	 * @return il modello associato al controller
	 */
	AbstractModel getModel();

	/**
	 * Imposta il modello da associare al controller
	 * 
	 * @param model il modello da associare al controller
	 */
	void setModel(AbstractModel model);

	/**
	 * Metodo che permette di ottenere la view assocaita al controller
	 * 
	 * @return la view assocaita al controller
	 */
	AbstractView getView();

	/**
	 * Imposta la view da associare al controller
	 * 
	 * @param view la view da associare al controller
	 */
	void setView(AbstractView view);

	/**
	 * Metodo che permette l'aggiornamento del modello
	 */
	void update();

	/**
	 * Metodo che renderizza la view associata al controller
	 * 
	 * @param g oggetto Graphics per poter disegnare nel JFrame
	 */
	void renderView(Graphics g);

}
