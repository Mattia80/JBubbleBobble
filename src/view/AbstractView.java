package view;

import controller.AbstractController;
import model.AbstractModel;

/**
 * Classe che rappresenta una View generica, ovvero la base per le altre view
 * necessarie al gioco
 */
public abstract class AbstractView implements ViewInterface {
	/**
	 * Model associato alla View
	 */
	protected AbstractModel model;
	/**
	 * Controller associato alla view
	 */
	protected AbstractController controller;

	/**
	 * Costruttore di Abstractview che costruisce una view senza model e senza
	 * controller
	 */
	public AbstractView() {

	}

	/**
	 * Costruttore di Abstractview che costruisce una view con il controller passato
	 * in input
	 * 
	 * @param controller il controller associato
	 */
	public AbstractView(AbstractController controller) {
		this.controller = controller;
	}

	/**
	 * Costruttore di Abstractview che costruisce una view con il model passato in
	 * input
	 * 
	 * @param model il model associato
	 */
	public AbstractView(AbstractModel model) {
		this.model = model;
	}

	/**
	 * Costruttore della classe AbstractView
	 * 
	 * @param model      il model associato alla view
	 * @param controller il controller associato alla view
	 */
	public AbstractView(AbstractModel model, AbstractController controller) {
		this.model = model;
		this.controller = controller;
	}

	/**
	 * Restituice il modello associato alla view
	 * 
	 * @return model il modello associato alla view
	 */
	@Override
	public AbstractModel getModel() {
		return model;
	}

	/**
	 * Imposta il modello da associare alla view
	 * 
	 * @param model il nuovo modello da associare alla view
	 */
	@Override
	public void setModel(AbstractModel model) {
		this.model = model;
	}

	/**
	 * Restituisce il controller associato alla view
	 * 
	 * @return controller il controller associato alla vieww
	 */
	@Override
	public AbstractController getController() {
		return controller;
	}

	/**
	 * Imposta il controller da associare alla view
	 * 
	 * @param controller il controller da associare alla view
	 */
	@Override
	public void setController(AbstractController controller) {
		this.controller = controller;
	}

}
