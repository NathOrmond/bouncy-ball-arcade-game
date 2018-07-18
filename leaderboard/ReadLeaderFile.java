package leaderboard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import resources.Resources;

public class ReadLeaderFile {
	
	Map<Integer, String> names;
	List<Integer> scores;
	int lineCount;
	
	public ReadLeaderFile() throws IOException{ 
		scores = new ArrayList<Integer>();
		names = new HashMap<Integer, String>();
		readFile();
	}
	
	/**
	 * Reads entire leaderboard file and produces a map and list of the data
	 * @throws IOException
	 */
	public void readFile() throws IOException { 
		BufferedReader br = new BufferedReader(new FileReader(Resources.leaderTable));

	    String line = br.readLine();
	    while (line != null && !line.isEmpty()) {
	        String[] datas = line.split(",");
	        System.out.println(datas[0] + " - " + datas[1]);       
	        names.put(Integer.parseInt(datas[1]), datas[0]); 
	        scores.add(Integer.parseInt(datas[1]));  
	        line = br.readLine();
	    }
	    
	    br.close();
	}
	
	
	/**
	 * returns a List<String> of the top three highest scores within the game
	 * @return
	 */
	public List<String> topThreeResults() { 
		List<String> highscores = new ArrayList<String>();
		Collections.sort(scores);
		Collections.reverse(scores);
		int count = 0;
		for(Integer score:scores) { 
			highscores.add(names.get(score) + " - " + score);
			count++; 
			if(count == 3) { 
				return highscores;
			}
		}
		
		return highscores;
	}


}
