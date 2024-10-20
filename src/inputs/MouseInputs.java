package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controller.GameManager;
import gamestates.GameState;

public class MouseInputs implements MouseListener, MouseMotionListener {

	private final GameManager game;

	public MouseInputs(GameManager game) {
		this.game = game;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void mousePressed(MouseEvent e) {
		switch (GameState.state) {
		case MENU -> this.game.getMenuState().mousePressed(e);
		case GAMEPLAY -> this.game.getGamePlayState().mousePressed(e);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
