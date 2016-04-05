import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {

	private Board board;

	public Listener(Board board) {
		this.board = board;
	}

	public void keyPressed(KeyEvent e) {
		if (Board.isStart()) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
				if (board.getMap().getMap(board.getPlayer().getPlayerX(), board.getPlayer().getPlayerY() - 1) != 'X') {
					board.getPlayer().move(0, -1);
				}
			}
			if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
				if (board.getMap().getMap(board.getPlayer().getPlayerX(), board.getPlayer().getPlayerY() + 1) != 'X') {
					board.getPlayer().move(0, 1);
				}
			}
			if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
				if (board.getMap().getMap(board.getPlayer().getPlayerX() - 1, board.getPlayer().getPlayerY()) != 'X') {
					board.getPlayer().move(-1, 0);
				}
			}
			if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
				if (board.getMap().getMap(board.getPlayer().getPlayerX() + 1, board.getPlayer().getPlayerY()) != 'X') {
					board.getPlayer().move(1, 0);
				}
			}
			if (keyCode == KeyEvent.VK_SPACE) {

			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
