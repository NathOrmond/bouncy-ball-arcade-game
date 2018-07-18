package resources;

import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;

import runtime.StartingPoint;

/***
 * 
 * Acts as pointer to resource variables such as skins,
 * images and audio. called upon start of programme from StartingPoint 
 * class where variables are initialised within constructor.
 * 
 * @author Nathan Ormond
 *
 */

public class Resources {

	public static StartingPoint sp;
	public static Image platform, ball, backGroundImage;
	URL url;
	public static AudioClip music, bounce, goodItem, badItem;
	public static int level = 1;
	public static String leaderTable;

	public Resources(StartingPoint sp) {
		Resources.sp = sp;
		resetURL();
		imageResources();
		audioResources();
		fileResources();
	}
	
	private void audioResources() { 
		music = sp.getAudioClip(url, "resources/audio/all_star.au");
		bounce = sp.getAudioClip(url, "resources/audio/ball_bounce.au");
		goodItem = sp.getAudioClip(url, "resources/audio/wand_chime.au");
		badItem = sp.getAudioClip(url, "resources/audio/bomb_siren.au");
	}
	
	private void imageResources() { 
		platform = sp.getImage(url, "resources/skins/bricks.png");
		backGroundImage = sp.getImage(url, "resources/images/metropolis.png");
	}
	
	private void fileResources() { 
		leaderTable = System.getProperty("user.dir") + "/../src/resources/persistent/scores/leadertable.csv";
	}
	

	private void resetURL() {
		try {
			url = sp.getDocumentBase();
		} catch (Exception e) {
		}
	}

}
