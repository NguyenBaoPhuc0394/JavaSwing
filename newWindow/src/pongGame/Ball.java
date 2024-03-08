package pongGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 3;
	
	public Ball(int x,int y,int w,int h) {
		super(x,y,w,h);
		random = new Random();
		int randomX = random.nextInt(2);
		if(randomX == 0) {
			randomX--;
		}
		setXDirection(randomX*initialSpeed);
		
		int randomY = random.nextInt(2);
		if(randomY == 0) {
			randomY--;
		}
		setYDirection(randomY*initialSpeed);
	}
	
	public void setXDirection(int randomX) {
		xVelocity = randomX;
	}
	
	public void setYDirection(int randomY) {
		yVelocity = randomY;
	}
	
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
	
	
}
