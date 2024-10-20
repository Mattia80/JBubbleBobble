package controller;

//import model.Menu;
import utility.GameConstants;
//import view.MenuView;

/**
 * Classe che rappresenta il controller del menu. Estende la classe
 * AbstractController e implementa l'interfaccia ControllerInterface
 */
public class MenuController extends AbstractController implements ControllerInterface {
	/**
	 * Restituisce il modello del menu associato al controller
	 * 
	 * @return il modello del menu associato al controller
	 */
//	private Menu getMenu() {
//		return (Menu) this.model;
//	}

	/**
	 * Restituisce la view del menu associata al controller
	 * 
	 * @return la view del menu associata al controller
	 */
//	private MenuView getMenuView() {
//		return (MenuView) this.view;
//	}

	/**
	 * Metodo che gestisce il cambio dello stato di gioco in base alla voce di menu
	 * selezionata
	 */
//	public void handleButtonEnter() {
//		Menu menu = this.getMenu();
//		MenuView menuView = this.getMenuView();
//		menuView.getButtons().get(menu.getSelectedItem()).updateGameState();
//	}

	/**
	 * Gestisce e aggiorna la selezione delle varie voci del menu, selezionabili con
	 * i testi su e giu'
	 * 
	 * @param direction direzione su e giu' per la selezione delle voci del menu
	 */
//	public void updateMenuSelect(int direction) {
//		Menu menu = this.getMenu();
//		MenuView menuView = this.getMenuView();
//
//		switch (direction) {
//		case GameConstants.Directions.UP -> menu.setSelectedItem(
//				menu.getSelectedItem() > 0 ? menu.getSelectedItem() - 1 : menuView.getButtons().size() - 1);
//		case GameConstants.Directions.DOWN -> menu.setSelectedItem(
//				menu.getSelectedItem() >= menuView.getButtons().size() - 1 ? 0 : menu.getSelectedItem() + 1);
//		}
//	}

	/**
	 * Metodo che aggiorna lo stato del modello, notificando gli observer associati
	 */
	@Override
	public void update() {
		this.getModel().notifyUpdate();
	}

}
