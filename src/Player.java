
public class Player {
	private int playerX, playerY;

	public Player(int x, int y) {
		playerX = x;
		playerY = y;
	}

	public void move(int x, int y) {
		playerX += x;
		playerY += y;
	}

	public int getPlayerX() {
		return playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public boolean checkPlayerPosition(int x, int y) {
		if (getPlayerX() == x && getPlayerY() == y) {
			return true;
		}
		return false;
	}

	public void setPlayerTo(int x, int y) {
		playerX = x;
		playerY = y;
	}

}
