package gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import resources.Resources;

public class GravDown extends Item {

	private int increment = 3;
	
	public GravDown(int x) {
		super(x);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		super.paint(g);
	}
	
	@Override
	public void performAction(Ball ball) {
		if(ball.getGravity() > increment) {
			ball.setGravity(ball.getGravity() - increment);
		} else { 
			ball.setGravity(increment);
		}
	}

}
