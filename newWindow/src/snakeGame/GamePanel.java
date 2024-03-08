package snakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGH = 600;
	static final int SIZE_UNIT = 25;
	static final int GAME_UNITS = (SCREEN_HEIGH*SCREEN_WIDTH) / (SIZE_UNIT*SIZE_UNIT);
	static final int DELAY = 100;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	
	public GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGH));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
		
	}
	
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	public void paintComponent(Graphics g) {//ghi dung paintComponent
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if(running) {
			//ve cac duong ngang doc
			for(int i = 0;i < SCREEN_HEIGH/SIZE_UNIT;i++) {
				g.drawLine(i*SIZE_UNIT, 0, i*SIZE_UNIT, SCREEN_HEIGH);
				g.drawLine(0, i*SIZE_UNIT, SCREEN_WIDTH, i*SIZE_UNIT);
			}
			//ve qua tao
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, SIZE_UNIT, SIZE_UNIT);
			//ve con ran
			for(int i = 0;i < bodyParts;i++) {
				if(i==0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], SIZE_UNIT, SIZE_UNIT);
				}
				else {
					g.setColor(new Color(45,180,0));
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					g.fillRect(x[i], y[i], SIZE_UNIT, SIZE_UNIT);
				}
			}
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Ink Free", Font.BOLD, 50));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());
		}	
		else
			gameOver(g);
	}
	
	public void move() {
		for(int i = bodyParts;i > 0;i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		switch(direction) {
			case 'U':
				y[0] = y[0] - SIZE_UNIT;
				break;
			case 'D':
				y[0] = y[0] + SIZE_UNIT;
				break;
			case 'L':
				x[0] = x[0] - SIZE_UNIT;
				break;
			case 'R':
				x[0] = x[0] + SIZE_UNIT;
				break;
		}
	}
	
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/SIZE_UNIT))*SIZE_UNIT;
		appleY = random.nextInt((int)(SCREEN_HEIGH/SIZE_UNIT))*SIZE_UNIT;
	}
	
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	
	public void checkCollision() {
		//kime tra neu dau va cham voi than
		for(int i = bodyParts;i > 0;i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		//kiem tra dau voi vieng trai
		if(x[0] < 0)
			running = false;
		//kiem tra dau voi vieng phai
		if(x[0] >= SCREEN_WIDTH)
			running = false;
		//kiem tra dau voi vieng tren
		if(y[0] < 0)
			running = false;
		//kiem tra dau voi vieng duoi
		if(y[0] >= SCREEN_HEIGH)
			running = false;
		if(!running)
			timer.stop();
	}
	
	public void gameOver(Graphics g) {
		g.setColor(Color.ORANGE);
		g.setFont(new Font("Ink Free", Font.BOLD, 50));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());
		//
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGH/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkApple();
			checkCollision();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(direction != 'R')
						direction = 'L';
					break;
				case KeyEvent.VK_RIGHT:
					if(direction != 'L')
						direction = 'R';
					break;
				case KeyEvent.VK_UP:
					if(direction != 'D')
						direction = 'U';
					break;
				case KeyEvent.VK_DOWN:
					if(direction != 'U')
						direction = 'D';
					break;
			}
		}
	}

}
