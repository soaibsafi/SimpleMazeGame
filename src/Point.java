
public class Point {
	private int pointX, pointY;
	private boolean visible;
	/*
	public Point(int x, int y, boolean b) {
		pointX = x;
		pointY = y;
		visible = b;
	}
	
	*/

	public Point(int x, int y) {
		pointX = x;
		pointY = y;
	}

	public int getpX() {
		return pointX;
	}

	public int getpY() {
		return pointY;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setToPoint(Point point_2) {
		pointX = point_2.getpX();
		pointY = point_2.getpY();
		//this.setVisible(point_2.isVisible());
	}

	public boolean checkPonit(int x, int y) {
		if (pointX == x && pointY == y) {
			return true;
		}
		return false;
	}

	public void setToPoint(int x, int y) {
		pointX = x;
		pointY = y;
	}

}
