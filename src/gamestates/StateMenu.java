package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import controller.GameManager;
import controller.MenuController;
//import model.Menu;
import utility.GameConstants;
//import view.MenuView;

/**
 * Classe che rappresenta lo stato di gioco Menu. Estende la classe
 * AbstractGameState e implementa l'interfaccia StateInterface
 */
public class StateMenu extends AbstractGameState implements StateInterface {
	
	/**
	 * Controller del Menu associato allo stato corrente
	 */
	private MenuController menuController;
	
	/**
	 * Costruttore dello stato del Menu
	 * @param game istanza di gioco corrente
	 */
	public StateMenu(GameManager game) {
		super(game);
		this.init();
	}
	
	/**
	 * Inizializza lo stato Menu, creando il rispettivo controller e la
	 * rispettiva view e le associa 
	 */
	private void init() {
		this.menuController = new MenuController();
//		Menu menu = new Menu();
//		MenuView menuView = new MenuView(menu, this.menuController);
//		this.menuController.setModel(menu);
//		this.menuController.setView(menuView);
	}
	
	/**
	 * Gestisce l'aggiornameto dello stato di gioco durante la visualizzazione della
	 * schermata Menu
	 */
	@Override
	public void update() {
	}
	
	/**
	 * Renderizza la schermata di Menu su schermo
	 */
	@Override
	public void draw(Graphics g) {
		this.menuController.renderView(g);
	}
	
	/**
	 * Gestisce l'evento di pressione del tasto del mouse
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}
	/**
	 * Gestisce l'evento di rilascio del tasto del mouse
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	/**
	 * Gestisce l'evento di movimento del mouse
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	/**
	 * Gestisce l'evento di pressione di un tasto della tastiera
	 */
	@Override
	public void keyPressed(KeyEvent e) {
//		switch (e.getKeyCode()) {
//		case KeyEvent.VK_UP, KeyEvent.VK_W -> this.menuController.updateMenuSelect(GameConstants.Directions.UP);
//		case KeyEvent.VK_DOWN, KeyEvent.VK_S -> this.menuController.updateMenuSelect(GameConstants.Directions.DOWN);
//		case KeyEvent.VK_ENTER -> this.menuController.handleButtonEnter();
//		}
	}
	
	/**
	 * Gestisce l'evento di rilascio di un tasto della tastiera
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
