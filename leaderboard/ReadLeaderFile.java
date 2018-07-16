package leaderboard;

import java.io.FileNotFoundException;
import java.util.Scanner;

import resources.Resources;

public class ReadLeaderFile {
	
	public ReadLeaderFile(){ 
		
	}
	
	public void readFileTokens() throws FileNotFoundException { 
		Scanner scanner = new Scanner(Resources.leaderTable);
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
	}
	
	public void getTopLeaderBoardResults() { 
		
	}

}
