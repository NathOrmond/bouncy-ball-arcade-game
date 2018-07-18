package leaderboard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import resources.Resources;

public class WriteToLeaderFile {
	
	
	public WriteToLeaderFile(){

	}
	
	/**
	 * Appends to end of leaderboard csv name and score values
	 * 
	 * @param name
	 * @param score
	 */
	  public void appendLeaderBoard(String name, String score) {
		  String line = name + "," + score;
	        try { 
	            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Resources.leaderTable, true)));
	            out.println(line + ",");
	            out.flush();
	            out.close();
	          }
	          catch (IOException e) {  
	            
	          }
	    }

}
