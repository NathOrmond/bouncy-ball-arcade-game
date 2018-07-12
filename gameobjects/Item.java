package gameobjects;

import java.awt.Graphics;
import java.util.Random;
import runtime.StartingPoint;

public class Item {

	
	private int x, y, dx, dy, radius;
	private boolean createNew = false;
	
	
	public Item(int x) {
		this.x = x; 
		radius = 10;
		Random r = new Random();
		y = r.nextInt(400) + radius;
		dx = -2;
		dy = 0;
		
	}
	
	public void update(StartingPoint sp, Ball ball) {
		x += dx;
		y+=dy;
		checkForCollision(ball);
		if (x < 0 - radius) {
			createNew = true;
		}

	}

	private void checkForCollision(Ball ball) {
		
		int ballX = ball.getX();
		int ballY = ball.getY();
		int radius = ball.getRadius();
		
		int a = this.x - ballX; 
		int b = this.y - ballY;
		int collide = this.radius = radius;
		
		double c = Math.sqrt(((a*a)+(b*b)));
		
		if(c <= collide) { 
			performAction(ball);
			createNew = true;
		}
	}

	public void performAction(Ball ball) {
	}

	public void paint(Graphics g) {
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	/**************************************************
	 * GETTERS AND SETTERS
	 **************************************************/
	
	public int getY() {
		return y;
	}
	
	public boolean isCreateNew() {
		return createNew;
	}
	
	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}

}
