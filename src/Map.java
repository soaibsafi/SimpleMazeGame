import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Map {

	private String[] map = new String[20];
	private static int score;

	public Map() {
		setMapFile();
		setScoreFile();
	}

	private void setScoreFile() {
		FileReader fileReader;
		try {
			fileReader = new FileReader("res/score.txt");
			BufferedReader bufferedReader =new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				score = Integer.parseInt(line);
				System.out.println(score);
			}
			fileReader.close();
			bufferedReader.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void setMapFile() {
		try {
			//File file = new File("map/maze.txt");
			FileReader fileReader = new FileReader("res/maze.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int i=0;
			while ((line = bufferedReader.readLine()) != null) {
				map[i++] = line;
			}
			fileReader.close();
			bufferedReader.close();

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int getScore(){
		return score;
	}
	public void updateFlie(int hs){
		
		try {
			FileWriter fw = new FileWriter("res/score.txt");
			 BufferedWriter out = new BufferedWriter(fw);
			 String ln=hs+"";
			 	out.write(ln);
		       out.flush();
		       fw.close();
		       out.close();
		       
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public char getMap(int x, int y) {
		return map[x].charAt(y);
	}

}
