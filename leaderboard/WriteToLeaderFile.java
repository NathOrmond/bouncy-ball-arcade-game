package leaderboard;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import resources.Resources;

public class WriteToLeaderFile {
	
	public WriteToLeaderFile() {
		// TODO Auto-generated constructor stub
	}
	
	  public void appendLeaderBoard(String line) {
	        try {
	            FileOutputStream is = new FileOutputStream(Resources.leaderTable);
	            OutputStreamWriter osw = new OutputStreamWriter(is);    
	            Writer w = new BufferedWriter(osw);
	            w.append(line + "\n");
	            w.close();
	        } catch (IOException e) {
	            System.err.println("Problem writing to the file statsTest.txt");
	        }
	    }

}
