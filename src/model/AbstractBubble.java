package model;

/**
 * Classe che rappresenta un tipo generico di bolla
 */
public abstract class AbstractBubble extends AbstractEntity {

	/**
	 * Indica se la bolla e' stata sparata verso sinistra
	 */
	protected boolean left;
	/**
	 * Indica se la bolla e' stata sparata verso destra
	 */
	protected boolean right;
	/**
	 * Indica se la bolla e' scoppiata
	 */
	protected boolean popped;
	/**
	 * Indica se la bolla e' ancora valida e puo' essere usata per intrappolare i
	 * nemici
	 */
	protected boolean expired;

	/**
	 * Costruttore della bolla generica
	 * 
	 * @param x      posizione x della bolla
	 * @param y      posizione y della bolla
	 * @param width  larghezza della bolla
	 * @param height altezza della bolla
	 */
	public AbstractBubble(float x, float y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * Restituisce true se la bolla e' stata sparata verso sinistra, false
	 * altrimenti
	 * 
	 * @return true se la bolla e' stata sparata verso sinistra, false altrimenti
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Imposta la direzione della bolla verso sinistra
	 * 
	 * @param left true se la bolla e' stata sparata verso sinistra, false
	 *             altrimenti
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * Restituisce true se la bolla e' stata sparata verso destra, false altrimenti
	 * 
	 * @return true se la bolla e' stata sparata verso destra, false altrimenti
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * Imposta la direzione della bolla verso destra
	 * 
	 * @param right true se la bolla e' stata sparata verso destra, false altrimenti
	 */
	public void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * Restituisce true se la bolla e' scoppiata, false altrimenti
	 * 
	 * @return true se la bolla e' scoppiata, false altrimenti
	 */
	public boolean isPopped() {
		return popped;
	}

	/**
	 * Imposta lo stato "scoppiata" della bolla
	 * 
	 * @param popped true se la bolla e' scoppiata, false altrimenti
	 */
	public void setPopped(boolean popped) {
		this.popped = popped;
	}

	/**
	 * Restituisce true se la e' ancora valida e puo' essere usata per intrappolare
	 * i nemici, false altrimenti
	 *
	 * @return true se la e' ancora valida e puo' essere usata per intrappolare i
	 *         nemici
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * Imposta lo stato "scaduta" della bolla
	 * 
	 * @param expired true se la e' ancora valida e puo' essere usata per
	 *                intrappolare i nemici
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/**
	 * Restituisce true se la bolla puo' effettivamente infliggere danni, false
	 * altrimenti
	 * 
	 * @return
	 */
	public boolean canDamage() {
		return !this.expired && !this.popped;
	}

}
