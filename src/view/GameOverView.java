package view;

import java.awt.Font;
import java.awt.Graphics;

import controller.GameOverController;
import model.Game;
import utility.GameConstants;
import utility.HelpMethods;

public class GameOverView extends AbstractView {

	private boolean inRendered;

	public GameOverView(GameOverController gameOverController) {
		super(gameOverController);
	}

	@Override
	public void render(Graphics g) {
		String text = "GAME OVER :(";
		if (Game.getInstance().getLives() > 0) {
			text = "CONGRATULATIONS, YOU WON!!!";
		}

//		HelpMethods.writeText(g, text, GameConstants.Game.GAME_WIDTH / 2, (int) (125 * GameConstants.Tiles.SCALE), 24,
//				true);
//		HelpMethods.writeText(g, "Your score is: " + Game.getInstance().getPoints(), GameConstants.Game.GAME_WIDTH / 2,
//				(int) (175 * GameConstants.Tiles.SCALE), 24, true);
//		HelpMethods.writeText(g, "Insert your username then press ENTER to continue.",
//				GameConstants.Game.GAME_WIDTH / 2, (int) (225 * GameConstants.Tiles.SCALE), 24, true);
//
//		if (!this.inRendered) {
//			GameOverController gameOverController = (GameOverController) this.getController();
//			GamePanel gamePanel = gameOverController.getGameOver().getGame().getGamePanel();
//			TextInput textInput = new TextInput();
//			textInput.setFont(g.getFont().deriveFont(Font.BOLD, 24));
//			int textFieldWidth = 27 * 3;
//			int textFieldHeight = 40;
//			textInput.setBounds(GameConstants.Game.GAME_WIDTH / 2 - textFieldWidth / 2,
//					(int) (275 * GameConstants.Tiles.SCALE), textFieldWidth, textFieldHeight);
//			gamePanel.setLayout(null);
//			gamePanel.add(textInput);
//			this.inRendered = true;
//		}
	}

}
