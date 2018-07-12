package resources;

import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;

import runtime.StartingPoint;

public class Resources {

	public static StartingPoint sp;
	public static Image platform;
	static Image ball;
	URL url;
	public static AudioClip music, bounce, goodItem, badItem;
	public static int level = 1;

	public Resources(StartingPoint sp) {
		this.sp = sp;
		resetURL();
		platformSkin();
		audioResources();
	}
	
	private void audioResources() { 
		resetURL();
		music = sp.getAudioClip(url, "resources/audio/all_star.au");
		bounce = sp.getAudioClip(url, "resources/audio/ball_bounce.au");
		goodItem = sp.getAudioClip(url, "resources/audio/wand_chime.au");
		badItem = sp.getAudioClip(url, "resources/audio/bomb_siren.au");
	}
	
	private void platformSkin() { 
		platform = sp.getImage(url, "resources/skins/bricks.png");
		resetURL();
	}

	private void resetURL() {
		try {
			url = sp.getDocumentBase();
		} catch (Exception e) {
		}
	}

}
