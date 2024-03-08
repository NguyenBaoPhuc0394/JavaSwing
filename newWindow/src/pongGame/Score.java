package pongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle{
	static int WIDTH;
	static int HEIGHT;
	int player1;
	int player2;
	
	
	public Score(int w,int h) {
		WIDTH = w;
		HEIGHT = h;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));
		g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
		
		g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), WIDTH/2 - 85, 50);
		g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), WIDTH/2 + 20, 50);
	}
}
