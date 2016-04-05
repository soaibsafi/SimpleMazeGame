import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.Timer;

public class ButtonSencor implements ActionListener {

	private Board board;
	// private Timer bTimer;

	public ButtonSencor(Board board) {
		this.board = board;
		// bTimer=new Timer(20,this);
		// bTimer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if ((Button) e.getSource() == board.getStartButton()) {
			// Board.startFlag=0;
			board.getGameTimer().startTimer();
			board.getStartButton().setVisible(false);
			board.setPlayer();
			board.setPoint_1();
			Board.setStart(true);
			Board.setFinish(false);
			Board.score = 0;
			Board.passedTime = 0;
		}

	}

}
