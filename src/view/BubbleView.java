package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.BubbleController;
import model.Bubble;
import model.FireBubble;
import utility.LoadSave;

/**
 * Classe che rappresenta la view della Bolla. Estende la classe AbstractView
 */
public class BubbleView extends AbstractView {
	/**
	 * Immagine della bolla
	 */
	private BufferedImage bubbleImg;

	/**
	 * Costruttore della bolla
	 * 
	 * @param bubble           modello della bolla associata alla view
	 * @param bubbleController controller della bolla associata alla view
	 */
	public BubbleView(Bubble bubble, BubbleController bubbleController) {
		super(bubble, bubbleController);
		this.loadImage();
	}

	/**
	 * Restituisce il modello della bolla associata alla view
	 * 
	 * @return il modello della bolla associata alla view
	 */
	private Bubble getBubble() {
		return (Bubble) this.model;
	}

	/**
	 * Restituisce il controller della bolla associata alla view
	 * 
	 * @return il controller della bolla associata alla view
	 */
	private BubbleController getBubbleController() {
		return (BubbleController) this.controller;
	}
	/**
	 * Metodo privato che carica gli sprites della bolla
	 */
	private void loadImage() {
		this.bubbleImg = LoadSave.loadSprite(LoadSave.BUBBLE);
	}
	
	/**
	 * Disegna la bolla sul JFrame
	 * 
	 * @param g oggetto di tipo Graphics utilizzato per disegnare sul JFrame
	 */
	@Override
	public void render(Graphics g) {

		Bubble bubble = this.getBubble();
		int multi = 2;
		int bubbleType = 0;

		if (bubble.isPopped())
			multi = 6;
		else if (bubble.isFlying())
			multi = 3;

		if (bubble instanceof FireBubble) {
			bubbleType = 2;
			multi = 5;
			if (bubble.isPopped())
				multi = 5;
		}

		g.drawImage(this.bubbleImg.getSubimage(16 * multi, 16 * bubbleType, 16, 16), (int) bubble.getX(),
				(int) bubble.getY(), bubble.getWidth(), bubble.getHeight(), null);

		if (bubble.isPopped())
			this.getBubbleController().removeBubble();

	}

}
