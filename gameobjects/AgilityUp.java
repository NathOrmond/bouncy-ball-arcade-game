package gameobjects;

import java.awt.Color;
import java.awt.Graphics;

public class AgilityUp extends Item {

	private int increment = 1;
	
	public AgilityUp(int x) {
		super(x);
	}

	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		super.paint(g);
	}
	
	@Override
	public void performAction(Ball ball) {
		ball.setAgility(ball.getAgility() + increment);
	}
	
}
