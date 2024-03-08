package animation2D;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{
	Image java;
	Image bg;
	Timer timer;
	int V1 = 1;
	int V2 = 1;
	int x = 0;
	int y = 0;
	public MyPanel() {
		this.setPreferredSize(new Dimension(400,400));
		this.setBackground(Color.black);
		java = new ImageIcon("icons8-java-48.png").getImage();
		timer = new Timer(10, this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(java, x,y,null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(x >= 400 - java.getWidth(null) || x < 0) {
			V1 = V1 * -1;
		}
		if(y >= 400 - java.getHeight(null) || y < 0) {
			V2 = V2 * -1;
		}
		x += V1;
		y += V2;
		repaint();
	}
	
}
