import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	private Map map;
	private Player player=new Player(2, 2);;
	private Timer timer;
	private Window window;
	private GameTime gameTimer;
	private static boolean start = false;
	private static boolean finish = false;
	private static boolean done = false;
	private Point point1=new Point(0, 0);;
	private Point point2=new Point(1, 1);
	private Button startBtn = new Button("START");	
	
	private Font font1=new Font("", Font.BOLD, 36);
	private Font font2=new Font("", Font.ITALIC, 14);
	private Font font3=new Font("", Font.BOLD, 20);
	private String msg1=new String();
	private String msg2=new String();
	private String msg3=new String();
	public static int highScore;
	public static int score;
	public static int passedTime;


	
	public Board(Window window) {
		this.window = window;
		initBoard();
	}

	public void actionPerformed(ActionEvent e) {

		if(score>highScore){
			highScore=score;
		}
		// System.out.println(2);
		if (Board.isStart()) {
			passedTime =gameTimer.getTime() - gameTimer.getStartTime();
			if(passedTime<10){
				msg3="Time: 0"+passedTime+"    High Score: "+highScore+"    Score: "+score;
			}
			else msg3="Time: "+passedTime+"    High Score: "+highScore+"    Score: "+score;
			
			gameTimer.setEndTime(gameTimer.getTime());
			if (gameTimer.getEndTime() - gameTimer.getMidTime() >= 3) {
				createPoint();
				gameTimer.setMidTime(gameTimer.getEndTime());
			}
			if (gameTimer.getEndTime() - gameTimer.getFirstTime() >= 5) {
				if(point2.isVisible()){
					removePointBySetting();
				}
				else point1.setVisible(false);
				
				gameTimer.setFirstTime(gameTimer.getMidTime());
					// System.out.println("d");

			}
			if (gameTimer.getEndTime() - gameTimer.getStartTime() > 60) {
				msg1="Time's Up!!!";
				msg2="Your Score : "+score;
				// System.out.println("Finish");
				Board.setStart(false);
				Board.setFinish(true);
				if(Map.getScore()<highScore){
					getMap().updateFlie(highScore);
				}

			} 
		}
		checkCollision();
		// check collision between player and points
		
		repaint();
	}


	public void paint(Graphics g) {
		super.paint(g);
		if (Board.isStart()) {
			for (int x = 0; x < 20; x++) {
				for (int y = 0; y < 23; y++) {
					g.setColor(Color.BLACK);
					if (map.getMap(x, y) == 'X') {
						g.fillRect(x * 20, y * 20, 20, 20);
						g.setColor(Color.CYAN);		////************
						g.drawRect(x * 20, y * 20, 20, 20);		////************
					}
					if (map.getMap(x, y) == 'A') {
						g.setColor(Color.BLACK);
						g.fillRect(x * 20, y * 20, 20, 20);
					}
				}
			}
			
			g.setColor(Color.BLUE);
			g.fillRect(player.getPlayerX() * 20, player.getPlayerY() * 20, 20, 20);
			g.setColor(Color.GREEN);

			if (point1.isVisible()) {
				g.fillRect(point1.getpX() * 20, point1.getpY() * 20, 20, 20);	// draw point1
			}
			if (point2.isVisible()) {
				g.fillRect(point2.getpX() * 20, point2.getpY() * 20, 20, 20);	// draw point2
			}
			
			g.setColor(Color.GREEN);
			g.setFont(font2);
			g.drawString("time limit 60 sec", 150, 12);  ////************
			g.setFont(font3);
			g.drawString(msg3, 10, 30);
		}
		if (Board.isFinish()) {		// print finish massage & score
			startBtn.setVisible(true);
			g.setFont(font1);
			g.setColor(Color.BLUE);
			g.drawString(msg1, 110, 120);
			g.drawString(msg2, 90, 170);
			
		}
		

	}

	private void initBoard() {
		gameTimer = new GameTime();
		map = new Map();
		timer = new Timer(5, this);
		addKeyListener(new Listener(this));
		setFocusable(true);
		setBackground(Color.RED);
		timer.start();

		startBtn.addActionListener(new ButtonSencor(this));
		add(startBtn);		
		highScore=Map.getScore();
		System.out.println(Map.getScore());

	}

	public void setPoint_1() {
		while (!done) {
			int x = (int) (1 + Math.random() * 19.0);
			int y = (int) (3 + Math.random() * 19.0);
			if (getMap().getMap(x, y) != 'X' && !player.checkPlayerPosition(x, y)) {
				point1.setToPoint(x, y);
				point1.setVisible(true);
				done = true;
			}
		}
		point1.setVisible(true);
		done = false;
	}

	public void setPlayer() {
		while (!done) {
			int x = (int) (1 + Math.random() * 19.0);
			int y = (int) (3 + Math.random() * 19.0);
			if (getMap().getMap(x, y) != 'X') {
				player.setPlayerTo(x, y);
				done = true;
			}
		}
		done = false;
	}
	private void createPoint() {
		while (!done) {
			int x = (int) (1 + Math.random() * 19.0); // get random x &
														// y
			int y = (int) (3 + Math.random() * 19.0);
			// check (wall, player & point_1)
			if (getMap().getMap(x, y) != 'X' && !player.checkPlayerPosition(x, y) && !point1.checkPonit(x, y)) {
				point2.setToPoint(x, y); // make point_2 = new
				point2.setVisible(true);	// point(x,y)
				done = true;
				//System.out.println("p2 create");
			}
		}
		done = false;
	}
	private void removePointBySetting() {
		point1.setToPoint(point2);
		point1.setVisible(true);// set point_1=point_2
		point2.setVisible(false); // set point2 false
		//System.out.println("placed p1<-p2\ndistroy");
	}

	private void checkCollision() {
		if (point1.isVisible()) {
			if (player.checkPlayerPosition(point1.getpX(), point1.getpY())) {
				point1.setVisible(false);
				score += 5;
				//System.out.println(score+"p1 eated");
			}
		}
		if (point2.isVisible()) {
			if (player.checkPlayerPosition(point2.getpX(), point2.getpY())) {
				point2.setVisible(false);
				score += 5;
				//System.out.println(score+"p2 eated");
			}
		}
		
	}

	public Window getWindow() {
		return window;
	}

	public Map getMap() {
		return map;
	}

	public Player getPlayer() {
		return player;
	}

	public GameTime getGameTimer() {
		return gameTimer;
	}

	public static boolean isStart() {
		return start;
	}

	public Button getStartButton() {
		return startBtn;
	}

	public static boolean isFinish() {
		return finish;
	}

	public static void setStart(boolean start) {
		Board.start = start;
	}

	public static void setFinish(boolean finish) {
		Board.finish = finish;
	}

}
