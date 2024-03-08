package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class View extends JPanel{
	public View() {
		this.setLayout(null);
		this.setBackground(Color.white);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.draw3DRect(100, 200, 50, 70, true);
		
		g.setColor(Color.red);
		g.drawLine(60, 60, 100, 150);
		
		g.setColor(Color.green);
//		g.drawOval(60, 60, 100, 150);
		g.fillOval(60, 60, 100, 150);
		
		g.setColor(Color.DARK_GRAY);
		g.drawArc(160, 160, 100, 150,160,160);
		
		g.setColor(Color.pink);
		g.drawString("JAVA", 100, 150);
	}
	
}
