package gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import resources.Resources;
import runtime.StartingPoint;

public class ScoreUp extends Item {

	private StartingPoint sp;
	
	public ScoreUp(int x, StartingPoint sp) {
		super(x);
		this.sp = sp;
	}
	
	@Override
	public void performAction(Ball ball) {
		Random r = new Random(); 
		sp.setScore(sp.getScore() + 500 +  r.nextInt(2000));
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		super.paint(g);
	}

}
