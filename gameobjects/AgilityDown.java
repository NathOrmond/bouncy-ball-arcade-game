package gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import resources.Resources;

public class AgilityDown extends Item {

	private int increment = 1;
	
	public AgilityDown(int x) {
		super(x);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		super.paint(g);
	}
	
	@Override
	public void performAction(Ball ball) {
		if(ball.getAgility() > increment) {
			ball.setAgility(ball.getAgility() - increment);
		} else { 
			ball.setAgility(increment);
		}
	}

}
