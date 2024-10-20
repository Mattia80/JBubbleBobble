package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Interfaccia che racchiude i metodi comuni ai vari stati del gioco
 */
public interface StateInterface {

	/**
	 * Metodo che permette ai controller coinvolti nello stato di aggiornare i
	 * rispettivi modelli
	 */
	void update();

	/**
	 * Metodo che permette ai controller di renderizzare le view che fanno parte di
	 * questo stato
	 * 
	 * @param g oggetto di tipo Graphics per disegnare sul Jpanel
	 */
	void draw(Graphics g);

	/**
	 * Gestisce l'evento quando viene premuto un tasto del mouse
	 * 
	 * @param e evento del mouse
	 */
	void mousePressed(MouseEvent e);

	/**
	 * Gestisce l'evento quando viene rilasciato un tasto del mouse
	 * 
	 * @param e evento del mouse
	 */
	void mouseReleased(MouseEvent e);

	/**
	 * Gestisce l'evento quando il mouse viene mosso
	 * 
	 * @param e evento del mouse
	 */
	void mouseMoved(MouseEvent e);

	/**
	 * Gestisce l'evento quando un tasto della tastiera viene premuto
	 * 
	 * @param e evento della tastiera
	 */
	void keyPressed(KeyEvent e);

	/**
	 * Gestisce l'evento quando un tasto della tastiera viene rilasciato
	 * 
	 * @param e evento della tastiera
	 */
	void keyReleased(KeyEvent e);

}
