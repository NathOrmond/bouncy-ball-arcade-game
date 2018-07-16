package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

import resources.Resources;
import runtime.StartingPoint;

public class Platform {

	private int dx;
	private int x, y, width, height;
	Image platform;
	URL url;
	float frame = 0;

	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		width = 150;
		height = 40;
		dx = -1;
		platform = Resources.platform;
	}

	public void update(StartingPoint sp, Ball b) {
		int tester = (int)(frame + .05);
		if(tester < 3) { 
			frame += .05;
		} else { 
			frame = 0;
		}
		
		x += - (Resources.level);
		checkForCollision(b);
		if (x < 0 - width) {
			Random r = new Random();
			y = sp.getHeight() - 40 - r.nextInt(400);
			x = sp.getWidth() + r.nextInt(300);
		}

	}

	private void checkForCollision(Ball b) {
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();

		if ((ballY + radius) > y && (ballY + radius) < (y + height)) {
			if (ballX > x && ballX < x + width) {
				double newDY = b.getGameDy();
				b.setY(y - radius);
				b.setDy(newDY);
				Resources.bounce.play();
			}
		}

	}

	public void paint(Graphics g) {

		int scaleFactor = 1;

		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
//		g.drawImage(platform, x, y, Pictures.sp);
		g.drawImage(platform, x, y, (x + scaleFactor * width), (y + scaleFactor * height), 0, 40 * (int) frame, 120, 40 * (int) frame + 40, Resources.sp);

	}

	/**************************************************
	 * GETTERS AND SETTERS
	 **************************************************/

}
