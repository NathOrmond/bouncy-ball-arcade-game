package leaderboard;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import resources.Resources;

public class ReadLeaderFile {
	
	Map<Integer, Integer> Scores;
	int lineCount;
	
	public ReadLeaderFile(){ 
		Scores = new HashMap<Integer, Integer>();
	}
	
	public void readFileTokens() throws FileNotFoundException { 
		Scanner scanner = new Scanner(Resources.leaderTable);
		lineCount = 0;
		int rowCount = 0;
        scanner.useDelimiter(",");
        String token = "";
        while(scanner.hasNext()){
        	rowCount++;
        	token = scanner.next();
        	if(token.equals("\n")) { 
        		lineCount ++; 
        		rowCount = 0;
        	}
        	if(rowCount ==2) { 
        		Scores.put(lineCount, Integer.parseInt(token));
        	}
            System.out.print(token+"|");
        }
        
        
        scanner.close();
	}
	
	public void getTopLeaderBoardResults() { 
		
	}

}
