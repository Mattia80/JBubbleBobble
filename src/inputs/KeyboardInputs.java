package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.GameManager;
import gamestates.GameState;

public class KeyboardInputs implements KeyListener {

	private final GameManager game;

	public KeyboardInputs(GameManager game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (GameState.state) {
		case MENU -> this.game.getMenuState().keyPressed(e);
		case GAMEOVER -> this.game.getGameOverState().keyPressed(e);
		case GAMEPLAY, CONTINUE -> this.game.getGamePlayState().keyPressed(e);
		case RECORDS -> this.game.getRecordsState().keyPressed(e);
		}
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void keyReleased(KeyEvent e) {
		switch (GameState.state) {
		case MENU -> this.game.getMenuState().keyReleased(e);
		case GAMEPLAY, CONTINUE -> this.game.getGamePlayState().keyReleased(e);
		}

	}

}
