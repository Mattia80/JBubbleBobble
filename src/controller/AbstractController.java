package controller;

import java.awt.Graphics;

import gamestates.StateGamePlay;
import model.AbstractModel;
import view.AbstractView;

/**
 * Classe che rappresenta un controller generico
 */
public abstract class AbstractController implements ControllerInterface {
	/**
	 * Rappresenta il modello associato al controller
	 */
	protected AbstractModel model;
	/**
	 * Rappresenta la vista associata al controller
	 */
	protected AbstractView view;
	/**
	 * Rappresenta lo stato di gioco associato al controller
	 */
	protected StateGamePlay playing;

	/**
	 * Costruttore del controller astratto senza che venga speciificato ne il model
	 * ne la view
	 */
	public AbstractController() {
		this(null, null);
	}

	/**
	 * Cotruttore del controller astratto utilizzando il model fornito in input
	 * 
	 * @param model modello associato al controller
	 */
	public AbstractController(AbstractModel model) {
		this.model = model;
	}

	/**
	 * Cotruttore del controller astratto utilizzando la view fornita in input
	 * 
	 * @param view vista associata al controller
	 */
	public AbstractController(AbstractView view) {
		this.view = view;
	}

	/**
	 * Cotruttore del controller astratto utilizzando la view fornita in input
	 * 
	 * @param model modello associato al controller
	 * @param view  vista associata al controller
	 */
	public AbstractController(AbstractModel model, AbstractView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Restituisce il modello associato al controller
	 * 
	 * @return il modello associato al controller
	 */
	public AbstractModel getModel() {
		return model;
	}

	/**
	 * Imposta il modello da associare al controller
	 * 
	 * @param il modello da associare al controller
	 */
	public void setModel(AbstractModel model) {
		this.model = model;
	}

	/**
	 * Restituisce la vista associata al controller
	 * 
	 * @return la vista associata al controller
	 */
	public AbstractView getView() {
		return view;
	}

	/**
	 * Imposta la vista da associare al controller
	 * 
	 * @param view la vista da associare al controller
	 */
	public void setView(AbstractView view) {
		this.view = view;
	}

	/**
	 * Restituisce lo stato di gioco associato al controller
	 * 
	 * @return lo stato di gioco associato al controller
	 */
	public StateGamePlay getPlaying() {
		return playing;
	}

	/**
	 * Imposta lo stato di gioco da associare al controller
	 * 
	 * @param playing lo stato di gioco da associare al controller
	 */
	public void setPlaying(StateGamePlay playing) {
		this.playing = playing;
	}

	/**
	 * Metodo che effettua il render della vista associata nel contesto specifico
	 * 
	 * @param g oggetto di tipo Graphis per disegnare sul JFrame
	 */
	@Override
	public void renderView(Graphics g) {
		if (this.view != null)
			this.view.render(g);
		
	}

}
