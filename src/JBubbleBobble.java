import controller.GameManager;

/**
 * Classe che contiene il metodo Main per l'avvio del gioco. Nel metodo main
 * viene chiamato il metodo getInstance() per ottenere l'istanza del gioco, e
 * successivamente viene chiamato il metodo startGame() per avviare la partita
 */
public class JBubbleBobble {

	public static void main(String[] args) {
		// Ottiene l'istanza del gioco
		GameManager game = GameManager.getInstance();
		// Avvia una nuova partita
		game.startGame();
	}

}
