import java.util.Timer;
import java.util.TimerTask;

public class GameTime {
	private int startTime, endTime, firstTime, midTime;
	private int time = 0;
	private Timer timer;

	GameTime() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				time++;
				//System.out.println(time+"\t"+getEndTime()+"\t"+getFirstTime()+"\t"+getMidTime());
			}
		}, 0, 1000);

	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getFirstTime() {
		return firstTime;
	}

	public int getMidTime() {
		return midTime;
	}

	public int getTime() {
		return time;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public void setFirstTime(int firstTime) {
		this.firstTime = firstTime;
	}

	public void setMidTime(int midTime) {
		this.midTime = midTime;
	}

	public void startTimer() {
		startTime = time;
		endTime = time;
		firstTime = time;
		midTime = time;
	}

}
