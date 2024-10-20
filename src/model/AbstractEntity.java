package model;

/**
 * Rappresenta una entita' generica presente nel game
 */
public abstract class AbstractEntity extends AbstractModel {

	/**
	 * Identifica la posizione x dell'entita'
	 */
	protected float x;
	/**
	 * Identifica la posizione y dell'entita'
	 */
	protected float y;
	/**
	 * Rappresenta la larghezza dell'entita'
	 */
	protected int width;
	/**
	 * Rappresenta l'altezza dell'entita'
	 */
	protected int height;
	/**
	 * Indica se l'entità e' in movimento
	 */
	protected boolean moving;
	/**
	 * Indica se l'entita' sta saltando
	 */
	protected boolean jumping;
	/**
	 * Specifica se l'entita' e' in aria
	 */
	protected boolean inAir;
	/**
	 * Rappresenta la velocita' dell'entita' quando questa e' in aria
	 */
	protected float airSpeed;
	/**
	 * Rappresenta la velocita' dell'entita'
	 */
	protected float speed;

	/**
	 * Costruttore dell'entita'
	 * 
	 * @param x      posizione x dell'entita'
	 * @param y      posizione y dell'entita'
	 * @param width  larghezza dell'entita'
	 * @param height altezza dell'entita'
	 */
	public AbstractEntity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * Restituisce la posizione x dell'entita'
	 * 
	 * @return la posizione x dell'entita'
	 */
	public float getX() {
		return x;
	}

	/**
	 * Imposta la posizione x dell'entita'
	 * 
	 * @param x la nuova posizione x dell'entita'
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Restituisce la posizione y dell'entita'
	 * 
	 * @return la posizione y dell'entita'
	 */
	public float getY() {
		return y;
	}

	/**
	 * Imposta la posizione y dell'entita'
	 * 
	 * @param y la nuova posizione y dell'entita'
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Restituisce la larghezza dell'entita'
	 * 
	 * @return la larghezza dell'entita'
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Imposta la nuova larghezza dell'entita'
	 * 
	 * @param width la nuova larghezza dell'entita'
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Restituisce l'altezza dell'entita'
	 * 
	 * @return altezza dell'entita'
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Imposta la nuova altezza dell'entita'
	 * 
	 * @param height la nuova altezza dell'entita'
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Restituisce true se l'entita' e' in movimento, false altrimenti
	 * 
	 * @return true se l'entita' e' in movimento, false altrimenti
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * Imposta moving a true se l'entita' e' in movimento, false altrimenti
	 * 
	 * @param moving true se l'entita' e' in movimento, false altrimenti
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	/**
	 * Restituisce true se l'antita' sta saltando, false altrimenti
	 * 
	 * @return true se l'antita' sta saltando, false altrimenti
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * Imposta jumping a true se l'antita' sta saltando, false altrimenti
	 * 
	 * @param jumping true se l'antita' sta saltando, false altrimenti
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	/**
	 * Restituisce true se l'entita' sta saltando, false altrimenti
	 * 
	 * @return true se l'entita' sta saltando, false altrimenti
	 */
	public boolean isInAir() {
		return inAir;
	}

	/**
	 * Imposta inAir a true se l'entita' sta saltando, false altrimenti
	 * 
	 * @param inAir true se l'entita' sta saltando, false altrimenti
	 */
	public void setInAir(boolean inAir) {
		this.inAir = inAir;
	}

	/**
	 * Restituisce la velocita' dell'aria dell'entita'
	 * 
	 * @return velocita' dell'aria dell'entita'
	 */
	public float getAirSpeed() {
		return airSpeed;
	}

	/**
	 * Imposta la velocita' dell'aria dell'entita'
	 * 
	 * @param speed la nuova velocita' dell'aria dell'entita'
	 */
	public void setAirSpeed(float airSpeed) {
		this.airSpeed = airSpeed;
	}

	/**
	 * Restituisce la velocita' dell'entita'
	 * 
	 * @return la velocita' dell'entita'
	 */
	public float getSpeed() {
		return speed;
	}

	/**
	 * Imposta la velocita' dell'entita'
	 * 
	 * @param speed la nuova velocita' dell'entita'
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
