import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Window extends Frame {

	private Board board;

	public Window() {
		board = new Board(this);
		init();
	}

	private void init() {
		setTitle("Boson");
		setSize(400 + 7, 460 + 30); ////************
		setLocationRelativeTo(null);
		setVisible(true);
		
		setResizable(false);
		
		
		add(board);
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/icon.png"));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public Board getBoard() {
		return board;
	}

}
