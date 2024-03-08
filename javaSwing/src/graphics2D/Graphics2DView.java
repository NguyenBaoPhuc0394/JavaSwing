package graphics2D;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Graphics2DView extends JFrame{
	public Graphics2DView() {
		MyPanel panel = new MyPanel();
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Graphics2DView();
	}
}
