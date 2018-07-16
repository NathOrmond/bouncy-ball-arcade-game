package gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import resources.Resources;
import runtime.StartingPoint;

public class Ball {

	private double dx = 0;
	private double dy = 0;
	private int radius = 20;
	private double gravity = 15;
	private double energyLoss = 1;
	private double dt = .2;
	private double xFriction = .9;
	private int x = 400;
	private int y = radius + 1;
	private double gameDy = -80;
	private int agility = 3;
	private int maxSpeed = 20;
	private boolean gameOver;
	private StartingPoint sp;

	public Ball() {
	}

	public Ball(int i, int j) {
		x = i;
		y = j;
	}

	/**
	 * Moves ball to the right 
	 * by a factor of agility
	 */
	public void moveRight() {
		if (dx + agility < maxSpeed) {
			dx += agility;
		}
	}

	/**
	 * Moves ball to the left by a factor
	 * of agility
	 */
	public void moveLeft() {
		if (dx - agility > -maxSpeed) {
			dx -= agility;
		}
	}
	
	/**
	 * stops lateral movement on ball
	 * by setting delta y and delta x to 0
	 */
	public void stopLateralMovement() { 
		dx = 0; 
		dy = 0;
	}

	public void update(StartingPoint sp) {
		this.sp = sp;
		
		/** Horizontal wall collisions **/
		
		if (x + dx > sp.getWidth() - radius - 1) {
			x = sp.getWidth() - radius - 1;
			dx = -dx;

		}
		if (x + dx < 0 + radius + 1) {
			x = 0 + radius + 1;
			dx = -dx;
		} else {
			x += dx;
		}

		
		/** Vertical wall collisions **/
		
		if (y == sp.getHeight() - radius - 1) {
			dx *= xFriction;
			if (Math.abs(dx) < .8) {
				dx = 0;
			}
		}
		if (y - 100 > sp.getHeight() - radius - 1) {
			
			gameOver = true;
//			bounceOffYBoundary();

		} else {
			dy = dy + gravity * dt;
			y += dy * dt + .5 * gravity * dt * dt;
		}
	
	}
	
	private void bounceOffYBoundary() { 
		y = sp.getHeight() - radius - 1;
		dy *= energyLoss;
		dy = -dy;
		Resources.bounce.play();
	}

	public void paint(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	/**************************************************
	 * GETTERS AND SETTERS
	 **************************************************/

	public int getX() {
		return x;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public int getRadius() {
		return radius;
	}

	public double getGameDy() {
		return gameDy;
	}

	public void setGameDy(double gameDy) {
		this.gameDy = gameDy;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	/**
	 * --------------------------------------------
	 */

}
