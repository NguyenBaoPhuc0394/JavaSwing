package pongGame;

import java.awt.Color;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	GamePanel panel;
	
	public GameFrame() {
		panel = new GamePanel();
		this.setTitle("Ping Pong");
		this.setResizable(false);
		
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}
