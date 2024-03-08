package pongGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	static final int WIDTH = 1000;
	static final int HEIGHT = (int)(WIDTH*(5*1.0/9));
	static final Dimension SCREEN = new Dimension(WIDTH,HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1,paddle2;
	Ball ball;
	Score score;
	
	public GamePanel() {
		newPaddles();
		newBalls();
		score = new Score(WIDTH,HEIGHT);
		
		this.setPreferredSize(SCREEN);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void newBalls() {
		random = new Random();
		ball = new Ball((WIDTH/2 - BALL_DIAMETER/2),random.nextInt(HEIGHT - BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	public void newPaddles() {
		paddle1 = new Paddle(0, (HEIGHT/2 - PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(WIDTH - PADDLE_WIDTH, HEIGHT/2 - PADDLE_HEIGHT/2, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	public void checkCollision() {
		//Ball
		if(ball.y <= 0)
			ball.setYDirection(-ball.yVelocity);
		if(ball.y >= HEIGHT - BALL_DIAMETER)
			ball.setYDirection(-ball.yVelocity);
		
		//check ball and paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; //optional for more difficulty
			if(ball.yVelocity>0)
				ball.yVelocity++; //optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		//Paddle
		if(paddle1.y <= 0)
			paddle1.y = 0;
		if(paddle1.y >= HEIGHT - PADDLE_HEIGHT)
			paddle1.y = HEIGHT - PADDLE_HEIGHT;
		if(paddle2.y <= 0)
			paddle2.y = 0;
		if(paddle2.y >= HEIGHT - PADDLE_HEIGHT)
			paddle2.y = HEIGHT - PADDLE_HEIGHT;
		
		//give a player 1 point and create a new ball
		if(ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBalls();
			System.out.println("player 2: " + score.player2);
		}
		if(ball.x >= WIDTH - BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBalls();
			System.out.println("player 1: " + score.player1);
		}
	}
	
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}
